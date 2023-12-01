package com.kaeser.platform.u202116113.inventory.domain.service;

import com.kaeser.platform.u202116113.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202116113.inventory.domain.model.queries.GetEquipmentByIdQuery;

import java.util.Optional;

public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentByIdQuery query);
}
