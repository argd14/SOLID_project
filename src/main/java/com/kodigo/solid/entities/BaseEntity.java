package com.kodigo.solid.entities;

import lombok.Getter;

public class BaseEntity implements Entity {
    @Getter
    public int id;

    public BaseEntity(int id) {
        this.id = id;
    }
}
