package com.kaeser.platform.u202116113.inventory.interfaces.rest.resources;

public record CreateSparePartResource(int supplierId, String model, String supplierProvidedSerialNumber) {
}
