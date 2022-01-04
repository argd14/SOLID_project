package com.kodigo.solid.entities;

import lombok.Getter;

public class BaseEntity  {
    @Getter
    public int id;

    public BaseEntity(int id) {
        this.id = id;
    }
}