package pe.cibertec.t1feigngrupo1.restclient.placeholder.model;
import lombok.Data;

@Data
public class CharacterRM {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;

    private Origin origin;
    private Location location;

    @Data
    public static class Origin {
        private String name;
        private String url;
    }

    @Data
    public static class Location {
        private String name;
        private String url;
    }
}
