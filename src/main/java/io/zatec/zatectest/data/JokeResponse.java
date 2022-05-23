package io.zatec.zatectest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Class representing joke response structure
 *
 * @author amy.muhimpundu
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor public class JokeResponse implements Serializable {

    private String id;
    private List<String> categories;
    private String created;
    @JsonProperty("icon_url") private String iconUrl;
    @JsonProperty("updated_at") private String updatedAt;
    private String url;
    private String value;

}
