package com.bokilsb23.Scratchpad.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<List<Integer>> seqList = new ArrayList<>(n);
        /*for(int i =0; i < n; i++){
            seqList.add(new ArrayList<>());
        }*/
        List<Integer> results = new ArrayList<>();
        for(List<Integer> query : queries) {
            if(query.size() != 3) {
                return results;
            }
            int index = ((query.get(1) ^ lastAnswer) % n);
            if(seqList.size() <= index){
                seqList.add(index, new ArrayList<Integer>());
            }
            if(query.get(0) == 1){

                seqList.get(index).add(query.get(2));
            }
            if(query.get(0) == 2) {
                int elementIndex = query.get(2) % seqList.get(index).size();
                if(elementIndex < seqList.get(index).size()) {
                    lastAnswer = seqList.get(index).get(elementIndex);
                    results.add(lastAnswer);
                }
            }
        }
    return results;
    }

    public static void main(String[] args) {
       /* List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new Integer[]{1,0,5}));
        queries.add(Arrays.asList(new Integer[]{1,1,7}));
        queries.add(Arrays.asList(new Integer[]{1,0,3}));
        queries.add(Arrays.asList(new Integer[]{2,1,0}));
        queries.add(Arrays.asList(new Integer[]{2,1,1}));

        List<Integer> values = dynamicArray(2, queries);

        values.stream().forEach(System.out :: println);*/

        List<String> values = leftRotate(new String[]{"1", "2", "3", "4", "5"}, 4);
        values.stream().forEach(System.out :: println);
    }

    static List<String> leftRotate(String[] aItems, int d) {
        List<String> rotatedArray = new ArrayList<>(Arrays.asList(aItems));

        for(int i = 0; i < aItems.length; i++){
            int finalIndex = i - d;
            if(finalIndex < 0) {
                finalIndex += aItems.length;
            }
            rotatedArray.set(finalIndex, aItems[i]);
        }
        return rotatedArray;
    }
}
