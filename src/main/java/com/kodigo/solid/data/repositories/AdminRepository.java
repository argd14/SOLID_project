package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.Admin;

public class AdminRepository extends BaseRepository<Admin>{

    public AdminRepository(SourceData<Admin> database) {
        super(database);
    }
}
