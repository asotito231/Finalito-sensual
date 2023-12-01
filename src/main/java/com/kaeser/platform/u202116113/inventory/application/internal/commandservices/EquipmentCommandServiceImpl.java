package com.kaeser.platform.u202116113.inventory.application.internal.commandservices;


import com.kaeser.platform.u202116113.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202116113.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u202116113.inventory.domain.service.EquipmentCommandService;
import com.kaeser.platform.u202116113.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Long handle(CreateEquipmentCommand command) {
        //Technically, here we should add a check to the EquipmentType Values but here is a Java not C# and the command is already asking for a value of the EquipmentType Enum
        var equipment = new Equipment(
                command.model(),
                command.equipmentType()
        );
        equipmentRepository.save(equipment);
        return equipment.getId();
    }
}
