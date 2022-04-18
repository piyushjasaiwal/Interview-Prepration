/*abstract
1. A Professor conducts a Computer Science paper for N students. He had strictly instructed all students to sit according to their roll numbers. However when he started checking the papers, he found out that all the papers were randomly ordered because the students had sat randomly during the exam instead of sitting according to their roll numbers. The order is given in list of integers roll[ ]. The professor became very angry and he wanted to teach the students a lesson.
2. He decided to sort the papers according to roll numbers by Bubble Sort and count the number of swaps required for each and every student and deduct as many marks of a student as were the number of swaps required for that student. The marks of every student is given in list of integers marks[ ] in the order in which they were sitting. However he also has to maintain the class average greater than or equal to a set minimum avg, else he may lose his job. 
3. The Professor wants to know whether he should punish the students or save his job.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
 1 <= N <= 1000
Sample Input
5
3 2 4 1 5
50 67 89 79 58
68
Sample Output
false
*/

import java.util.*;
import java.io.*;

class punish_the_students {

    public static boolean shouldPunish(int[]roll, int[]marks, double avg) {
        //write your code here
        for(int i = 0;i<roll.length-1;i++){
            int swap = 0;
            for(int j = 0;j<roll.length-i-1;j++){
                if(roll[j] > roll[j+1]){
                    swap++;
                    int temp = roll[j+1];
                    roll[j+1] = roll[j];
                    roll[j] = temp;
                }
            }
            marks[i] -= swap;
        }
        double total = 0.0;
        // System.out.println("----------------------------------------------");
        for(int i = 0;i<roll.length;i++){
            // System.out.print(roll[i]+" ");
            total+=marks[i];
        }
        // System.out.println("\n----------------------------------------------");
        total = total/marks.length;
        return (total >= avg);
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]roll = new int[n];

        for (int i = 0; i < n; i++) {
            roll[i] = scn.nextInt();
        }

        int[]marks = new int[n];

        for (int i = 0; i < n; i++) {
            marks[i] = scn.nextInt();
        }

        double avg = scn.nextDouble();

        System.out.println(shouldPunish(roll, marks, avg));
    }
}