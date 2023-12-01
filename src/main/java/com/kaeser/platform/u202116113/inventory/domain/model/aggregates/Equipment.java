package com.kaeser.platform.u202116113.inventory.domain.model.aggregates;

import com.kaeser.platform.u202116113.inventory.domain.model.valueobject.EEquipmentType;
import com.kaeser.platform.u202116113.inventory.domain.model.valueobject.MaterialSerialNumber;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Equipment extends AbstractAggregateRoot<Equipment> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    @Getter
    private String model;

    @Enumerated(EnumType.ORDINAL)
    private EEquipmentType equipmentType;

    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    public Equipment() {

    }

    public Equipment(String model, EEquipmentType equipmentType) {
        this.materialSerialNumber = new MaterialSerialNumber();
        this.model = model;
        this.equipmentType = equipmentType;
    }

    public UUID getMaterialSerialNumber() {
        return this.materialSerialNumber.materialSerialNumber();
    }
}
