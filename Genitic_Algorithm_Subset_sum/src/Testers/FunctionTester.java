package Testers;

import Algorithm.Candidate;
import Algorithm.Genesis;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FunctionTester {

    int[] geno = {0,1,0,1};
    int[] subGeno = {1,1,0,1};
    int[] raw = {1,2,3,4};

    int n = 50;
    Candidate testPop = new Candidate(geno, raw);
    Candidate testMom = new Candidate(subGeno, raw);

    private int[] makeGeno(){
        int[] tmp = new int[60];
        for(int i = 0; i < 60; i++){
            tmp[i] = 0;
        }
        return tmp;
    }

    @Test
    public void testFitness(){
        Candidate candidate = new Candidate(geno, raw);
        assertEquals(candidate.fitness(), 6);
    }

    @Test
    public void testInit(){
        int[] temp;
        Genesis genesis = new Genesis(10,10);
        temp = genesis.init();
        for(int i = 0; i < 10; i++){
            assertEquals(true, temp[i] == 1|| temp[i] == 0);
        }
    }

    @Test
    public void testGenesy(){
        ArrayList<Candidate> temp;
        int count = 0;
        Genesis genesis = new Genesis(10,10);
        temp = genesis.genesy();
        for(Candidate can : temp){
            count++;
            for (int g: can.getGeno()){
                assertEquals(true, g >= -100 || g <= 100);
            }
        }
        assertEquals(count, 10);
    }

    @Test
    public void testMutate(){
        boolean check = false;
        boolean ignore = false;
        Genesis genesis = new Genesis(60, 60);
        for (int i = 0; i < 60; i++){
            if(i < 51) {
                if (genesis.mutate(makeGeno())[i] != makeGeno()[i]) {
                    check = true;
                }
            }
            else{
                if(genesis.mutate(makeGeno())[i] == makeGeno()[i]){
                    ignore = true;
                }
            }
        }
        assertEquals(true, check);
        assertEquals(true, ignore);
    }

    public void testCrossover(){
        Genesis genesis = new Genesis(10, 10);
    }
}
