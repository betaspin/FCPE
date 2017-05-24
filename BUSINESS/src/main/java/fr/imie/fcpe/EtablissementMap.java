package fr.imie.fcpe;

import java.util.ArrayList;
import java.util.List;

public class EtablissementMap {

    public static EtablissementBO mapEtablissementEntityToBO(EtablissementEntity etablissementEntity){
        EtablissementBO etablissementBO = new EtablissementBO();
        etablissementBO.setId(etablissementEntity.getId());
        etablissementBO.setNom(etablissementEntity.getNom());
        etablissementBO.setVille(etablissementEntity.getVille());
        etablissementBO.setArchive(etablissementEntity.getArchive());

        // Mapping types
        List<TypeEtablissementBO> typesBO = new ArrayList<>();
        List<TypeEtablissementEntity> typesEntity = etablissementEntity.getTypes();
        for(TypeEtablissementEntity typeEntity : typesEntity){

        }
        etablissementBO.setTypes(typesBO);

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
