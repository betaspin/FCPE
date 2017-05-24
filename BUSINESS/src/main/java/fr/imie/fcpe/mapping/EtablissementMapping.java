package fr.imie.fcpe.mapping;

import java.util.ArrayList;
import java.util.List;

import fr.imie.fcpe.EtablissementEntity;
import fr.imie.fcpe.TypeEtablissementEntity;
import fr.imie.fcpe.model.EtablissementBO;

public class EtablissementMapping {

    public static EtablissementBO mapEtablissementEntityToBO(EtablissementEntity etablissementEntity){
        EtablissementBO etablissementBO = new EtablissementBO();
        etablissementBO.setId(etablissementEntity.getId());
        etablissementBO.setNom(etablissementEntity.getNom());
        etablissementBO.setVille(etablissementEntity.getVille());
        etablissementBO.setArchive(etablissementEntity.getArchive());
        
        List<String> typesBO = new ArrayList<>();
        for (TypeEtablissementEntity type : etablissementEntity.getTypes()) {
        	typesBO.add(type.getLabel());
		}
        etablissementBO.setTypes(typesBO);
        return etablissementBO;
    }

    public static EtablissementEntity mapEtablissementBOToEntity(EtablissementBO etablissement, List<TypeEtablissementEntity> typesEtablissementEntity){
        EtablissementEntity etablissementEntity = new EtablissementEntity();
        etablissementEntity.setId(etablissement.getId());
        etablissementEntity.setNom(etablissement.getNom());
        etablissementEntity.setVille(etablissement.getVille());
        etablissementEntity.setArchive(etablissement.getArchive());
        etablissementEntity.setTypes(typesEtablissementEntity);
        
        return etablissementEntity;
    }

}
