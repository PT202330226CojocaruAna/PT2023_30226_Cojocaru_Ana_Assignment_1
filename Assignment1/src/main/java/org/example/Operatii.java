package org.example;

public class Operatii {

    public static void Adunare(Polinom p, Polinom q) {

        Polinom result = new Polinom("");

        for (Integer key : p.keySet()) {
            if (q.containsKey(key)) {
                result.put(key, p.get(key) + q.get(key));
                q.remove(key);
            } else result.put(key, p.get(key));
        }

        for (Integer key : q.keySet()) result.put(key, q.get(key));

        MainFrame.set(result);
        System.out.println(result.toString());
    }

    public static void Scadere(Polinom p, Polinom q){

        Polinom result = new Polinom("");

        for (Integer key : p.keySet()) {
            if (q.containsKey(key)) {
                result.put(key,p.get(key) - q.get(key));
                q.remove(key);
            } else
                result.put(key, p.get(key));
        }
        for (Integer key : q.keySet()) {
            result.put(key, q.get(key));
        }
        MainFrame.set(result);
        System.out.println(result.toString());

    }

    public static void Inmultire(Polinom p, Polinom q){

        Polinom result = new Polinom("");
        for (Integer i1 : p.keySet()){
            for( Integer i2 : q.keySet()){
                Integer cheie=i1+i2;
                Double value=p.get(i1)*q.get(i2);
                result.put(cheie, value);
            }
        }
        MainFrame.set(result);

    }
    public static void Impartire(Polinom p, Polinom q){}
    public static void Derivare(Polinom p){

        Polinom result= new Polinom("");
        for (Integer i: p.keySet()) {
            double coef = p.get(i) * i;
            if(i>0) result.put(i-1,coef);
        }
        MainFrame.set(result);
    }
    public static void Integrare(Polinom p, Polinom q){

        Polinom result= new Polinom("");
        for (Integer i: p.keySet()) {
            double coef = p.get(i)/(i+1);
           result.put(i+1,coef);
        }
        MainFrame.set(result);
    }
}
