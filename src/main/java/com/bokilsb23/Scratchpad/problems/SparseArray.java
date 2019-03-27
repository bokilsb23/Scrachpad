package com.bokilsb23.Scratchpad.problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SparseArray {

    static long arrayManipulation(long n, int[][] queries) {
        long max = 0;
        List<Integer> list = new ArrayList<>(Math.toIntExact(n));
        //ong[] array = new long[Math.toIntExact(n)];
        for(int i=0; i<n; i++){
            list.add(i, 0);
        }
        for(int[] query : queries){
            if(query.length == 3){
                for(int i = query[0]-1; i < query[1]; i++){
                    int val = list.get(i) + query[2];
                    list.set(i, val);
                    //array[i] = array[i] + query[2];
                    if(val > max){
                        max = val;
                    }
                }
            }
        }
        return max;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int[][] queries = new int[4][3];
        queries[0][0] = 2;
        queries[0][1] = 6;
        queries[0][2] = 8;
        queries[1][0] = 3;
        queries[1][1] = 5;
        queries[1][2] = 7;
        queries[2][0] = 1;
        queries[2][1] = 8;
        queries[2][2] = 1;
        queries[3][0] = 5;
        queries[3][1] = 9;
        queries[3][2] = 15;

        long result = arrayManipulation(10, queries);
        System.out.println(result);

    }
}
