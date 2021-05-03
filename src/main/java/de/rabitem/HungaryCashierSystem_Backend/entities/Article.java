package de.rabitem.HungaryCashierSystem_Backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARTICLE")
public class Article {
    @Id
    private int id;
    private int artikelcode;
    private String deutsche_Beschreibung;
    private String englische_Beschreibung;
    private String ungarische_Beschreibung;
    private Double listenpreis_pro_KG;
    private Integer menge_pro_Sack;
    private Integer stückzahl_pro_Sack;
}
