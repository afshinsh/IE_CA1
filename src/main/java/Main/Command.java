package Main;

import Storage.Storage;

public class Command {
    Storage dataBase;
    String command;
    String JsonInput;
    public Command(){
        this.dataBase = new Storage();
    }

    private static String CleanUpCommand(String commandLine) {
        int whiteSpace = 0;
        commandLine = commandLine.toLowerCase();
        for (char c: commandLine.toCharArray())
            if(c == ' ')
                whiteSpace++;
        return commandLine.substring(whiteSpace);
    }

    public void proccess(String commandLine) {
        System.out.println(commandLine);

        commandLine = CleanUpCommand(commandLine);
        System.out.println(commandLine);
        String[] commandParts = commandLine.split(" ", 2);

        this.command = commandParts[0];
        this.JsonInput = (commandParts.length > 1 ) ? commandParts[1] : null;
    }




}
