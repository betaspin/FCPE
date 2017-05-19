package fr.imie.fcpe;

/**
 * Created by betaspin on 18/05/17.
 */
public class EtablissementMap {

    public static EtablissementBO mapEtablissementEntityToBO(EtablissementEntity etablissementEntity){
        EtablissementBO etablissementBO = new EtablissementBO();
        etablissementBO.setId(etablissementEntity.getId());
        etablissementBO.setNom(etablissementEntity.getNom());
        etablissementBO.setVille(etablissementEntity.getVille());
        etablissementBO.setArchive(etablissementEntity.getArchive());
        etablissementBO.setTypes(etablissementEntity.getTypes());
        return etablissementBO;
    }

    public static EtablissementEntity mapEtablissementBOToEntity(EtablissementBO etablissement){
        EtablissementEntity etablissementEntity = new EtablissementEntity();
        etablissementEntity.setId(etablissement.getId());
        etablissementEntity.setNom(etablissement.getNom());
        etablissementEntity.setVille(etablissement.getVille());
        etablissementEntity.setArchive(etablissement.getArchive());
        return etablissementEntity;
    }

}
