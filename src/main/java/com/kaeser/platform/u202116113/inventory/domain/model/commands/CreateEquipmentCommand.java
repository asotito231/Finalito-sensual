package com.kaeser.platform.u202116113.inventory.domain.model.commands;

import com.kaeser.platform.u202116113.inventory.domain.model.valueobject.EEquipmentType;

public record CreateEquipmentCommand(String model, EEquipmentType equipmentType) {
}
