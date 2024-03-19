class Solution {
    public boolean solution(String s) {
        boolean onlyNum = true;
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                onlyNum = false;
        return (s.length() == 4 || s.length() == 6) && onlyNum; 
    }
}