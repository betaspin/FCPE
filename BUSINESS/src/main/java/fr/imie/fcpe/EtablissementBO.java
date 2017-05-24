package fr.imie.fcpe;

import java.util.List;

public class EtablissementBO {
    private Integer id;
    private String nom;
    private String numVoie;
    private String voie;
    private String codePostal;
    private String ville;
    private Boolean archive;
    private List<TypeEtablissementBO> types;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNumVoie() {
        return numVoie;
    }
    public void setNumVoie(String numVoie) {
        this.numVoie = numVoie;
    }
    public String getVoie() {
        return voie;
    }
    public void setVoie(String voie) {
        this.voie = voie;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public Boolean getArchive() { return archive; }
    public void setArchive(Boolean archive) { this.archive = archive; }
    public List<TypeEtablissementBO> getTypes() { return types; }
    public void setTypes(List<TypeEtablissementBO> types) { this.types = types; }
}