package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.ConsultationEntity;

public class ConsultationRepository extends BaseRepository<ConsultationEntity> {

  public ConsultationRepository(SourceData<ConsultationEntity> database) {
    super(database);
  }
}
