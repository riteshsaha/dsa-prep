// https://leetcode.com/problems/sort-characters-by-frequency/

package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frequencySortUsingPQ("tree"));
		System.out.println(frequencySortUsingList("Aabb"));
	}
	
	public static String frequencySortUsingPQ(String s) {
		Map<Character, Integer> countMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
		pq.addAll(countMap.keySet());
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			char ch = pq.poll();
			// New string is appended with the frequency at which the character is present
			for(int i = 0; i < countMap.get(ch); i++) {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	
	}
	
	public static String frequencySortUsingList(String s) {
		Map<Character, Integer> countMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		List<Character> chars = new ArrayList<>(countMap.keySet());
		Collections.sort(chars, (a,b) -> countMap.get(b) - countMap.get(a));
		
		StringBuilder sb = new StringBuilder();
		for(Character ch : chars) {
			// New string is appended with the frequency at which the character is present
			for(int i = 0; i < countMap.get(ch); i++) {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	
	}
}
