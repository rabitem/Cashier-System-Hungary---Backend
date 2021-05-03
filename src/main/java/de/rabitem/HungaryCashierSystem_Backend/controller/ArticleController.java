package de.rabitem.HungaryCashierSystem_Backend.controller;

import de.rabitem.HungaryCashierSystem_Backend.entities.Article;
import de.rabitem.HungaryCashierSystem_Backend.entities.Position;
import de.rabitem.HungaryCashierSystem_Backend.entities.Sale;
import de.rabitem.HungaryCashierSystem_Backend.repositories.ArticleRepository;
import de.rabitem.HungaryCashierSystem_Backend.repositories.PositionRepository;
import de.rabitem.HungaryCashierSystem_Backend.repositories.SaleRepository;
import de.rabitem.HungaryCashierSystem_Backend.request.PositionRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.sql.Date;
import java.util.*;

@RestController
public class ArticleController {

    private final SaleRepository saleRepository;
    private final ArticleRepository articleRepository;
    private final PositionRepository positionRepository;

    public ArticleController(final SaleRepository saleRepository, ArticleRepository articleRepository,
                             PositionRepository positionRepository) {
        this.saleRepository = saleRepository;
        this.articleRepository = articleRepository;
        this.positionRepository = positionRepository;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/getArticle")
    public ResponseEntity<List<Article>> getAllArticle() {
        return ResponseEntity.ok(articleRepository.findAll());
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/addPosition")
    public ResponseEntity<Object> addPosition(@Valid @RequestBody final PositionRequest positionRequest) {
        var position = new Position();
        position.setMenge(positionRequest.getMenge());
        position.setVerkaufspreis(positionRequest.getVerkaufspreis());
        // id article actually references the code - bad naming convention, might change later
        var article = articleRepository.findByArtikelcode(positionRequest.getIdArticle());

        if (article.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while adding Position! Could not find " +
                    "Article!");
        }

        position.setIdarticle(article.get().getId());

        var sale = saleRepository.findByDatum(new Date(Calendar.getInstance().getTime().getTime()));
        if (sale.isEmpty()) {
            sale = Optional.of(new Sale());
            sale.get().setDatum(new Date(Calendar.getInstance().getTime().getTime()));
            saleRepository.save(sale.get());
        }
        position.setIdsale(sale.get().getId());
        positionRepository.save(position);

        return ResponseEntity.ok(article.get());
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/deletePosition")
    public ResponseEntity<Position> deletePosition(@NotNull(message = "Id can not be null!")
                                                   @Positive(message = "Id must be greater than 0!")
                                                   @RequestParam(value = "id", required = true) final int id) {
        Optional<Position> position = positionRepository.findById(id);
        if (position.isPresent()) {
            positionRepository.delete(position.get());
            return ResponseEntity.ok(position.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/getPositionsByDate")
    public ResponseEntity<List<Position>> getPositionByDate(@NotNull(message = "Date can not be null!")
                                                            @PastOrPresent(message = "Date must be in the past or present!")
                                                            @RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date date) {
        var todaySale = saleRepository.findByDatum(date);
        if (todaySale.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var positionsToday = positionRepository.findAllByIdsale(todaySale.get().getId());
        if (positionsToday.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(positionsToday.get());
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/getArticleById")
    public ResponseEntity<Article> getArticleById(@NotNull(message = "Id can not be null!")
                                                  @Positive(message = "Id must be greater than 0!")
                                                  @RequestParam(value = "id", required = true) int id) {
        var article = articleRepository.findById(id);
        if (article.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(article.get());
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/getSaleById")
    public ResponseEntity<Sale> getSaleById(@NotNull(message = "Id can not be null!")
                                            @Positive(message = "Id must be greater than 0!")
                                            @RequestParam(value = "id", required = true) int id) {
        var sale = saleRepository.findById(id);
        if (sale.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sale.get());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(final MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
