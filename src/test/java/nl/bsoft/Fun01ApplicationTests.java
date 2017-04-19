package nl.bsoft;

import nl.bsoft.fun01.FunReader;
import nl.bsoft.fun01.FunResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ItemReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Fun01ApplicationTests {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ItemReader<FunResponse> funReader(String url,
                                      RestTemplate restTemplate) {
        return new FunReader(
                url,
                restTemplate
        );
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testReader() {
        String url = "http://partnerapi.funda.nl/feeds/Aanbod.svc/json/a001e6c3ee6e4853ab18fe44cc1494de/?type=koop&zo=/veenendaal/appartement/&page=";

        //ItemReader<FunResponse> reader = funReader(url, restTemplate());
        boolean getMore = true;

        FunResponse fobj = null;

        int page = 1;

        while (getMore) {
            String myUrl = url + Integer.toString(page);
            ItemReader<FunResponse> reader = funReader(myUrl, restTemplate());

            try {
                fobj = reader.read();
                System.out.println("Aantal paginas: " + fobj.getPaging().getAantalPaginas());
                System.out.println("Huidige pagina: " + fobj.getPaging().getHuidigePagina());
                System.out.println("Volgende pagina: " + fobj.getPaging().getVolgendeUrl());
                page++;
            } catch (Exception e) {
                getMore = false;
            }
        }
    }

}
