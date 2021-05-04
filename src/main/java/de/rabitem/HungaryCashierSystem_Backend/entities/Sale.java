package de.rabitem.HungaryCashierSystem_Backend.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sale", schema = "cashier-system-hungary", catalog = "")
public class Sale {
    private int idSale;
    private Date date;

    @Id
    @Column(name = "idSale")
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale that = (Sale) o;

        if (idSale != that.idSale) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSale;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
