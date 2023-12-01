package com.kaeser.platform.u202116113.inventory.interfaces.rest.resources;

import java.util.UUID;

public record SparePartResource(Long sparePartId, int supplierId, String Model, UUID materialSerialNumber, String supplierProvidedSerialNumber, Long equipmentId) {
}
