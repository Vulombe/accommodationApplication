package za.ac.cput.accommodationapp.restapi.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestLocationApi {
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Administrator get(Long id) {
        final String url = BASE_URL+"about/"+id.toString();
        HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(requestHeaders);
        ResponseEntity<Administrator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Administrator.class);
        Administrator administrator = responseEntity.getBody();
        return about;
    }

    @Override
    public String post(Administrator entity) {
        final String url = BASE_URL+"about/create";
        HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Administrator entity) {
        final String url = BASE_URL+"about/update/"+entity.getId().toString();
        HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Administrator entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Administrator> getAll() {
        List<Administrator> aboutList = new ArrayList<>();
        final String url = BASE_URL+"about/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Administrator[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Administrator[].class);
        Administrator[] results = responseEntity.getBody();

        for (Administrator administrator : results) {
            aboutList.add(administrator);
        }
        return aboutList;
    }
}
