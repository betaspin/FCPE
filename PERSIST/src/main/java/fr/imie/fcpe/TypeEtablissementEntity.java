package fr.imie.fcpe;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "type_etablissement")
public class TypeEtablissementEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String label;
    public String getLabel(){ return label; }
    public void setLabel(String nom) { this.label = label; }
}
