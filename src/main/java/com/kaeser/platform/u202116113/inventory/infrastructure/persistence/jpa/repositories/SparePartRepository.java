package com.kaeser.platform.u202116113.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u202116113.inventory.domain.model.entities.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparePartRepository extends JpaRepository<SparePart, Long> {
    Optional<SparePart> findBySupplierIdAndModelAndSupplierProvidedSerialNumber(int supplierId, String model, String supplierProvidedSerialNumber);
}
