package com.company;

/**
 * Created by nati on 2/8/18.
 */
public class Edge {
    public final double cost;
    public final Node target;
    public final Node src;

    public Edge(Node src, Node targetNode, double costVal){
        target = targetNode;
        cost = costVal;
        this.src = src;
    }
}
