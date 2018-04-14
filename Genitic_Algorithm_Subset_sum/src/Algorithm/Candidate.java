package Algorithm;

public class Candidate {

    private int[] geno;
    private int[] raw;
    private int fit;

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
        for(int i: geno){
            fit += raw[i] * i;
        }
        fit = Math.abs(fit);
        return fit;
    }

}
