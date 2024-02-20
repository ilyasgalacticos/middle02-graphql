package kz.bitlab.middle02.graphql.middle02graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Manufacturer {

    private Long id;
    private String name;
    private String country;

}
