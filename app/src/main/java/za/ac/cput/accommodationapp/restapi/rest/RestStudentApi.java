package za.ac.cput.accommodationapp.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.accommodationapp.domain.Student;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestStudentApi {
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Student get(Long id) {
        final String url = BASE_URL+"about/"+id.toString();
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(requestHeaders);
        ResponseEntity<v> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student.class);
        Student student = responseEntity.getBody();
        return student;
    }

    @Override
    public String post(Student entity) {
        final String url = BASE_URL+"about/create";
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Student entity) {
        final String url = BASE_URL+"about/update/"+entity.getId().toString();
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Student entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Student> getAll() {
        List<Student> aboutList = new ArrayList<>();
        final String url = BASE_URL+"about/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Student[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student[].class);
        Student[] results = responseEntity.getBody();

        for (Student student : results) {
            aboutList.add(student);
        }
        return aboutList;
    }
}
