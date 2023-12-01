package com.kaeser.platform.u202116113.inventory.application.internal.commandservices;

import com.kaeser.platform.u202116113.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202116113.inventory.domain.model.commands.CreateSparePartCommand;
import com.kaeser.platform.u202116113.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u202116113.inventory.domain.service.SparePartCommandService;
import com.kaeser.platform.u202116113.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.u202116113.inventory.infrastructure.persistence.jpa.repositories.SparePartRepository;
import org.springframework.stereotype.Service;

@Service
public class SparePartCommandServiceImpl implements SparePartCommandService {
    private final SparePartRepository sparePartRepository;
    private final EquipmentRepository equipmentRepository;

    public SparePartCommandServiceImpl(SparePartRepository sparePartRepository, EquipmentRepository equipmentRepository) {
        this.sparePartRepository = sparePartRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Long handle(CreateSparePartCommand command, Long equipmentId) {
        //Validate that equipment exists
        Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(() -> new IllegalArgumentException("Equipment not found"));

        //Validate unique combination of supplierId, model and supplierProvidedSerialNumber on spare parts
        sparePartRepository.findBySupplierIdAndModelAndSupplierProvidedSerialNumber(command.supplierId(), command.model(), command.supplierProvidedSerialNumber()).ifPresent(sparePart -> {
            throw new IllegalArgumentException("Spare part already exists with supplierId" + command.supplierId() + " model " + command.model() + " and supplierProvidedSerialNumber " + command.supplierProvidedSerialNumber());
        });
        var sparePart = new SparePart(
                command.supplierId(),
                command.model(),
                command.supplierProvidedSerialNumber(),
                equipment
        );

        sparePartRepository.save(sparePart);
        return sparePart.getId();
    }
}
