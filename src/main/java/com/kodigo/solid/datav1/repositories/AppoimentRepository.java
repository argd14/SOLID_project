package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.AppointmentEntity;

public class AppoimentRepository extends BaseRepository<AppointmentEntity> {

  public AppoimentRepository(SourceData<AppointmentEntity> database) {
    super(database);
  }
}
