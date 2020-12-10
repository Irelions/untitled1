package org.example;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://91.241.64.178:7081/api/users";

    public List<User> getAllUsers() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });

        List<User> allUser = responseEntity.getBody();
        System.out.println(responseEntity.getHeaders().getFirst("Set-Cookie"));
        return allUser;
    }

    public User getUserById(int id) {

        return null;
    }

    public void addUser(User user) {

    }

    public void deleteUser(int id){

    }
}
