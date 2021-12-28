package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.ReceptionistEntity;

public class ReceptionistRepository extends BaseRepository<ReceptionistEntity> {
  public ReceptionistRepository(SourceData<ReceptionistEntity> database) {
    super(database);
  }
}
