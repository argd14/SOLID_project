package com.kodigo.solid.entitiesv1;

import lombok.Getter;

public class BaseEntity implements EntityGetAutoIncrementId {
  @Getter public int id;

  public BaseEntity(int id) {
    this.id = id;
  }
}
