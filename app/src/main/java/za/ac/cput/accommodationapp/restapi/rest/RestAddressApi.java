package za.ac.cput.accommodationapp.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.accommodationapp.domain.Address;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestAddressApi
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Address get(Long id) {
        final String url = BASE_URL+"about/"+id.toString();
        HttpEntity<Address> requestEntity = new HttpEntity<Address>(requestHeaders);
        ResponseEntity<Address> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Address.class);
        Address address = responseEntity.getBody();
        return address;
    }

    @Override
    public String post(Address entity) {
        final String url = BASE_URL+"about/create";
        HttpEntity<Address> requestEntity = new HttpEntity<Address>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Address entity) {
        final String url = BASE_URL+"about/update/"+entity.getId().toString();
        HttpEntity<Address> requestEntity = new HttpEntity<Address>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Address entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Address> requestEntity = new HttpEntity<Address>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Address> getAll() {
        List<Address> aboutList = new ArrayList<>();
        final String url = BASE_URL+"about/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Address[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Address[].class);
        Address[] results = responseEntity.getBody();

        for (Address address : results) {
            aboutList.add(address);
        }
        return aboutList;
    }
}
