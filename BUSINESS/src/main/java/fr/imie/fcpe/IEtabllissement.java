package fr.imie.fcpe;


import java.util.List;

public interface IEtabllissement {

    public List<EtablissementBO> findAll();
    public EtablissementBO createEtablissement(EtablissementBO etablissement);
}
