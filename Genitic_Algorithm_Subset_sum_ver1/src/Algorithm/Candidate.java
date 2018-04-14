package Algorithm;

public class Candidate implements Comparable<Candidate>{

    private int[] geno;
    private int fit;

    public Candidate(int M){
        initialization(M);

    }
    private int[] initialization(int num){
            for (int i = 0; i < num; i ++){
                double random=Math.random();
                if (random>0.5)
                    geno[i] = 1;
                else
                    geno[i] = 0;
            }
            return geno;
    }

    public int fitness(int[] raw){
        for(int i = 0; i <raw.length; i++){
            fit+= raw[i] * geno[i];
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
        if (fit==can.fit)
            return 0;
        else if (fit>can.fit)
            return 1;
        else
            return -1;
    }
}
