package Algorithm;

public class Candidate implements Comparable<Candidate>{

    private int[] geno;
    private int[] raw;
    private int fit;

    public Candidate(int[] geno, int[] raw){
        this.geno = geno;
        this.raw = raw;
        this.fit = fitness();
    }

    public int fitness( ){
        int fit = 0;
        for(int i = 0; i < geno.length; i++){
            fit = fit + (raw[i] * geno[i]);
        }
        fit = Math.abs(fit);
        return fit;
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
