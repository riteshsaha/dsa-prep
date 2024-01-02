// https://leetcode.com/problems/sum-of-beauty-of-all-substrings

package strings;

public class SumOfBeautyOfAllSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(beautySum("aabcb"));
		System.out.println(beautySum("aabcbaa"));
	}
	
	public static int beautySum(String s) {
	    if(s.length() == 0) {
	    	return 0;
	    }
	    
	    int totalBeautySum = 0;
	    for(int i = 0; i < s.length(); i++) {
	    	int[] charFreq = new int[26];
	    	for(int j = i; j < s.length(); j++) {
	    		charFreq[s.charAt(j) - 'a']++;
	    		totalBeautySum += calcBeauty(charFreq);
	    	}
	    }
	    return totalBeautySum;
	}
	
	public static int calcBeauty(int[] charFreq) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int freq : charFreq) {
			if(freq > max) {
				max = freq;
			} 
			
			if(freq > 0 && freq < min) {
				min = freq;
			}
		}
		return max - min;
	}
}
