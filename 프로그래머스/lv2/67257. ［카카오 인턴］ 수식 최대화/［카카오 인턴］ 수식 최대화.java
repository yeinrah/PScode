import java.util.*;

class Solution {
    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        List<Long> numList = new ArrayList<>();
        List<Character> operandList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i)))
                sb.append(expression.charAt(i));
            else {
                numList.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operandList.add(expression.charAt(i));
            }
            if (i == expression.length() - 1)
                numList.add(Long.parseLong(sb.toString()));
        }
        
        List<Long> numTemp;
        List<Character> opTemp;
        long max = 0;

        numTemp = new ArrayList<Long>(numList);
        opTemp = new ArrayList<Character>(operandList);
        calcProc(numTemp, opTemp, '+', '-', '*');
        max = Math.max(max, Math.abs(numTemp.get(0)));

        numTemp = new ArrayList<Long>(numList);
        opTemp = new ArrayList<Character>(operandList);
        calcProc(numTemp, opTemp, '+', '*', '-');
        max = Math.max(max, Math.abs(numTemp.get(0)));

        numTemp = new ArrayList<Long>(numList);
        opTemp = new ArrayList<Character>(operandList);
        calcProc(numTemp, opTemp, '-', '+', '*');
        max = Math.max(max, Math.abs(numTemp.get(0)));

        numTemp = new ArrayList<Long>(numList);
        opTemp = new ArrayList<Character>(operandList);
        calcProc(numTemp, opTemp, '-', '*', '+');
        max = Math.max(max, Math.abs(numTemp.get(0)));

        numTemp = new ArrayList<Long>(numList);
        opTemp = new ArrayList<Character>(operandList);
        calcProc(numTemp, opTemp, '*', '+', '-');
        max = Math.max(max, Math.abs(numTemp.get(0)));

        numTemp = new ArrayList<Long>(numList);
        opTemp = new ArrayList<Character>(operandList);
        calcProc(numTemp, opTemp, '*', '-', '+');
        max = Math.max(max, Math.abs(numTemp.get(0)));

        return max;
    }

    public void calcProc(List<Long> numList, List<Character> operandList, Character op1, Character op2, Character op3) {
        calc(numList, operandList, op1);
        calc(numList, operandList, op2);
        calc(numList, operandList, op3);
    }

    public void calc(List<Long> numList, List<Character> operandList, Character ops) {
        int i = 0;
        while (i < operandList.size()) {
            if (ops == operandList.get(i)) {
                if (ops == '*')
                    numList.set(i, numList.get(i) * numList.get(i + 1));
                else if (ops == '+')
                    numList.set(i, numList.get(i) + numList.get(i + 1));
                else if (ops == '-')
                    numList.set(i, numList.get(i) - numList.get(i + 1));
                numList.remove(i + 1);
                operandList.remove(i);
                i--;
            }
            i++;
        }
    }
}