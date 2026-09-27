package pe.cibertec.t1feigngrupo1.service;


import org.springframework.stereotype.Service;
import pe.cibertec.t1feigngrupo1.restclient.placeholder.idcliente.CharacterClient;
import pe.cibertec.t1feigngrupo1.restclient.placeholder.model.CharacterRM;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterClient characterClient;

    public CharacterService(CharacterClient characterClient) {
        this.characterClient = characterClient;
    }

    public List<CharacterRM> getAliveHumans() {

        return characterClient
                .getCharacters(1, "Alive", "Human")
                .getResults();
    }
}