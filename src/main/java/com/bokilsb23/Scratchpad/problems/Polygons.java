package com.bokilsb23.Scratchpad.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Polygons {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{"36 30 36 30",
                "15 15 15 15",
                "46 96 90 100",
                "86 86 86 86",
                "100 200 100 200",
                "-100 200 -100 200"});
        System.out.println(findPolygons(input));
    }

    private static String findPolygons(List<String> sides){
        Integer SQUARES = 0;
        Integer RECTANGLES = 0;
        Integer OTHER_POLYGONS = 0;
        for(int i=0; i< sides.size(); i++){
            Integer[] s = Arrays.stream(sides.get(i).split(" "))
                    .map(Integer::parseInt).toArray(Integer[] :: new);
            if(s.length < 4){
                continue;
            }
            if(s[0].compareTo(0) <= 0 || s[1].compareTo(0) <= 0 || s[2].compareTo(0) <= 0 || s[3].compareTo(0) <= 0){
                OTHER_POLYGONS++;
            }
            else if(s[0].equals(s[1])  && s[0].equals(s[2]) && s[0].equals(s[3])){
                SQUARES++;
            }
            else if(s[0].equals(s[2]) && s[1].equals(s[3])){
                RECTANGLES++;
            }
            else{
                OTHER_POLYGONS++;
            }
        }
        return SQUARES +" "+ RECTANGLES +" "+ OTHER_POLYGONS;
    }
}
