package com.example.demo.Controller;

import com.example.demo.DTO.HumanDTO;
import com.example.demo.Entity.Human;
import com.example.demo.Repository.HumanRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {


    private final HumanRepo humanRepo;

@Operation(
        summary = "Добавляет нового человека в базу",
        description = "получает DTO человека и с помощью Билдера собирает и сохраняет его сущность в базу"
)
    @PostMapping("/api/add")
    public void addHuman(@RequestBody HumanDTO humanDTO) {

        log.info(
                "New row " + humanRepo.save(
                        Human.builder()
                                .name(humanDTO.getName())
                                .telephoneNumber(humanDTO.getTelephoneNumber())
                                .email(humanDTO.getEmail())
                                .build())
        );
    }

    @Operation(
            summary = "получает всех людей из таблицы"
    )
    @SneakyThrows
    @GetMapping("/api/all")
    public List<Human> getAll() {
        return humanRepo.findAll();
    }

    @Operation(
            summary = "достает человека из таблицы по его ID"
    )
    @GetMapping("/api")
    public Human getHuman(@RequestParam int id) {
        return humanRepo.findById(id).orElseThrow();
    }

    @Operation(
            summary = "удаляет человека из таблицы по его ID"
    )
    @DeleteMapping("/api")
    public void deleteHuman(@RequestParam int id) {
        humanRepo.deleteById(id);
    }

    @Operation(
            summary = "изменяет данные человека из таблицы и сохраняет уже с измененными данными"
    )
    @PutMapping("/api/add")
    public String changeHuman(@RequestBody Human human) {
        if (humanRepo.existsById(human.getId())) {
            return "No such row";
        }
        return humanRepo.save(human).toString();
    }
}