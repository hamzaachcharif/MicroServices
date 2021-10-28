package org.sid.invenory.inventoryservice.repository;

import org.sid.invenory.inventoryservice.entitites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
