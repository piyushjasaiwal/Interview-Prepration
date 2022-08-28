/*
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
Input Format
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output Format
[null, null, null, null, null, null, null, 5, 7, 5, 4]
Question Video

  COMMENTConstraints
0 <= val <= 109
At most 2 * 104 calls will be made to push and pop.
It is guaranteed that there will be at least one element in the stack before calling pop.
Sample Input
 
Sample Output
 
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

class max_frequency_stack {
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Pair> map = new HashMap<>();


    }
}

class Pair implements Comparable<Pair>{

    int val;
    int freq;
    int idx;

    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        if(this.freq != o.freq){
            return o.freq - this.freq;
        }

        return o.idx - this.idx;
    }

    Pair(){
        this(0,0,0);
    }

    public Pair(int i, int j, int k) {
        val = i;
        freq = j;
        idx = k;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{"+val+", "+freq+", "+idx+"}";
    }
}
