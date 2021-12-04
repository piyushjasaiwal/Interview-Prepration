/*
1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
Input Format
A number N
N number of lines, where each line contains 2 strings.
Output Format
Name of every employee and number of employees working under him.
Question Video

  COMMENTConstraints
1 <= N <= 100
Sample Input
6
A C
B C
C F
D E
E F
F F
Sample Output
A 0
B 0
C 2
D 0
E 1
F 5
*/

// import java.io.*;
import java.util.*;

class number_of_emplyees_under_every_manager {

      public static void main(String[] args){
          Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
          
          //write your code here
          HashMap<String, ArrayList<String>> tree = new HashMap<>();
          String root = "";
          while(n-->0){
            String employee = scn.next();
            String manager = scn.next();

            if(employee.equals(manager)){
              root = employee;
            }else{
              ArrayList<String> employees = tree.getOrDefault(manager, new ArrayList<>());
              employees.add(employee);
              tree.put(manager, employees);
            }
          }
          // System.out.println(tree);
          HashMap<String, Integer> ans = new HashMap<>();
          print_employees_count(root, tree, ans);
          for(String employee: ans.keySet()){
            System.out.println(employee+" "+ans.get(employee));
          }
      }

      private static void print_employees_count(String root, HashMap<String, ArrayList<String>> tree, HashMap<String, Integer> ans) {
        employees_count_printer(root, tree, ans);
      }

      private static int employees_count_printer(String root, HashMap<String, ArrayList<String>> tree, HashMap<String, Integer> ans){
        int cnt = 0;
        if(tree.containsKey(root)){
          ArrayList<String> list = tree.get(root);
          for(String employee: list){
            cnt += employees_count_printer(employee, tree, ans);
          }
        }

        // System.out.println(root + " " + cnt);
        ans.put(root, cnt);
        return cnt+1;
      }
}