package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bvpelt on 4/15/17.
 */
public class FunResponse {
    private final Logger log = LoggerFactory.getLogger(FunResponse.class);

    @JsonProperty(value = "AccountStatus")
    private Integer accountStatus;             //: 0,

    @JsonProperty(value = "ValidationFailed")
    private Boolean validationFailed;          //: false,

    @JsonProperty(value = "ValidationReport")
    private String validationReport;           //: null,

    @JsonProperty(value = "Website")
    private Integer website;                   //: 0,

    @JsonProperty(value = "Metadata")
    private FunMetaData metadata;              /*:    {
        "ObjectType": "Koopwoningen",
                "Omschrijving": "Koopwoningen > Veenendaal | Appartement",
                "Titel": "Appartementen te koop in Veenendaal"
    },*/

    @JsonProperty(value = "Objects")
    private FunObject[] objects;               //:

    @JsonProperty(value = "Paging")
    private FunPaging paging;                  /*:    {
        "AantalPaginas": 10,
                "HuidigePagina": 1,
                "VolgendeUrl": "/~/koop/veenendaal/appartement/p2/",
                "VorigeUrl": null
    },*/

    @JsonProperty(value = "TotaalAantalObjecten")
    private Integer totaalAantalObjecten;       //: 145

    public String toJsonString() {
        String json = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("Cannot generate json: ", e);
        }

        return json;
    }
    // --- Getter and Setter

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Boolean getValidationFailed() {
        return validationFailed;
    }

    public void setValidationFailed(Boolean validationFailed) {
        this.validationFailed = validationFailed;
    }

    public String getValidationReport() {
        return validationReport;
    }

    public void setValidationReport(String validationReport) {
        this.validationReport = validationReport;
    }

    public Integer getWebsite() {
        return website;
    }

    public void setWebsite(Integer website) {
        this.website = website;
    }

    public FunMetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(FunMetaData metadata) {
        this.metadata = metadata;
    }

    public FunObject[] getObjects() {
        return objects;
    }

    public void setObjects(FunObject[] objects) {
        this.objects = objects;
    }

    public FunPaging getPaging() {
        return paging;
    }

    public void setPaging(FunPaging paging) {
        this.paging = paging;
    }

    public Integer getTotaalAantalObjecten() {
        return totaalAantalObjecten;
    }

    public void setTotaalAantalObjecten(Integer totaalAantalObjecten) {
        this.totaalAantalObjecten = totaalAantalObjecten;
    }
}
