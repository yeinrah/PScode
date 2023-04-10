import java.util.*;

class Solution {
    // 문제에서 주어진 표의 크기가 50 X 50 으로 고정
    static int[] parent = new int[2501];
    static String[] value = new String[2501];
    
    public String[] solution(String[] commands) {
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }
        List<String> list = new ArrayList<>();
        for (int idx = 0; idx < commands.length; idx++) {
            String[] split = commands[idx].split(" ");
            
            if (split[0].equals("UPDATE")) {
                // UPDATE value1 value2
                if (split.length == 3)
                    for (int i = 1; i <= 2500; i++) {
                        if (value[i].equals(split[1]))
                            value[i] = split[2];
                    }
                // UPDATE x y value
                else {
                    int x = Integer.parseInt(split[1]);
                    int y = Integer.parseInt(split[2]);
                    value[find(convert(x, y))] = split[3];
                }
            }
            
            // MERGE x1 y1 x2 y2
            else if (split[0].equals("MERGE")) {
                int x1 = Integer.parseInt(split[1]);
                int y1 = Integer.parseInt(split[2]);
                int x2 = Integer.parseInt(split[3]);
                int y2 = Integer.parseInt(split[4]);
                int n1 = convert(x1, y1);
                int n2 = convert(x2, y2);
                int root1 = find(n1);
                int root2 = find(n2);
                // 같은 그룹이면 무시
                if (root1 == root2)
                    continue;
                // 값을 가진쪽으로 병합
                String origin = value[root1].equals("") ? value[root2] : value[root1];
                value[root1] = "";
                value[root2] = "";
                union(root1, root2);
                value[root1] = origin;
            }
            
            // UNMERGE x y
            else if (split[0].equals("UNMERGE")) {
                int x = Integer.parseInt(split[1]);
                int y = Integer.parseInt(split[2]);
                int n = convert(x, y);
                int root = find(n);
                String origin = value[root];
                value[root] = "";
                value[n] = origin;
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++)
                    if (find(i) == root)
                        deleteList.add(i);
                for (Integer i : deleteList)
                    parent[i] = i;
            }
            
            // PRINT x y
            else if (split[0].equals("PRINT")) {
                int x = Integer.parseInt(split[1]);
                int y = Integer.parseInt(split[2]);
                int n = convert(x, y);
                int root = find(n);
                if (value[root].equals(""))
                    list.add("EMPTY");
                else
                    list.add(value[root]);
            }
        }
        return list.toArray(new String[0]);
    }
    
    public int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }
    
    public int convert(int x, int y) {
        return (x - 1) * 50 + y;
    }
}