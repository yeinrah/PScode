class Solution {
	static int[] answer;

	public int[] solution(int[][] arr) {
		answer = new int[2];
		divide(arr, 0, 0, arr.length);
		return answer;
	}
	
	public void divide(int[][] arr, int x, int y, int l) {
		if (l == 1) {
			answer[arr[x][y]]++;
			return;
		}
		
		if (!check(arr, x, y, l)) {
            divide(arr, x, y, l / 2);
            divide(arr, x + l / 2, y, l / 2);
            divide(arr, x, y + l / 2, l / 2);
            divide(arr, x + l / 2, y + l / 2, l / 2);
        }
	}
	
	public boolean check(int[][] arr, int x, int y, int l) {
		for (int i = x; i < x + l; i++)
			for (int j = y; j < y + l; j++)
				if (arr[x][y] != arr[i][j])
                    return false;
		answer[arr[x][y]]++;
		return true;
	}
}