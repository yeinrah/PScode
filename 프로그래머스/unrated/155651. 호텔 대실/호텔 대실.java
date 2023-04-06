import java.util.*;

class Solution {
    static class Book {
        int in;
        int out;
        
        public Book(String in, String out) {
            this.in = Integer.parseInt(in.split(":")[0]) * 60 + Integer.parseInt(in.split(":")[1]);
            this.out = Integer.parseInt(out.split(":")[0]) * 60 + Integer.parseInt(out.split(":")[1]) + 10;
        }
    }
    
    public int solution(String[][] book_time) {
        PriorityQueue<Book> pq1 = new PriorityQueue<>((a, b) -> a.in - b.in);
        for (String[] b : book_time)
            pq1.add(new Book(b[0], b[1]));
        
        PriorityQueue<Book> pq2 = new PriorityQueue<>((a, b) -> a.out - b.out);
        pq2.add(pq1.poll());
        
        while (!pq1.isEmpty()) {
            Book b1 = pq1.poll();
            Book b2 = pq2.peek();
            if (b2.out <= b1.in)
                pq2.poll();
            pq2.add(b1);
        }
        return pq2.size();
    }
}