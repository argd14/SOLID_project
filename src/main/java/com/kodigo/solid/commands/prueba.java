package com.kodigo.solid.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.kodigo.solid.commands.core.CliCommands;
import lombok.Getter;

@Parameters(commandNames = {CliCommands.nombreCualquiera})

public class prueba extends CommandMetadata {

    @Parameter(names = "--author")
    @Getter
    private String author;

    @Parameter(names = "--cita", arity = 0)
    @Getter
    private boolean cita = false;

    @Parameter(names = "--comer", arity = 0)
    @Getter
    private boolean comer = false;

    @Parameter(names = "--bailar", arity = 0)
    @Getter
    private boolean bailar = false;

    public prueba(String commandName) {
        super(commandName);
    }

    @Override
    public void execute() {
        if (this.isCita()) {
            System.out.println("Esta es tu cita");
        }
        if (this.isComer()) {
            System.out.println("Es hora de comer");
        }
        if (this.isBailar()) {
            System.out.println("Es hora de bailar");
        }
    }
}
