package com.kaeser.platform.u202116113.inventory.interfaces.rest.resources;

import com.kaeser.platform.u202116113.inventory.domain.model.valueobject.EEquipmentType;

public record CreateEquipmentResource(String model, EEquipmentType equipmentType) {

}
