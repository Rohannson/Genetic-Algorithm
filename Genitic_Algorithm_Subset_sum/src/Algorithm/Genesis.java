package Algorithm;

import com.sun.java.swing.ui.OkCancelDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Genesis {

    int num;
    int can_size;
    public ArrayList<Candidate> origin;
    final int[] raw = new int[num];

    public Genesis(int num, int can_size) {
        this.num = num;
        this.can_size = can_size;
        genesy();
    }

    private ArrayList<Candidate> genesy(){
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


    private int[] init( ){
        int[] result = new int[num];
        for (int i = 0; i < num; i ++){
            if(Math.random() > 0.5) result[i] = 1;
            else result[i] = 0;
        }
        return result;
    }

    private int mutate(){
        double d = Math.random();
        if(d > 0.5)
            return 1;
        else
            return 0;
    }

    public Candidate crossover(Candidate P,Candidate Q){
        int l=P.getGeno().length;
        int[] sonCan = new int[l];
        for (int i=0; i<l; i++){
            double d=(Math.random()*100);
            if (d>0 && d<=45)
                sonCan[i]=P.getGeno()[i];
            else if (d>45 && d<=90)
                sonCan[i]=Q.getGeno()[i];
            else
                sonCan[i]=mutate();

        }
        Candidate temp = new Candidate(sonCan, raw);
        return temp;
    }

    public ArrayList<Candidate> evolve(ArrayList<Candidate> generation, int M){
        int N = ((M/100)*generation.size());
        Collections.sort(generation);
        ArrayList<Candidate> temp = new ArrayList<>(generation.size());
        for (int i=0; i<N; i++){
            temp.add((Candidate) generation.get(i));
        }
        return temp;
    }

    public ArrayList<Candidate> breed(ArrayList<Candidate> parent, int M){
        ArrayList<Candidate> temp = new ArrayList<>(M);
        for (int i=0;i<M;i++){
            int P=0, Q=0;
            P=(int)(Math.random()*parent.size());
            Q=(int)(Math.random()*parent.size());
            Candidate son = crossover(parent.get(P),parent.get(Q));
            temp.add(son);
            }
            return temp;
        }
    }


