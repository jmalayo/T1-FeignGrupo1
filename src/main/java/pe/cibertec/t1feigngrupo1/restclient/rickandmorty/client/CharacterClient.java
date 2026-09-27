package pe.cibertec.t1feigngrupo1.restclient.rickandmorty.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.cibertec.t1feigngrupo1.restclient.rickandmorty.model.CharacterResponseRM;

@FeignClient(
        name = "characterClient",
        url = "https://rickandmortyapi.com"
)
public interface CharacterClient {

    @GetMapping("/api/character")
    CharacterResponseRM getCharacters();
}
