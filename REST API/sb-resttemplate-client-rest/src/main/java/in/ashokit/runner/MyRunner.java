package in.ashokit.runner;

import in.ashokit.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestTemplate restTemplate=new RestTemplate();

      /*  String url="http://localhost:8080/api/user/users";
        UserEntity[] users = restTemplate.getForObject(url, UserEntity[].class);

        System.out.println("==== User Details ====");

        if (users != null) {
            for (UserEntity user : users) {
                System.out.println("Username: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            }
        }*/

       /* String url="http://localhost:8080/api/user/users";
        ResponseEntity<UserEntity[]> forEntity = restTemplate.getForEntity(url, UserEntity[].class);
        UserEntity[] users = forEntity.getBody();
        if (users != null) {
            for (UserEntity user : users) {
                System.out.println("Username: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            }
        }*/

        /*String url = "http://localhost:8080/api/user/users";

        ParameterizedTypeReference<List<UserEntity>> typeReference =
                new ParameterizedTypeReference<>() {};

        ResponseEntity<List<UserEntity>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        typeReference
                );

        List<UserEntity> users = response.getBody();

        if (users != null) {
            for (UserEntity user : users) {
                System.out.println(user.getName());
                System.out.println(user.getEmail());
            }
        }*/

        String url = "http://localhost:8080/api/user/create";
        UserEntity userEntity=new UserEntity();;
        userEntity.setName("john");
        userEntity.setEmail("john@gmail.com");
        userEntity.setPhno(989898989L);

        ParameterizedTypeReference<UserEntity> reference=new ParameterizedTypeReference<>() {};

        HttpEntity<UserEntity> httpEntity=new HttpEntity<>(userEntity);

        ResponseEntity<UserEntity> exchange = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                reference
        );

        UserEntity body = exchange.getBody();
        System.out.println(body);
    }
}
