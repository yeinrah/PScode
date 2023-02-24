class Solution {
    public int solution(int[] common) {
        for (int i = 0; i < common.length - 2; i++) {
            if (common[i + 1] - common[i] == common[i + 2] - common[i + 1])
                return common[common.length - 1] + common[i + 1] - common[i];
            if (common[i + 1] / common[i] == common[i + 2] / common[i + 1])
                return common[common.length - 1] * (common[i + 1] / common[i]);
        }
        return 0;
    }
}