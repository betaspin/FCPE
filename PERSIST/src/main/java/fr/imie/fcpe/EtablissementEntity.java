package fr.imie.fcpe;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="EtablissementEntity.findAll", query="SELECT e FROM EtablissementEntity e"),
        @NamedQuery(name="EtablissementEntity.findOne", query="SELECT e FROM EtablissementEntity e WHERE e.id =:id")
})
@Table(name = "etablissement")
public class EtablissementEntity implements Serializable{
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

    private String nom;
    public String getNom(){ return nom; }
    public void setNom(String nom) { this.nom = nom; }

    private String ville;
    public String getVille() { return ville; }
    public void setVille(String ville) {
        this.ville = ville;
    }
}
