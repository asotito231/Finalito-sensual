package com.kaeser.platform.u202116113.inventory.interfaces.rest.transform;

import com.kaeser.platform.u202116113.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.resources.SparePartResource;

public class SparePartResourceFromEntityAssembler {
    public static SparePartResource toResourceFromEntity(SparePart entity) {
        return new SparePartResource(entity.getId(), entity.getSupplierId(), entity.getModel(), entity.getMaterialSerialNumber(), entity.getSupplierProvidedSerialNumber(), entity.getEquipment().getId());
    }
}
