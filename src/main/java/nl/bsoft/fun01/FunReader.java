package nl.bsoft.fun01;

import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bvpelt on 4/15/17.
 */
public class FunReader implements ItemReader<FunResponse> {

    private final String apiUrl;
    private final RestTemplate restTemplate;
    private FunResponse funObjectData = null;

    public FunReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public FunResponse read() throws Exception {

        funObjectData = fetchFunResponseFromAPI();

        return funObjectData;
    }


    private FunResponse fetchFunResponseFromAPI() {

        ResponseEntity<FunResponse> response = restTemplate.getForEntity(
                apiUrl,
                FunResponse.class
        );

        FunResponse funData = response.getBody();

        return funData;
    }
}
