package org.kms.inventory.repository;

import org.kms.inventory.model.Availability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryCRUDRepository extends CrudRepository<Availability, String> {

}
