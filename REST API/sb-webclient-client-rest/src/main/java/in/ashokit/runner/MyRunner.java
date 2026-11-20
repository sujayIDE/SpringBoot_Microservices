package in.ashokit.runner;

import in.ashokit.entity.UserEntity;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MyRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        WebClient webClient=WebClient.create();

        String url="http://localhost:8080/api/user/users";
        Flux<UserEntity> userEntityMono = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(UserEntity.class);

        userEntityMono.subscribe(System.out::println);
    }
}
