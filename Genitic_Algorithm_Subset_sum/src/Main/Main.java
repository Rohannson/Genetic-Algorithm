package Main;


import Algorithm.Candidate;
import Algorithm.Genesis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int RawLength = 20;
        int CandidateQuantity = 1000;
        int ParentSimplingRate = 50;
        int ParentTakeQuantity = 50;
        int MutationRate = 10;
        int Generation = 70;
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
            try {
                bw.write(Temp.get(0).getFit() + "");
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent = test.breed(Temp, ParentTakeQuantity, MutationRate);
        }
        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


