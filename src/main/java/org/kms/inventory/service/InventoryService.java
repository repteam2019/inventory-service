package org.kms.inventory.service;

import org.kms.inventory.model.Availability;

public interface InventoryService {

    public Availability getInventory(String sku);

    public Availability createInventory(Availability availability);
}
