package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.ConsultationSheetEntity;

public class ConsultationSheetRepository extends BaseRepository<ConsultationSheetEntity> {
  public ConsultationSheetRepository(SourceData<ConsultationSheetEntity> database) {
    super(database);
  }
}
