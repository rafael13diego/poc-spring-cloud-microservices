package drafael.professional.got.controller;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/got/characters")
@Slf4j
public class GameOfThronesController {

    private Faker faker = new Faker();

    private List<String> characters = new ArrayList<>();

    @PostConstruct
    public void init(){
        for (int i = 0; i < 20; i++){
            characters.add(faker.gameOfThrones().character());
        }
    }

    @GetMapping
    public ResponseEntity<List<String>> get(){
        log.info("Getting Characters GOT");
        return ResponseEntity.ok(characters);
    }
}