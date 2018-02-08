package com.company;

/**
 * Created by nati on 2/8/18.
 */
public class Node {
    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val, double hVal){
        value = val;
        h_scores = hVal;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Node.class)){
            return ((Node)obj).value.equals(this.value);
        }
        return false;
    }

    public String toString(){
        return value;
    }
}
