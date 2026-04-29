package BMS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authentication {

    public boolean verifyCredentials(int userID, String password) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("customers.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int fileID = Integer.parseInt(data[0]);
                String filePin = data[2];  

                if (fileID == userID && filePin.equals(password)) {
                    br.close();
                    return true;
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading customer file!");
        }

        return false;
    }
}