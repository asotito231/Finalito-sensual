package com.kaeser.platform.u202116113.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u202116113.inventory.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
