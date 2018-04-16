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

    Candidate testPop = new Candidate(geno, raw);
    Candidate testMom = new Candidate(subGeno, raw);
    ArrayList<Candidate> testList;

    public FunctionTester(){
        testList = new ArrayList<>();
        testList.add(testPop);
        testList.add(testMom);
        System.out.println(testList.size());
    }

    private int[] makeGeno(){
        int[] tmp = new int[210];
        for(int i = 0; i < 210; i++){
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
        Genesis genesis = new Genesis(200, 200);
        for (int i = 0; i < 210; i++){
            if(i < 201) {
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

    @Test
    public void testCrossover(){
        Candidate temp;
        Genesis genesis = new Genesis(10, 10);
        temp = genesis.crossover(testPop, testMom, 0);
        assertEquals(true, temp.getGeno()[0] == testPop.getGeno()[0] || temp.getGeno()[0] == testMom.getGeno()[0]);
        assertEquals(true, temp.getGeno()[1] == testPop.getGeno()[1] || temp.getGeno()[1] == testMom.getGeno()[1]);
        assertEquals(true, temp.getGeno()[2] == testPop.getGeno()[2] || temp.getGeno()[2] == testMom.getGeno()[2]);
        assertEquals(true, temp.getGeno()[3] == testPop.getGeno()[3] || temp.getGeno()[3] == testMom.getGeno()[3]);
    }

    @Test
    public void testEvolve(){
        Genesis genesis = new Genesis(4,2);
        System.out.println("Look: " + genesis.evolve(testList, 50).get(0).getFit());
        assertEquals(6, genesis.evolve(testList, 50).get(0).getFit());
    }

    public void testBreedd(){

    }

}
