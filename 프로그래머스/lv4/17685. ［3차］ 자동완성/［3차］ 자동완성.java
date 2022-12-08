import java.util.*;

class Solution {
	public static int solution(String[] words) {
		int answer = 0;

		Arrays.sort(words);

		for(int i = 0; i < words.length; i++) {
            int cnt1 = 0;
            int cnt2 = 0;
            if (0 < i) {
                for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j++) {
                    if (words[i].charAt(j) == words[i - 1].charAt(j))
                        cnt1++;
                    else 
                        break;
                }
            }
            if (i < words.length - 1) {
                for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                    if (words[i].charAt(j) == words[i + 1].charAt(j))
                        cnt2++;
                    else
                        break;
                }
            }
            
            int cnt = Math.max(cnt1, cnt2);
            
			if(cnt < words[i].length())
				answer += cnt + 1;
			else
				answer += cnt;
		}
		return answer;
	}
}