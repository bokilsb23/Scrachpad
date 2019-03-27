package com.bokilsb23.Scratchpad.problems;

public class StringPermutations {

    static int findPermutations(String s, String b){
        int permutations = 0;
        //int position = 0;
        for(int position = 0; position < (s.length() - b.length());){
            int index = s.indexOf(b , position);
            if(index != -1){
                permutations++;
                position += (index + 1);
            }
            else {
                position++;
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        String s = "abcxyzacxyzayzxabcdeab";
        String b = "xyz";
        System.out.println(findPermutations(s, b));
    }
}