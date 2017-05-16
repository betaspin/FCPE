package fr.imie.fcpe;

public class Etablissement {
    private Integer id;
    private String nom;
    private String numVoie;
    private String voie;
    private String codePostal;
    private String ville;

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

    public static Etablissement mapEtablissementBOToEtablissement(EtablissementBO etablissementBO){
        Etablissement etablissement = new Etablissement();
        etablissement.setId(etablissementBO.getId());
        etablissement.setNom(etablissementBO.getNom());
        etablissement.setVille(etablissementBO.getVille());
        return etablissement;
    }
}
