package za.ac.cput.accommodationapp.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http.HttpMethod;
import za.ac.cput.accommodationapp.domain.Contacts;
import za.ac.cput.accommodationapp.restapi.RestAPI;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestContactsApi implements RestAPI
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Contacts get(Long id) {
        final String url = BASE_URL+"contacts/"+id.toString();
        HttpEntity<Contacts> requestEntity = new HttpEntity<Contacts>(requestHeaders);
        ResponseEntity<Administrator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Administrator.class);
        Contacts contact = responseEntity.getBody();
        return contact;
    }

    @Override
    public String post(Administrator entity) {
        final String url = BASE_URL+"contacts/create";
        HttpEntity<Contacts> requestEntity = new HttpEntity<Contacts>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Contacts entity) {
        final String url = BASE_URL+"contacts/update/"+entity.getId().toString();
        HttpEntity<Contacts> requestEntity = new HttpEntity<Contacts>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Contacts entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Contacts> requestEntity = new HttpEntity<Contacts>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Contacts> getAll() {
        List<Contacts> contactList = new ArrayList<>();
        final String url = BASE_URL+"contacts/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Contacts[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Contacts[].class);
        Contacts[] results = responseEntity.getBody();

        for (Contacts contacts : results) {
            contactList.add(contacts);
        }
        return contactList;
    }
}
