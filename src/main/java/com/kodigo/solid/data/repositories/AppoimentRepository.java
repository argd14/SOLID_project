package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.AppointmentEntity;

public class AppoimentRepository extends BaseRepository<AppointmentEntity> {

  public AppoimentRepository(SourceData<AppointmentEntity> database) {
    super(database);
  }
}
