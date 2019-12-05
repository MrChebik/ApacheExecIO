package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("[CHILD]: Started");

        String line;
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ){
            while((line = br.readLine()) != null && ! line.isEmpty()){
                System.out.println("[CHILD] Reached data: '" + line + "'");

                if ("exit".equals(line)) {
                    System.out.println("[CHILD]: Child programm will be closed");
                    System.exit(0);
                }
            }
        } catch (IOException ignored) { }
    }
}
