package org.kms.inventory.controller;

import lombok.extern.slf4j.Slf4j;
import org.kms.inventory.model.Availability;
import org.kms.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/availability/{sku}")
    public Availability getInventoryStatus(@PathVariable("sku") String sku) {
        log.info("Fetching inventory details for sku {}", sku);
        return inventoryService.getInventory(sku);
    }

    @PostMapping("/availability")
    public Availability createInventory(@RequestBody Availability availability) {
        return inventoryService.createInventory(availability);
    }


}
