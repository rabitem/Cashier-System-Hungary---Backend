package de.rabitem.HungaryCashierSystem_Backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionRequest {
    @Positive(message = "Count must be greater than 0")
    @NotNull(message = "Count cannot be null")
    private int menge;

    @NotNull(message = "Selling price cannot be null")
    @Positive(message = "Selling price must be greater than 0")
    private double verkaufspreis;

    @NotNull(message = "Article Id cannot be null")
    @Positive(message = "Article Id does not match the correct Pattern")
    private int idArticle;
}
