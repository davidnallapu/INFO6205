package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_Client {
	
	
    public static int count(int n){
    	//variable for no. of connections
    	int connections = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n);
        
        Random r = new Random();
        while (uf.components() > 2) {

        	connections++;
        	
        	//Generating random pairs
            int i = r.nextInt(n-1);
            int j = r.nextInt(n-1);
            
            if(uf.connected(i, j)) continue;
            
            //When union is called the counter variable returned by uf.components() from UF_HWQUPC class decreases by 1. 
            uf.union(i, j);
            
        }
        return connections;
    }
    
    public static void main(String[] args) {
    	
    	System.out.printf("%6s %6s %16s\n","n","m","(n*lg(n))/2");
    	System.out.printf("---------------------------------\n");
    	for (int n = 1000; n < 1000000; n *= 2) {
            int count = 0;
            for (int i = 0; i < 10; i++)
                count += UF_Client.count(n);
            System.out.printf("%7d | %7d | %8d |\n", n, count / 10, (int) (n*Math.log(n)/2));
        }
    	
    }
    
}
