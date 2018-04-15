package Main;



import Algorithm.Candidate;
import Algorithm.Genesis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int RawLength = 500;
        int CandidateQuantity = 1000;
        int ParentSimplingRate = 80;
        int ParentTakeRate = 50;
        int MutationRate = 15;
        int Generation = 150;
        Genesis test = new Genesis(RawLength, CandidateQuantity);
        test.genesy();
        File file = new File("result.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Candidate> Temp;
        ArrayList<Candidate> Parent = test.origin;
        for (int i = 0; i < Generation; i++) {
            Temp = test.evolve(Parent, ParentSimplingRate);

            System.out.println("Generation "+(i+1)+":"+Temp.get(0).getFit());
//            Temp.get(0).displayMapping().forEach((x)->System.out.print(x+" "));
//            System.out.println();
            try {
                bw.write(Temp.get(0).getFit() + "");

                bw.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }



            Parent = test.breed(Temp, ParentTakeRate, MutationRate);
            Parent.add(Temp.get(0));
            Collections.sort(Parent);
            if ( i==(Generation-1)){Temp.get(0).displayMapping().forEach((x)->System.out.print(x+" "));
           System.out.println();}
        }

        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
