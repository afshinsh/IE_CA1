package Main;

import Main.Interfaces.CMD;
import Main.Interfaces.EXC;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class Command {
    String command;
    String JsonInput;
    Set<Class<?>> cmds;

    public Command() {
        Reflections reflections = new Reflections("Main");
        this.cmds = reflections.getTypesAnnotatedWith(CMD.class);
    }

    private static String CleanUpCommand(String commandLine) {
        int whiteSpace = 0;
        for (char c : commandLine.toCharArray()){
            if(c != ' ')
                break;
            whiteSpace++;
        }

        return commandLine.substring(whiteSpace);
    }

    public void Process(String commandLine) throws Exception{

        commandLine = CleanUpCommand(commandLine);
        String[] commandParts = commandLine.split(" ", 2);

        this.command = commandParts[0];
        this.JsonInput = (commandParts.length > 1) ? commandParts[1] : null;
        ExecuteCommand();
    }

    private void ExecuteCommand() throws Exception {
        System.out.println("Command : " + this.command);
        System.out.println("Input : " + this.JsonInput);
        for (Class<?> cmdClass : cmds) {
            CMD cmdAnnotation = cmdClass.getAnnotation(CMD.class);
            String resource = cmdAnnotation.resource();
            if (!resource.equals(this.command))
                continue;
            Method[] methods = cmdClass.getMethods();
            for (Method method : methods) {
                EXC methodAnnotation = method.getAnnotation(EXC.class);
                if (methodAnnotation == null)
                    continue;
                Object newInstance = cmdClass.getDeclaredConstructor().newInstance();
                System.out.println("Here");

                method.invoke(newInstance, this.JsonInput);
                return;
            }
        }
    }
}
