package kz.bitlab.middle02.graphql.middle02graphql.graphqlcontroller;


import kz.bitlab.middle02.graphql.middle02graphql.model.Item;
import kz.bitlab.middle02.graphql.middle02graphql.model.Manufacturer;
import kz.bitlab.middle02.graphql.middle02graphql.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemQueryResolver {

    private final ItemService itemService;

    @QueryMapping
    public List<Item> findAllItems(){
        return itemService.findAllItems();
    }

    @QueryMapping
    public Item findItemById(@Argument Long id){
        return itemService.findItemById(id);
    }

    @QueryMapping
    public List<Manufacturer> findAllManufacturers(){
        return itemService.getAllManufacturers();
    }

    @QueryMapping
    public Manufacturer findManufacturerById(@Argument Long id){
        return itemService.getManufacturerById(id);
    }

    @MutationMapping
    public Manufacturer createManufacturer(@Argument String name, @Argument String country){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        return itemService.addManufacturer(manufacturer);
    }

    @MutationMapping
    public Manufacturer updateManufacturer(@Argument Long id, @Argument String name, @Argument String country){
        Manufacturer manufacturer = itemService.getManufacturerById(id);
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        return itemService.updateManufacturer(manufacturer);
    }
}