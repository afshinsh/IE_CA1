package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Command cmd = new Command();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            cmd.Process(sc.nextLine());
        }
    }
}
