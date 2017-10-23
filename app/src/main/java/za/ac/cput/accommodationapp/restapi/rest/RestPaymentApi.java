package za.ac.cput.accommodationapp.restapi.rest;

import org.apache.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http.HttpMethod;
import za.ac.cput.accommodationapp.domain.Payment;
import za.ac.cput.accommodationapp.restapi.RestAPI;

/**
 * Created by Katlego on 2017/10/16.
 */

public class RestPaymentApi implements RestAPI
{
    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Payment get(Long id) {
        final String url = BASE_URL+"payment/"+id.toString();
        HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(requestHeaders);
        ResponseEntity<Payment> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Payment.class);
        Payment payment = responseEntity.getBody();
        return payment;
    }

    @Override
    public String post(Payment entity) {
        final String url = BASE_URL+"payment/create";
        HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Payment entity) {
        final String url = BASE_URL+"payment/update/"+entity.getId().toString();
        HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Payment entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> paymentList = new ArrayList<>();
        final String url = BASE_URL+"payment/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Payment[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Payment[].class);
        Payment[] results = responseEntity.getBody();

        for (Payment payments : results) {
            paymentList.add(payments);
        }
        return paymentList;
    }
}
