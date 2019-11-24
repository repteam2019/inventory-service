package org.kms.inventory.service;

import lombok.extern.slf4j.Slf4j;
import org.kms.inventory.model.Availability;
import org.kms.inventory.repository.InventoryCRUDRepository;
import org.kms.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

    // THIS IS A DUMMY REPOSITORY
    @Autowired
    private InventoryRepository inventoryRepository;
    // THIS IS POSTGRESQL REPOSITORY
    @Autowired
    private InventoryCRUDRepository inventoryCRUDRepository;

    @Override
    public Availability getInventory(String sku) {
        log.debug("In service: fetching inventory for SKU :{} ", sku);
        try {
            return inventoryCRUDRepository.findById(sku).get();
        } catch (Exception e) {
            return inventoryRepository.getInventory(sku);
        }
    }

    @Override
    public Availability createInventory(Availability availability) {

        try {
            return inventoryCRUDRepository.save(availability);
        } catch (Exception e) {
            inventoryRepository.createInventory(availability);
            return inventoryRepository.getInventory(availability.getSku());
        }
    }
}
