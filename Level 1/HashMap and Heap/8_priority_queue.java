/*
1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
None
Sample Input
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit
Sample Output
10
10
10
20
20
30
30
40
40
50
*/

import java.io.*;
import java.util.*;

class priority_queue {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size()-1);
    }

    public int remove() {
      // write your code here
      if(data.size() <= 0){
          System.out.println("Underflow");
          return -1;
      }

      int val = data.remove(0);
      downheapify(0);
      return val;
    }

    public int peek() {
      // write your code here
      if(data.size() <= 0){
        System.out.println("Underflow");
        return -1;
    }

    return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }

    public void upheapify(int i){
        int up_idx = (i-1)/2;
        if(up_idx<0){
            return ;
        }
        if(up_idx == 0){
            if(data.get(up_idx) > data.get(i)){
                int up_idx_th = data.get(up_idx);
                int i_th = data.get(i);

                data.set(up_idx, i_th);
                data.set(i, up_idx_th);
            }
            return ;
        }

        if(data.get(up_idx) > data.get(i)){
            int up_idx_th = data.get(up_idx);
            int i_th = data.get(i);

            data.set(up_idx, i_th);
            data.set(i, up_idx_th);
            upheapify(up_idx);
        }

    }

    public void downheapify(int i){
        int li = (2*i)+1;
        int ri = (2*i)+2;

        int min_idx = i;
        if(li < data.size() && data.get(li) < data.get(min_idx)){
            min_idx = li;
        }

        if(ri < data.size() && data.get(ri) < data.get(min_idx)){
            min_idx =ri;
        }

        if(min_idx != i){
            swap(min_idx, i);
            downheapify(min_idx);
        }
    }

    public void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);

        data.set(i, jth);
        data.set(j, ith);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}