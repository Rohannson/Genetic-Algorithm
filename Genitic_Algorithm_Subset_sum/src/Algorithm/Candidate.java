package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Candidate implements Comparable<Candidate>{

    private int[] geno;
    private int[] raw;
    private int fit;
    public List<Integer> displayMapping(){
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<geno.length;i++){
            if (geno[i]!=0)
                list.add(raw[i]);
        }
        return list;
    }
    public Candidate(int[] geno, int[] raw){
        this.geno = geno;
        this.raw = raw;
        this.fit = fitness();
    }

    public int[] getGeno() {
        return geno;
    }

    public void setGeno(int[] geno) {
        this.geno = geno;
    }

    public int getFit() {
        return fit;
    }

    public void setFit(int fit) {
        this.fit = fit;
    }

    public int fitness( ){
        int fit = 0;
        int count=0;
        for(int i = 0; i < geno.length; i++){
            fit = fit + (raw[i] * geno[i]);
            if (geno[i]!=0) count++;

        }

        fit = Math.abs(fit);
        if (count==0) count+=1000;
        return fit;
    }


    @Override
    public int compareTo(Candidate can){
        if (fit>can.fit)
            return 1;
        else if (fit<can.fit)
            return -1;
        else
            return 0;
    }
}
