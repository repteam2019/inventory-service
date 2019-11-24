package org.kms.inventory.repository;

import lombok.extern.slf4j.Slf4j;
import org.kms.inventory.model.Availability;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Repository
public class InventoryRepository {

    public Map<String, Integer> inventoryDB = new HashMap();

    @PostConstruct
    public void init() {
        inventoryDB.put("IT001", 123);
        inventoryDB.put("IT002", 345);
        inventoryDB.put("IT003", 767);
        inventoryDB.put("IT004", 0);
        inventoryDB.put("IT005", 12);
    }

    public Availability getInventory(String sku) {
        log.debug("In Repository: fetching inventory for SKU :{} ", sku);
        return Availability.builder().sku(sku).availableQuantity(inventoryDB.get(sku)).build();
    }

    public Integer createInventory(Availability availability) {
        return inventoryDB.put(availability.getSku(), availability.getAvailableQuantity());
    }
}
