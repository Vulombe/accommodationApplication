package za.ac.cput.accommodationapp.restapi.rest;

import org.apache.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http.HttpMethod;
import za.ac.cput.accommodationapp.domain.Room;
import za.ac.cput.accommodationapp.restapi.RestAPI;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestRoomApi implements RestAPI
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Room get(Long id) {
        final String url = BASE_URL+"room/"+id.toString();
        HttpEntity<Room> requestEntity = new HttpEntity<Room>(requestHeaders);
        ResponseEntity<Room> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Room.class);
        Room room = responseEntity.getBody();
        return room;
    }

    @Override
    public String post(Room entity) {
        final String url = BASE_URL+"room/create";
        HttpEntity<Address> requestEntity = new HttpEntity<Address>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Room entity) {
        final String url = BASE_URL+"room/update/"+entity.getId().toString();
        HttpEntity<Room> requestEntity = new HttpEntity<Room>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Room entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Room> requestEntity = new HttpEntity<Room>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Room> getAll() {
        List<Room> roomList = new ArrayList<>();
        final String url = BASE_URL+"room/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Room[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Room[].class);
        Room[] results = responseEntity.getBody();

        for (Room rooms : results) {
            roomList.add(address);
        }
        return roomList;
    }
}
