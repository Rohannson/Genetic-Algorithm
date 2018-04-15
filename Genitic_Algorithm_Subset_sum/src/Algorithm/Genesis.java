package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Genesis {

    int num;
    int can_size;
    public ArrayList<Candidate> origin;
    final int[] raw;

    public Genesis(int num, int can_size) {
        this.num = num;
        this.can_size = can_size;
        origin = new ArrayList<>(can_size);
        raw = new int[num];
    }

    public ArrayList<Candidate> genesy(){
        double d;
        int p;
        for (int i = 0; i < num; i++) {
            d = Math.random();
            if(d > 0.5)
                raw[i] = (int) (Math.random() * 10000 * 1);
            else
                raw[i] = (int) (Math.random() * 1000 * (-1));

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

    public int[] mutate(int[] son){
        for(int i = 0; i < 200; i ++ ){
            if(son[i] == 1) son[i] = 0;
            else son[i] = 1;
        }
        return son;
    }

    public Candidate crossover(Candidate P,Candidate Q,int N, int pro){
        int l = P.getGeno().length;
        int M = (int)(((N*1.0/100)*l));
        int[] sonCan = new int[l];
        for (int i=0; i<l; i++){
            double d=Math.random();
            if (d >0.5){
                sonCan[i] = P.getGeno()[i];
            }
            else sonCan[i] = Q.getGeno()[i];
            if((Math.random() * 100000) < pro){
                sonCan = mutate(sonCan);
            }
        }

        Candidate temp = new Candidate(sonCan, raw);
        return temp;

    }

    public ArrayList<Candidate> evolve(ArrayList<Candidate> generation, int M){

        int N = (int)(((M*1.0/100)*generation.size()));

        Collections.sort(generation);
        ArrayList<Candidate> temp = new ArrayList<>(generation.size());
        for (int i=0; i<N; i++){
            temp.add((Candidate) generation.get(i));
        }
        return temp;
    }

    public ArrayList<Candidate> breed(ArrayList<Candidate> parent,int N, int M){
        ArrayList<Candidate> temp = new ArrayList<>(can_size);
        for (int i=1;i<can_size;i++){
            int P=0, Q=0;
            P=(int)(Math.random()*parent.size());
            Q=(int)(Math.random()*parent.size());
            Candidate son = crossover(parent.get(P),parent.get(Q), N, M);
            temp.add(son);
            }
            return temp;
        }
    }


