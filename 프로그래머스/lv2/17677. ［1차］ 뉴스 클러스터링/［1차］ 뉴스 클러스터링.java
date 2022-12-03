import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		int cnt = 0;

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		for (int i = 0; i < str1.length() - 1; i++)
			if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1)))
				arr1.add(str1.substring(i, i + 2));
		for (int i = 0; i < str2.length() - 1; i++)
			if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1)))
				arr2.add(str2.substring(i, i + 2));

		if (arr1.size() == 0 && arr2.size() == 0)
			return 65536;
		
		for (int i = 0; i < arr1.size(); i++)
			for (int j = 0; j < arr2.size(); j++)
				if (arr1.get(i).equals(arr2.get(j))) {
					cnt++;
					arr1.set(i, "1");
					arr2.set(j, "2");
				}
		return cnt * 65536 / (arr1.size() + arr2.size() - cnt);
    }
}