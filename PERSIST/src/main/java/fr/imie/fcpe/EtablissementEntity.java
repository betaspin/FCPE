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
}
