package com.kaeser.platform.u202116113.inventory.domain.service;

import com.kaeser.platform.u202116113.inventory.domain.model.commands.CreateSparePartCommand;

public interface SparePartCommandService {
    Long handle(CreateSparePartCommand command, Long equipmentId);
}
