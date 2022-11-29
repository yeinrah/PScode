class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        String[] skillChar = skill.split("");
        out : for (String s : skill_trees) {
            int prevIndex = 0;
            for (int i = 0; i < skill.length(); i++) {
                if (s.contains(skillChar[i])) {
                    if (prevIndex > s.indexOf(skillChar[i])) {
                        answer--;
                        break;
                    }
                    prevIndex = s.indexOf(skillChar[i]);
                }
                else if (i < skill.length() - 1 && !s.contains(skillChar[i]) && s.contains(skillChar[i + 1])) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}