package org.example;

import org.example.config.Config;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    RestTemplate restTemplate = new RestTemplate();

    private final String URL = "http://91.241.64.178:7081/api/users";
    static String sessionId = getSessionId();

    static HttpHeaders headers = new HttpHeaders();



    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Communication communication = context.getBean("communication", Communication.class);

        headers.add();



        User newUser = new User(3L, "James", "Brown", Byte.parseByte("20"));



    }

    public String getSessionId () {
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        return responseEntity.getHeaders().getFirst("Set-Cookie");
    }

    public ResponseEntity<String> addUser(User user) {
        HttpEntity<?> entity = new HttpEntity<>(user, headers);

        return restTemplate
                .postForEntity(URL, entity, String.class);
    }

    public User getUserById(int id) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(URL+"/" + id, HttpMethod.GET, null,new ParameterizedTypeReference<User>());
        User user = restTemplate.getForObject(URL + "/" + id, User.class);
        return user;
    }



    public void deleteUser(int id){
//        ResponseEntity<>

    }
}
