package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.PatientEntity;

public class PatientRepository extends BaseRepository<PatientEntity> {
  public PatientRepository(SourceData<PatientEntity> database) {
    super(database);
  }
}
