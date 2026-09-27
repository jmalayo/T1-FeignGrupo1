package pe.cibertec.t1feigngrupo1.restclient.rickandmorty.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterResponseRM {

    private List<CharacterRM> results;
}
