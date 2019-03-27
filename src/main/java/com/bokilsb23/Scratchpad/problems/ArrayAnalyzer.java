package com.bokilsb23.Scratchpad.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        if(args.length == 0){
            args = new String[]{
                    "66",
                    "10",
                    "18",
                    "11",
                    "21",
                    "28",
                    "31",
                    "38",
                    "40",
                    "55",
                    "60",
                    "62"
            };
        }
        if(args.length < 3){
            throw new RuntimeException("Invalid args");
        }
        Integer sum = Integer.parseInt(args[0]);
        Integer arrayLength = Integer.parseInt(args[1]);
        if(args.length != arrayLength + 2){
            throw new RuntimeException("Invalid args");
        }
        Integer[] array = Arrays.stream(Arrays.copyOfRange(args, 2, args.length))
                .map(Integer :: parseInt)
                .toArray(Integer[] :: new);
        System.out.println(analyzeArray(sum, array));
    }

    private static Integer analyzeArray(Integer sum, Integer[] array){
        List<Integer> integers = Arrays.asList(array);
        for(Integer val : integers){
            if(integers.contains(Math.abs(sum - val))){
                return 1;
            }
        }
        return 0;
    }
}
