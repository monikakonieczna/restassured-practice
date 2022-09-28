package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties("ignoreUnknown = true")
public class CreatePetResponse {

    @JsonProperty("id")
    public String id;
    @JsonProperty("category")
    public String category;
    @JsonProperty("photoUrls")
    public List<String> photoUrls;
    @JsonProperty("tags")
    public List<Tag> tags;
    @JsonProperty("status")
    public String status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Category{
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("name")
        public String name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tag{
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("name")
        public String name;
    }
}
