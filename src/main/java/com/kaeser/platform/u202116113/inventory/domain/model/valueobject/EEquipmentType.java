package com.kaeser.platform.u202116113.inventory.domain.model.valueobject;

import lombok.Getter;

@Getter
public enum EEquipmentType {
    SCREW_COMPRESSOR(0),
    AIR_TREATMENT(1);

    private final int value;

    private EEquipmentType(int value) {
        this.value = value;
    }
}
