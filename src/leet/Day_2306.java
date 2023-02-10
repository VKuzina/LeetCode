package leet;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Day_2306 {
	
	public static long distinctNames(String[] ideas) {
		LinkedHashMap<Character, Set<String>> map = new LinkedHashMap<>(); 
	        
        for (String idea : ideas) {
        	char first_letter = idea.charAt(0);
        	String substring = idea.substring(1);
            
            if (map.containsKey(first_letter)) map.get(first_letter).add(substring);
            else {
            	HashSet<String> list = new HashSet<String>();
            	list.add(substring);
            	map.put(first_letter, list);
            }
        }
        long sum = 0;
        
        for (Character key1 : map.keySet()) {
        	Set<String> s1= map.get(key1);
            for (Character key2 : map.keySet()) {
                if (key1 == key2) continue;

                Set<String> s2= map.get(key2);
                Set<String> intersection = new HashSet<String>(s1);
                intersection.retainAll(s2);

                sum += (s1.size() - intersection.size()) * (s2.size() - intersection.size());
            }
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
		String[] ideas = {"aaa","baa","caa","bbb","cbb","dbb"};
		distinctNames(ideas);
	}
}
