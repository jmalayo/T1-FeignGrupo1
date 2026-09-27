package pe.cibertec.t1feigngrupo1.restclient.rickandmorty.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterRM {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
}
