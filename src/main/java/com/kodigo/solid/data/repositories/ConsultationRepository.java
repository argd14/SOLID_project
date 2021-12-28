package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.ConsultationEntity;

public class ConsultationRepository extends BaseRepository<ConsultationEntity> {

  public ConsultationRepository(SourceData<ConsultationEntity> database) {
    super(database);
  }
}
