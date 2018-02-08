package com.company;

import java.util.*;

public class Main {

    public static double getHeuristic(Node src, Node dest){
        return 0.0;
    }

    public static void main(String[] args) {
	// write your code here
    }

    public static double astar(Node src, Node dest){
        Set<Node> closedSet  = new HashSet<Node>();
        Map<String, Node> openNodeMap = new HashMap<>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>(){
                    //override compare method
                    public int compare(Node i, Node j){
                        if(i.f_scores > j.f_scores){
                            return 1;
                        }

                        else if (i.f_scores < j.f_scores){
                            return -1;
                        }

                        else{
                            return 0;
                        }
                    }

                }
        );
        queue.add(src);
        openNodeMap.put(src.value, src);
        src.g_scores = 0;
        src.f_scores = src.g_scores + getHeuristic(src, dest);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            openNodeMap.remove(cur.value);
            if(cur.toString().equals(dest.toString())) return cur.f_scores;
            closedSet.add(cur);
            for(Node n:getNeighbours(cur)){
                if(!closedSet.contains(n)){
                    n.g_scores = cur.g_scores +1;
                    n.f_scores = n.g_scores + getHeuristic(n, dest);
                    if(!queue.contains(n)){
                        queue.add(n);
                        openNodeMap.put(n.value, n);
                    }
                    else {
                        Node openN = openNodeMap.get(n.value);
                        if(n.g_scores<openN.g_scores){
                            queue.remove(openN);
                            openN.g_scores = n.g_scores;
                            openN.parent = n.parent;
                            openNodeMap.put(n.value, openN);
                            queue.add(n);
                        }
                    }
                }
            }
        }

        return 0.0;

    }

    public static List<Node> getNeighbours(Node n){
        return new ArrayList<>();
    }

}
