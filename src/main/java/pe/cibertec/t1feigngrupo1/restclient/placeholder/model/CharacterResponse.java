package pe.cibertec.t1feigngrupo1.restclient.placeholder.model;

import lombok.Data;
import java.util.List;

@Data
public class CharacterResponse {

    private Info info;
    private List<CharacterRM> results;

    @Data
    public static class Info {
        private int count;
        private int pages;
        private String next;
        private String prev;
    }
}