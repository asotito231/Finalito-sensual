package com.kaeser.platform.u202116113.inventory.interfaces.rest.resources;

import com.kaeser.platform.u202116113.inventory.domain.model.valueobject.EEquipmentType;

import java.util.UUID;

public record EquipmentResource(Long id, String model, UUID materialSerialNumber, EEquipmentType equipmentType) {
}
