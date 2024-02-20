package kz.bitlab.middle02.graphql.middle02graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

    private Long id;
    private String name;
    private Manufacturer manufacturer;
    private int amount;
    private double price;

}