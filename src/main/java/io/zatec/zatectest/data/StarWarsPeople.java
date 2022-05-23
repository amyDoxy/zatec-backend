package io.zatec.zatectest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class representing Star Wars people response structure
 *
 * @author amy.muhimpundu
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor public class StarWarsPeople implements Serializable {

    private String name;
    private Long height;
    private Long mass;
    @JsonProperty("hair-color") private String hairColor;
    @JsonProperty("skin-color") private String skinColor;
    @JsonProperty("eye-color") private String eyeColor;
    @JsonProperty("birth-year") private String birthYear;
    private String gender;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;
}
