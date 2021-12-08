/*abstract
Pepcoding offers total of n courses labelled from 0 to n-1.

Some courses may have prerequisites. you have been given m pairs ai,bi. where 1 pair means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses. If it is impossible to finish all courses print -1.
Input Format
first line contains 2 numbers n,m wher n represents number of course and m is number of pairs representing prerequisite. Then m lines follow, each line has 2 space separated integers ai , bi.
Output Format
Print the ordering of courses you should take to finish all courses.Print the ordering of courses you should take to finish all courses.
Question Video

  COMMENTConstraints
1 <= numCourses <= 2000
0 <= ai, bi < numCourses
ai != bi
All the pairs ai,bi are distinct.
Sample Input
4 4
1 0
2 0
3 1
3 2
Sample Output
0 1 2 3 
*/

import java.io.*;
import java.util.*;


class pepcoding_course_schedule {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
          graph.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);
            graph.get(u).add(v);
        }
        // System.out.println(does_loop_exist(graph));
        if(!does_loop_exist(graph)){
            solve(graph);
        }else{
            System.out.println(-1);
        }
	}

    private static boolean does_loop_exist(ArrayList<ArrayList<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        int [] dfs_vis = new int[graph.size()];
        for(int i = 0;i<graph.size();i++){
            if(!visited.contains(i)){
                if(isLoop(i, graph, dfs_vis, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isLoop(int src, ArrayList<ArrayList<Integer>> graph, int[] dfs_vis, HashSet<Integer> visited) {
        if(visited.contains(src)){
            if(dfs_vis[src] == 1){
                return true;
            }else{
                return false;
            }
        }

        dfs_vis[src] = 1;
        visited.add(src); 
        for(int next : graph.get(src)){
            if(isLoop(next, graph, dfs_vis, visited)){
                return true;
            }
        }
        dfs_vis[src] = 0;
        return false;
    }

    private static void solve(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> course = new ArrayList<>();
        boolean flag = false;

        for(int i = 0;i<graph.size();i++){
            course = new ArrayList<>();
            DFS(i, graph, new HashSet<>(), course);
            if(course.size() == graph.size()){
                flag = true;
                break;
            }
        }

        if(flag){
            for(int val:course){
                System.out.print(val+" ");
            }
            return ;
        }
        System.out.println(-1);
    }

    private static void DFS(int src, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> hashSet, ArrayList<Integer> course) {
        if(hashSet.contains(src)){
            return ;
        }

        hashSet.add(src);

        for(int next:graph.get(src)){
            if(!hashSet.contains(next)){
                DFS(next, graph, hashSet, course);
            }
        }

        course.add(src);
    }
}
