package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.PatientEntity;

public class PatientRepository extends BaseRepository<PatientEntity> {
  public PatientRepository(SourceData<PatientEntity> database) {
    super(database);
  }
}
