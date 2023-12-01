package com.kaeser.platform.u202116113.inventory.interfaces.rest.transform;

import com.kaeser.platform.u202116113.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(resource.model(), resource.equipmentType());
    }
}
