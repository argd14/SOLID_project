package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.Admin;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.Entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AdminDataManagement extends CoreDataManagement<Admin> implements SourceData<Admin>{

    private String fileName =
            new File("src/main/java/com/kodigo/solid/data/fakedb/adminData.txt").getAbsolutePath();

    @Override
    public List<Entity<Admin>> getDataFromTextFileDatabase()
            throws IOException, ClassNotFoundException {
        return this.readData(this.fileName);
    }

    @Override
    public void saveDataToTextFileDatabase(List<Entity<Admin>> dataToSave)
            throws IOException, ClassNotFoundException {
        this.writeData(dataToSave, this.fileName);
    }

    @Override
    public int getElementsCount() throws IOException, ClassNotFoundException {
        return this.getNumberOfRecords(this.fileName);
    }

}
