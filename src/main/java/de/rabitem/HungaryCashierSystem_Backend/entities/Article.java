package de.rabitem.HungaryCashierSystem_Backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "article", schema = "cashier-system-hungary", catalog = "")
public class Article {
    private int idArticle;
    private int articleCode;
    private String descGer;
    private String descEng;
    private String descHun;
    private Double pricePerKg;
    private Integer quantityPerBag;
    private Integer numberOfPiecesPerBag;

    @Id
    @Column(name = "idArticle")
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Basic
    @Column(name = "articleCode")
    public int getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(int articleCode) {
        this.articleCode = articleCode;
    }

    @Basic
    @Column(name = "desc_ger")
    public String getDescGer() {
        return descGer;
    }

    public void setDescGer(String descGer) {
        this.descGer = descGer;
    }

    @Basic
    @Column(name = "desc_eng")
    public String getDescEng() {
        return descEng;
    }

    public void setDescEng(String descEng) {
        this.descEng = descEng;
    }

    @Basic
    @Column(name = "desc_hun")
    public String getDescHun() {
        return descHun;
    }

    public void setDescHun(String descHun) {
        this.descHun = descHun;
    }

    @Basic
    @Column(name = "price_per_kg")
    public Double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Basic
    @Column(name = "quantity_per_bag")
    public Integer getQuantityPerBag() {
        return quantityPerBag;
    }

    public void setQuantityPerBag(Integer quantityPerBag) {
        this.quantityPerBag = quantityPerBag;
    }

    @Basic
    @Column(name = "number_of_pieces_per_bag")
    public Integer getNumberOfPiecesPerBag() {
        return numberOfPiecesPerBag;
    }

    public void setNumberOfPiecesPerBag(Integer numberOfPiecesPerBag) {
        this.numberOfPiecesPerBag = numberOfPiecesPerBag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article that = (Article) o;

        if (idArticle != that.idArticle) return false;
        if (articleCode != that.articleCode) return false;
        if (descGer != null ? !descGer.equals(that.descGer) : that.descGer != null) return false;
        if (descEng != null ? !descEng.equals(that.descEng) : that.descEng != null) return false;
        if (descHun != null ? !descHun.equals(that.descHun) : that.descHun != null) return false;
        if (pricePerKg != null ? !pricePerKg.equals(that.pricePerKg) : that.pricePerKg != null) return false;
        if (quantityPerBag != null ? !quantityPerBag.equals(that.quantityPerBag) : that.quantityPerBag != null)
            return false;
        if (numberOfPiecesPerBag != null ? !numberOfPiecesPerBag.equals(that.numberOfPiecesPerBag) : that.numberOfPiecesPerBag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle;
        result = 31 * result + articleCode;
        result = 31 * result + (descGer != null ? descGer.hashCode() : 0);
        result = 31 * result + (descEng != null ? descEng.hashCode() : 0);
        result = 31 * result + (descHun != null ? descHun.hashCode() : 0);
        result = 31 * result + (pricePerKg != null ? pricePerKg.hashCode() : 0);
        result = 31 * result + (quantityPerBag != null ? quantityPerBag.hashCode() : 0);
        result = 31 * result + (numberOfPiecesPerBag != null ? numberOfPiecesPerBag.hashCode() : 0);
        return result;
    }
}
