package com.user_food.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public enum EnumRol {
    PUBLICO(1),
    ADMIN(2),
    SUPERADMIN(3);

    private final int value;

    EnumRol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
