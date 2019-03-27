package com.bokilsb23.Scratchpad.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeltaEncoding {
    private static final Integer ESCAPE_INT = -128;
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(new Integer[]{25626, 25757, 24367, 24267, 16, 100, 2, 7277});
        System.out.println(encode(intList).stream().map(n -> n.toString()).collect(Collectors.joining(" ")));

    }

    private static List<Integer> encode(List<Integer> input){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            if(i == 0){
                result.add(input.get(i));
            }
            else{
                int diff = input.get(i) - input.get(i-1);
                if(Math.abs(diff) > 127){
                    result.add(ESCAPE_INT);
                }
                result.add(diff);
            }
        }
        return result;
    }
}
