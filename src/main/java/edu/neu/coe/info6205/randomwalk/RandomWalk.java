/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class RandomWalk {

    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        // TO BE IMPLEMENTED
        this.x+=dx;
        this.y+=dy;
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        // TO BE IMPLEMENTED
        for(int i=0;i<m;i++){
            randomMove();
        }
    }

    /**
     * Private method to generate a random move according to the rules of the situation.
     * That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        // TO BE IMPLEMENTED
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);

            totalDistance = totalDistance + walk.distance();
        }
//        System.out.println("["+(totalDistance/n)+", "+Math.sqrt(m)+"], ");
        return totalDistance / n;
    }

    public static void main(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("Syntax: RandomWalk steps [experiments]");
        int m0 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int m2 = Integer.parseInt(args[2]);
        int m3 = Integer.parseInt(args[3]);
        int m4 = Integer.parseInt(args[4]);
        int m5 = Integer.parseInt(args[5]);

        int n = 20;
//        if (args.length > 1) n = Integer.parseInt(args[1]);
        double meanDistance0 = randomWalkMulti(m0, n);
        double meanDistance1 = randomWalkMulti(m1, n);
        double meanDistance2 = randomWalkMulti(m2, n);
        double meanDistance3 = randomWalkMulti(m3, n);
        double meanDistance4 = randomWalkMulti(m4, n);
        double meanDistance5 = randomWalkMulti(m5, n);

        System.out.println(m0 + " steps: " + meanDistance0 + " over " + n + " experiments"+" | sqrt("+m0+"): "+Math.sqrt(m0));
        System.out.println(m1 + " steps: " + meanDistance1 + " over " + n + " experiments"+" | sqrt("+m1+"): "+Math.sqrt(m1));
        System.out.println(m2 + " steps: " + meanDistance2 + " over " + n + " experiments"+" | sqrt("+m2+"): "+Math.sqrt(m2));
        System.out.println(m3 + " steps: " + meanDistance3 + " over " + n + " experiments"+" | sqrt("+m3+"): "+Math.sqrt(m3));
        System.out.println(m4 + " steps: " + meanDistance4 + " over " + n + " experiments"+" | sqrt("+m4+"): "+Math.sqrt(m4));
        System.out.println(m5 + " steps: " + meanDistance5 + " over " + n + " experiments"+" | sqrt("+m5+"): "+Math.sqrt(m5));
    }

}
