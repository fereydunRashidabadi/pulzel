package com.pulzel.client;

import java.net.URI;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pulzel.entity.Advertis;

public class RestClientUtil {
    private HttpHeaders getHeaders() {
    	String credential="mukesh:m123";
    	//String credential="tarun:t123";
    	String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
     	headers.add("Authorization", "Basic " + encodedCredential);
    	return headers;
    }
    public void getAdvertisByIdDemo() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/advertis/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Advertis> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Advertis.class, 1);
        Advertis advertis = responseEntity.getBody();
        System.out.println("Id:"+advertis.getId()+", Title:"+advertis.getTitle()
                 +", Ads_price:"+advertis.getAds_price()+", Max_viwe:"+advertis.getMax_viwe());
    }
	public void getAllAdvertissDemo() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/advertiss";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Advertis[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Advertis[].class);
        Advertis[] advertiss = responseEntity.getBody();
        for(Advertis advertis : advertiss) {
              System.out.println("Id:"+advertis.getId()+", Title:"+advertis.getTitle()
                      +", Ads_price:"+advertis.getAds_price()+", Max_viwe:"+advertis.getMax_viwe());
        }
    }
    public void addAdvertisDemo() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/advertis";
	    Advertis objAdvertis = new Advertis();
	    objAdvertis.setTitle("Spring REST Security using Hibernate");
	    objAdvertis.setImage("Spring");
        HttpEntity<Advertis> requestEntity = new HttpEntity<Advertis>(objAdvertis, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateAdvertisDemo() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/advertis";
	    Advertis objAdvertis = new Advertis();
	    objAdvertis.setId(1);
	    objAdvertis.setTitle("Update:Java Concurrency");
	    objAdvertis.setImage("Java");
        HttpEntity<Advertis> requestEntity = new HttpEntity<Advertis>(objAdvertis, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteAdvertisDemo() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/advertis/{id}";
        HttpEntity<Advertis> requestEntity = new HttpEntity<Advertis>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }

    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getAdvertisByIdDemo();
        util.getAllAdvertissDemo();
    	//util.addAdvertisDemo();
    	util.updateAdvertisDemo();
    	//util.deleteAdvertisDemo();
    }    
}
