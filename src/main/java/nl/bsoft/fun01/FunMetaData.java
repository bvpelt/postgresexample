package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bvpelt on 4/15/17.
 */
public class FunMetaData {
    @JsonProperty(value = "ObjectType")
    private String objectType;            //: "Koopwoningen",

    @JsonProperty(value = "Omschrijving")
    private String omschrijving;          //: "Koopwoningen > Veenendaal | Appartement",

    @JsonProperty(value = "Titel")
    private String titel;                 //: "Appartementen te koop in Veenendaal"

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
