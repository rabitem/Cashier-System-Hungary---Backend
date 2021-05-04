package de.rabitem.HungaryCashierSystem_Backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "position", schema = "cashier-system-hungary", catalog = "")
public class Position {
    private int idPosition;
    private Integer count;
    private Double price;

    // TODO: map relationship
    private int idArticle;
    private int idSale;

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Id
    @Column(name = "idPosition")
    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        if (idPosition != that.idPosition) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPosition;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
