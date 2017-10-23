package za.ac.cput.accommodationapp.restapi.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.accommodationapp.domain.Administrator;
import za.ac.cput.accommodationapp.restapi.RestAPI;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestAdminApi implements RestAPI
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Administrator get(Long id) {
        final String url = BASE_URL+"admnistrator/"+id.toString();
        HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(requestHeaders);
        ResponseEntity<Administrator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Administrator.class);
        Administrator administrator = responseEntity.getBody();
        return administrator;
    }

    @Override
    public String post(Administrator entity) {
        final String url = BASE_URL+"admnistrator/create";
        HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Administrator entity) {
        final String url = BASE_URL+"admnistrator/update/"+entity.getId().toString();
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
        List<Administrator> adminList = new ArrayList<>();
        final String url = BASE_URL+"admnistrator/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Administrator[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Administrator[].class);
        Administrator[] results = responseEntity.getBody();

        for (Administrator administrator : results) {
            adminList.add(administrator);
        }
        return adminList;
    }
}
