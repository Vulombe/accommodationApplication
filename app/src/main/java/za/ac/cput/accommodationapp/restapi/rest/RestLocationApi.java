package za.ac.cput.accommodationapp.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http.HttpMethod;
import za.ac.cput.accommodationapp.domain.Location;
import za.ac.cput.accommodationapp.restapi.RestAPI;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestLocationApi implements RestAPI
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Location get(Long id) {
        final String url = BASE_URL+"location/"+id.toString();
        HttpEntity<Location> requestEntity = new HttpEntity<Location>(requestHeaders);
        ResponseEntity<Location> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Location.class);
        Location location = responseEntity.getBody();
        return location;
    }

    @Override
    public String post(Location entity) {
        final String url = BASE_URL+"location/create";
        HttpEntity<Location> requestEntity = new HttpEntity<Location>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Location entity) {
        final String url = BASE_URL+"location/update/"+entity.getId().toString();
        HttpEntity<Location> requestEntity = new HttpEntity<Location>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Location entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Location> requestEntity = new HttpEntity<Location>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Location> getAll() {
        List<Location> locationsList = new ArrayList<>();
        final String url = BASE_URL+"location/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Location[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Location[].class);
        Location[] results = responseEntity.getBody();

        for (Location locations : results) {
            locationsList.add(locations);
        }
        return locationsList;
    }
}
