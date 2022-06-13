import Models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * App class to run the exploration of rovers on a plateau on Mars.
 */
public class FileService {

    public static void main(String[] args) {
        String aux;
        String[] splited;
        Plateau plateau;
        Rover rover;
        File inputFile, outputFile;
        ArrayList<String> outputString = new ArrayList<String>();

        /**
         * Reading informations from input file
         */
        inputFile = new File("input.txt");
        try (Scanner s = new Scanner(inputFile)){
            s.useDelimiter("\n");
            aux = s.next(); // Getting the first line:  the upper-right coordinates of the plateau
            splited = aux.split("\\s+");
            plateau = Plateau.getInstance(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]));
            while (s.hasNext()){
                aux = s.next(); // Getting the rover’s position
                splited = aux.split("\\s+");
                rover = new Rover(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]),splited[2].charAt(0),plateau );
                aux = s.next(); // Getting series of instructions telling the rover how to explore the plateau.
                for (int i = 0; i < aux.length(); i++) {
                    rover.explore(aux.charAt(i));
                }
                outputString.add(rover.toString());
                System.out.println(rover);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Writting informations from output file
         */
        outputFile = new File("output.txt");
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outputFile, false))){
            for( String oneItem : outputString ) {
                buffer.append(oneItem + "\n");
            }
            System.out.println("The output file has been written properly!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
