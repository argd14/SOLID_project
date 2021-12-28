package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.DoctorEntity;

public class DoctorRepository extends BaseRepository<DoctorEntity> {

  public DoctorRepository(SourceData<DoctorEntity> database) {
    super(database);
  }
}
