package Main;

import Algorithm.Genesis;

public class Main {

    public static void main(String[] args){
        int RawLength = 20;
        int CandidateQuantity = 1000;
        int ParentSimplingRate = 50;
        int MutationRate = 10;
        int Generation = 70;
        Genesis test = new Genesis(RawLength,CandidateQuantity);
        test.genesy();

    }

}

