package Algorithm;

import java.util.ArrayList;

public class Genesis {

    int num;
    int can_size;
    public ArrayList<Candidate> Origin;
    final int[] raw = new int[num];

    public Genesis(int num, int can_size) {
        this.num = num;
        this.can_size = can_size;
    }

    public ArrayList<Candidate> Genesis(){
        ArrayList<Candidate> origin = new ArrayList<>();
        double d = 0;
        int p = 0;
        for (int i = 0; i < num; i++) {
            d = Math.random();
            if(d > 0.5) p = 1;
            else p = -1;
            raw[i] = (int) (Math.random() * 100 * p);
        }

        for (int i = 0; i < can_size; i++){
            Candidate e = new Candidate(init(), 0);
        }
    }

    public Candidate Fitness(Candidate candidate){
        int[] temp = candidate.getGeno();
        int fit = 0;

        for(int i = 0; i < num; i ++){
            fit += raw[i] * temp[i];
        }
        fit = Math.abs(fit);
        candidate.setFit(fit);
//        Collections.sort(get.parentgeneations, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//
//            public void com
//        });
        return candidate;
    }

    public int[] init( ){
        int[] result = new int[num];
        for (int i = 0; i < num; i ++){
            result[i] = (int) (Math.random());
        }
        return result;
    }

}
