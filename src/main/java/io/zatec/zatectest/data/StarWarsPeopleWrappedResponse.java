package io.zatec.zatectest.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Class representing Star Wars people wrapped response structure
 *
 * @author amy.muhimpundu
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StarWarsPeopleWrappedResponse {

    private Long count;
    private String next;
    private String previous;
    private List<StarWarsPeople> results;
}
