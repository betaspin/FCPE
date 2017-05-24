package fr.imie.fcpe.service;

import java.util.List;

public class EtablissementWO {
    private Integer id;
    private String nom;
    private String numVoie;
    private String voie;
    private String codePostal;
    private String ville;
    private List<TypeEtablissementWO> types;

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
    public List<TypeEtablissementWO> getTypes() { return types; }
    public void setTypes(List<TypeEtablissementWO> types) { this.types = types; }
}
