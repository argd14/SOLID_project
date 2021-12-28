package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.ConsultationSheetEntity;

public class ConsultationSheetRepository extends BaseRepository<ConsultationSheetEntity> {
  public ConsultationSheetRepository(SourceData<ConsultationSheetEntity> database) {
    super(database);
  }
}
