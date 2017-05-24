package fr.imie.fcpe.mapping;

import fr.imie.fcpe.EtablissementEntity;
import fr.imie.fcpe.TypeEtablissementEntity;
import fr.imie.fcpe.model.EtablissementBO;
import fr.imie.fcpe.model.TypeEtablissementBO;

import java.util.ArrayList;
import java.util.List;

public class EtablissementMapping {

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
            typesBO.add(TypeEtablissementMapping.mapTypeEtablissementEntityToBO(typeEntity));
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
