package Algorithm;

import java.util.ArrayList;

public class Genesis {

    int num;
    int can_size;
    public ArrayList<Candidate> origin;
    final int[] raw = new int[num];

    public Genesis(int num, int can_size) {
        this.num = num;
        this.can_size = can_size;
    }

    public ArrayList<Candidate> genesy(){
        origin = new ArrayList<>();
        double d = 0;
        int p = 0;
        for (int i = 0; i < num; i++) {
            d = Math.random();
            if(d > 0.5) p = 1;
            else p = -1;
            raw[i] = (int) (Math.random() * 100 * p);
        }
        for (int i = 0; i < can_size; i++){
            Candidate e = new Candidate(init(), raw);
            origin.add(e);
        }
        return origin;
    }


    public int[] init( ){
        int[] result = new int[num];
        for (int i = 0; i < num; i ++){
            if(Math.random() > 0.5) result[i] = 1;
            else result[i] = 0;
        }
        return result;
    }

    
}
