package Main;

import Storage.Storage;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Command cmd = new Command();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            cmd.proccess(sc.nextLine());
        }
    }
}
