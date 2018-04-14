package Algorithm;

public class Candidate {

    private int[] geno;
    private int fit;

    public Candidate(int[] geno, int fit){
        this.geno = geno;
        this.fit = fit;
        this.survial = survial;
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

}
