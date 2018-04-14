package Testers;

import Algorithm.Candidate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FunctionTester {

    int[] geno = {0,1,0,1};
    int[] raw = {1,2,3,4};

    @org.junit.Test
    public void testFitness(){
        Candidate candidate = new Candidate(geno, raw);
        assertEquals(candidate.fitness(), 6);
    }

}
