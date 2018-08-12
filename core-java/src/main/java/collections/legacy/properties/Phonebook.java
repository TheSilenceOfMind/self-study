package collections.legacy.properties;

import java.io.*;
import java.util.*;

/** A simple telephone number database that uses a property list. */
public class Phonebook {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name, number;
        FileInputStream fin = null;
        boolean changed = false;

        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
            // ignore missing file
        }

        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        do {
            System.out.println("Enter new name ('quit' to stop): ");
            name = br.readLine();
            if (name.equals("quit")) continue;

            System.out.println("Enter number: ");
            number = br.readLine();

            ht.put(name, number);
            changed = true;
        } while (!name.equals("quit"));

        if (changed) {
            FileOutputStream fout = new FileOutputStream("phonebook.dat");
            ht.store(fout, "Telephone book");
            fout.close();
        }

        do {
            System.out.println("Enter the name to find (enter 'quit' to quit): ");
            name = br.readLine();
            if (name.equals("quit")) continue;

            number = (String) ht.get(name);
            System.out.println(number);
        } while (!name.equals("quit"));
    }
}
