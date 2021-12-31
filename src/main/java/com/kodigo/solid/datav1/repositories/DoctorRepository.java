package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.DoctorEntity;

public class DoctorRepository extends BaseRepository<DoctorEntity> {

  public DoctorRepository(SourceData<DoctorEntity> database) {
    super(database);
  }
}
