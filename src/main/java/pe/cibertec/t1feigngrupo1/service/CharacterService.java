package pe.cibertec.t1feigngrupo1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.t1feigngrupo1.restclient.rickandmorty.client.CharacterClient;
import pe.cibertec.t1feigngrupo1.restclient.rickandmorty.model.CharacterRM;
import pe.cibertec.t1feigngrupo1.restclient.rickandmorty.model.CharacterResponseRM;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacterService {

    private CharacterClient characterClient;

    public List<CharacterRM> getFilteredCharacters() {

        CharacterResponseRM response = characterClient.getCharacters();

        return response.getResults().stream()
                .filter(c -> "Alive".equalsIgnoreCase(c.getStatus()))
                .filter(c -> "Human".equalsIgnoreCase(c.getSpecies()))
                .collect(Collectors.toList());
    }
}
