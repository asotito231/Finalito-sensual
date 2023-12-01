package com.kaeser.platform.u202116113.inventory.domain.model.commands;

public record CreateSparePartCommand(int supplierId, String model, String supplierProvidedSerialNumber) {
}
