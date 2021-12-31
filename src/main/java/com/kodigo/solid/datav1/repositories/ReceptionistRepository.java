package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.ReceptionistEntity;

public class ReceptionistRepository extends BaseRepository<ReceptionistEntity> {
  public ReceptionistRepository(SourceData<ReceptionistEntity> database) {
    super(database);
  }
}
