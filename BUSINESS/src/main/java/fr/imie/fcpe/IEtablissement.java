package fr.imie.fcpe;


import javax.xml.ws.Response;
import java.util.List;

public interface IEtablissement {

    public EtablissementBO findOne(Integer idEtablissement);
    public List<EtablissementBO> findAll();
    public EtablissementBO createEtablissement(EtablissementBO etablissement);
    public EtablissementBO updateEtablissement(EtablissementBO etablissement);
    public EtablissementBO deleteEtablissement(EtablissementBO etablissement);

}
