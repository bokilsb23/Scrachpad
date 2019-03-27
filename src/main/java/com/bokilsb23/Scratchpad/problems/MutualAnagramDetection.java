package com.bokilsb23.Scratchpad.problems;

import java.util.*;
import java.util.stream.Collectors;

public class MutualAnagramDetection {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("pear");
        wordList.add("amleth");
        wordList.add("dormitory");
        wordList.add("tinsel");
        wordList.add("dirty room");
        wordList.add("hamlet");
        wordList.add("listen");
        wordList.add("silnet");

        getAnagrams(wordList).stream().forEach(System.out :: println);
    }

    static List<String> getAnagrams(List<String> wordList){
        List<String> anagramList = new ArrayList<>();
        List<String> visitedList = new ArrayList<>();
        for(int i = 0; i < wordList.size(); i++){
            List<String> anagrams = new ArrayList<>();
            String word = wordList.get(i);
            if(visitedList.contains(word)){
                continue;
            }
            anagrams.add(word);
            visitedList.add(word);
            for(int j = wordList.size()-1; j > i; j--){
                String candidate = wordList.get(j);
                if(isAnagram(word, candidate)){
                    anagrams.add(candidate);
                    visitedList.add(candidate);
                }
            }
            Collections.sort(anagrams);
            anagramList.add(anagrams.stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining(",")));
        }
        Collections.sort(anagramList);
        return anagramList;
    }

    static List<String> convertToListOfStrings(Set<List<String>> anagramListSet){
        List<String> arrayList = new ArrayList<>();
        for(List<String> anagramList : anagramListSet){
            String collect = anagramListSet.stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining(","));
            arrayList.add(collect);
        }
        return arrayList;
    }

    private static boolean isAnagram(String str1, String str2){
        str1 = str1.replace(" ","").toLowerCase();
        str2 = str2.replace(" ","").toLowerCase();
        List<Character> chars1 = str1.chars()
                .mapToObj(e -> (char)e).collect(Collectors.toList());

        List<Character> chars2 = str2.chars()
                .mapToObj(e -> (char)e).collect(Collectors.toList());

        return chars1.size() == chars2.size() && chars1.containsAll(chars2) && chars2.containsAll(chars1);
    }
}
