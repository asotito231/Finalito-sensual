package com.kaeser.platform.u202116113.inventory.domain.service;

import com.kaeser.platform.u202116113.inventory.domain.model.commands.CreateEquipmentCommand;

public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);
}
