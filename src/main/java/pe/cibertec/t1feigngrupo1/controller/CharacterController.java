package pe.cibertec.t1feigngrupo1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.t1feigngrupo1.restclient.rickandmorty.model.CharacterRM;
import pe.cibertec.t1feigngrupo1.service.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterController {

    private CharacterService characterService;

    @GetMapping
    public List<CharacterRM> getCharacters() {
        return characterService.getFilteredCharacters();
    }
}
