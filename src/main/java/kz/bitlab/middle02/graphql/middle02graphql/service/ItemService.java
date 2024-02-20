package kz.bitlab.middle02.graphql.middle02graphql.service;

import kz.bitlab.middle02.graphql.middle02graphql.model.Item;
import kz.bitlab.middle02.graphql.middle02graphql.model.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private List<Item> items;
    private List<Manufacturer> manufacturers;

    private Long manufacturerId = 5L;

    public ItemService() {

        manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer(1L, "Apple Inc.", "USA"));
        manufacturers.add(new Manufacturer(2L, "XIAOMI Corp.", "China"));
        manufacturers.add(new Manufacturer(3L, "Samsung Inc.", "South Korea"));
        manufacturers.add(new Manufacturer(4L, "NOKIA", "Finland"));

        items = new ArrayList<>();
        items.add(new Item(1L, "Iphone 15", manufacturers.get(0), 20, 560000));
        items.add(new Item(2L, "Iphone 14", manufacturers.get(0), 10, 460000));
        items.add(new Item(3L, "NOKIA 3110", manufacturers.get(3), 20, 36000));
        items.add(new Item(4L, "Iphone 12", manufacturers.get(0), 30, 260000));
        items.add(new Item(5L, "XIAOMI REDMI NOTE 11", manufacturers.get(1), 10, 160000));
    }

    public List<Item> findAllItems() {
        return items;
    }

    public Item findItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturers;
    }

    public Manufacturer getManufacturerById(Long id) {
        return manufacturers.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        manufacturer.setId(manufacturerId);
        manufacturers.add(manufacturer);
        return manufacturer;
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        Manufacturer currentManufacturer = null;
        int index = -1;
        for(int i = 0; i < manufacturers.size(); i++){
            if(manufacturers.get(i).getId().equals(manufacturer.getId())){
                currentManufacturer = manufacturers.get(i);
                index = i;
            }
        }
        if (currentManufacturer != null) {
            manufacturers.set(index, manufacturer);
            return manufacturer;
        }
        return null;
    }

}