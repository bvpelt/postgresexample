package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bvpelt on 4/15/17.
 */
public class FunPaging {
    @JsonProperty(value = "AantalPaginas")
    private Integer aantalPaginas; //: 10,

    @JsonProperty(value = "HuidigePagina")
    private Integer huidigePagina; //: 1,

    @JsonProperty(value = "VolgendeUrl")
    private String volgendeUrl;    //: "/~/koop/veenendaal/appartement/p2/",

    @JsonProperty(value = "VorigeUrl")
    private String vorigeUrl;      //: null

    public Integer getAantalPaginas() {
        return aantalPaginas;
    }

    public void setAantalPaginas(Integer aantalPaginas) {
        this.aantalPaginas = aantalPaginas;
    }

    public Integer getHuidigePagina() {
        return huidigePagina;
    }

    public void setHuidigePagina(Integer huidigePagina) {
        this.huidigePagina = huidigePagina;
    }

    public String getVolgendeUrl() {
        return volgendeUrl;
    }

    public void setVolgendeUrl(String volgendeUrl) {
        this.volgendeUrl = volgendeUrl;
    }

    public String getVorigeUrl() {
        return vorigeUrl;
    }

    public void setVorigeUrl(String vorigeUrl) {
        this.vorigeUrl = vorigeUrl;
    }
}
