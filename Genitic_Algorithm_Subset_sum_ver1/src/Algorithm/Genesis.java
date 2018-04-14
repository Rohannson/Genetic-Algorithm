package Algorithm;

import java.util.ArrayList;

public class Genesis {

    private int num;
    private int can_size;
    private ArrayList<Candidate> origin;
    final int[] raw = new int[num];

    public Genesis(int num, int can_size) {
        this.num = num;
        this.can_size = can_size;
        rawset();
        genesis();
    }

    private int[] rawset(){
        double d = 0;
        int p = 0;
        for (int i = 0; i < num; i++) {
            d = Math.random();
            if(d > 0.5) p = 1;
            else p = -1;
            raw[i] = (int) (Math.random() * 100 * p);
        }
        return raw;
    }

    private ArrayList<Candidate> genesis(){
        for (int i = 0; i < can_size; i++){
            Candidate e = new Candidate(num);
            origin.add(e);
        }
        return origin;
    }

    
//    public Candidate fitness(Candidate candidate){
//        int[] temp = candidate.getGeno();
//        int fit = 0;
//
//        for(int i = 0; i < num; i++){
//            fit += raw[i] * temp[i];
//        }
//        fit = Math.abs(fit);
//        candidate.setFit(fit);
//
//        return candidate;
//    }


//        Collections.sort(get.parentgeneations, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//
//            public void com
//        });

}
