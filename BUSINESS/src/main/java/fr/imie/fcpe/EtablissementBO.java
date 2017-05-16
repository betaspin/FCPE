package fr.imie.fcpe;

public class EtablissementBO {
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

    public static EtablissementBO mapEtablissementEntityToBO(EtablissementEntity etablissementEntity){
        EtablissementBO etablissementBO = new EtablissementBO();
        etablissementBO.setId(etablissementEntity.getId());
        etablissementBO.setNom(etablissementEntity.getNom());
        etablissementBO.setVille(etablissementEntity.getVille());
        return etablissementBO;
    }

    public static EtablissementEntity mapEtablissementBOToEntity(EtablissementBO etablissement){
        EtablissementEntity etablissementEntity = new EtablissementEntity();
        if(etablissement.getId() != null){
         etablissementEntity.setId(etablissement.getId());
        }
        etablissementEntity.setNom(etablissement.getNom());
        etablissementEntity.setVille(etablissement.getVille());
        return etablissementEntity;
    }
}