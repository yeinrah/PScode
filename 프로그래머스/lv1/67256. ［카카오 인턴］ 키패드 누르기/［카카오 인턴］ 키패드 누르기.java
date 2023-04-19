class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int r = 10;
        int l = 12;
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                l = n;
            }
            else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                r = n;
            }
            else if (n == 0) {
                n = 11;
                int ld = 0;
                int rd = 0;
                if (l % 3 == 1)
                    ld = 4 - (l / 3);
                else if (l % 3 == 2)
                    ld = 3 - (l / 3);
                if (r % 3 == 0)
                    rd = 5 - (r / 3);
                else if (r % 3 == 2)
                    rd = 3 - (r / 3);
                if (ld < rd) {
                    sb.append("L");
                    l = n;
                }
                else if (rd < ld) {
                    sb.append("R");
                    r = n;
                }
                else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        l = n;
                    }
                    else {
                        sb.append("R");
                        r = n;
                    }
                }
            }
            else {
                int ld = Math.abs(l - n) / 3 + Math.abs(l - n) % 3;
                int rd = Math.abs(r - n) / 3 + Math.abs(r - n) % 3;
                if (ld < rd) {
                    sb.append("L");
                    l = n;
                }
                else if (rd < ld) {
                    sb.append("R");
                    r = n;
                }
                else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        l = n;
                    }
                    else {
                        sb.append("R");
                        r = n;
                    }
                }
            }
        }
        return sb.toString();
    }
}