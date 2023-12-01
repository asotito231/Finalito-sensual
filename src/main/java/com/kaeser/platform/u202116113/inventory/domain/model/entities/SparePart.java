package com.kaeser.platform.u202116113.inventory.domain.model.entities;

import com.kaeser.platform.u202116113.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202116113.inventory.domain.model.valueobject.MaterialSerialNumber;
import com.kaeser.platform.u202116113.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
public class SparePart extends AuditableModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    @Getter
    private int supplierId;

    @Getter
    private String model;

    @Getter
    private String supplierProvidedSerialNumber;

    @Getter
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public SparePart() {
    }

    public SparePart(int supplierId, String model, String supplierProvidedSerialNumber, Equipment equipment) {
        this.materialSerialNumber = new MaterialSerialNumber();
        this.supplierId = supplierId;
        this.model = model;
        this.supplierProvidedSerialNumber = supplierProvidedSerialNumber;
        this.equipment = equipment;
    }

    public UUID getMaterialSerialNumber() {
        return materialSerialNumber.materialSerialNumber();
    }
}
