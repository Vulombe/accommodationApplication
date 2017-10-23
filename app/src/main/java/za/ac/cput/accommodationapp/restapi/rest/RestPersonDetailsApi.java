package za.ac.cput.accommodationapp.restapi.rest;

import org.apache.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http.HttpMethod;
import za.ac.cput.accommodationapp.domain.PersonDetails;
import za.ac.cput.accommodationapp.restapi.RestAPI;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestPersonDetailsApi implements RestAPI
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public PersonDetails get(Long id) {
        final String url = BASE_URL+"persondetails/"+id.toString();
        HttpEntity<PersonDetails> requestEntity = new HttpEntity<PersonDetails>(requestHeaders);
        ResponseEntity<PersonDetails> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PersonDetails.class);
        PersonDetails personDetails = responseEntity.getBody();
        return personDetails;
    }

    @Override
    public String post(PersonDetails entity) {
        final String url = BASE_URL+"persondetails/create";
        HttpEntity<PersonDetails> requestEntity = new HttpEntity<PersonDetails>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(PersonDetails entity) {
        final String url = BASE_URL+"persondetails/update/"+entity.getId().toString();
        HttpEntity<PersonDetails> requestEntity = new HttpEntity<PersonDetails>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(PersonDetails entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<PersonDetails> requestEntity = new HttpEntity<PersonDetails>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<PersonDetails> getAll() {
        List<PersonDetails> personDetailsList = new ArrayList<>();
        final String url = BASE_URL+"persondetails/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<PersonDetails[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PersonDetails[].class);
        PersonDetails[] results = responseEntity.getBody();

        for (PersonDetails personDetails : results) {
            personDetailsList.add(personDetails);
        }
        return personDetailsList;
    }
}
