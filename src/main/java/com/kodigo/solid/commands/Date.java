package com.kodigo.solid.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Date {

    private String day;
    private String month;
    private String year;



    @Override
    public String toString() {
        return " "+day + " "+month + " "+year;
    }
}
