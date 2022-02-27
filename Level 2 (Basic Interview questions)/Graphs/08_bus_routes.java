/*abstract
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[1] = [1, 5, 7], this means that the 1st bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.

You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
Input Format
Input is already handled for you.
Output Format
return the least number of buses you need to take.
Question Video

  COMMENTConstraints
1 <= routes.length <= 500.
1 <= routes[i].length <= 10^5.
All the values of routes[i] are unique.
0 <= routes[i][j] < 10^6.
0 <= source, target < 10^6.
Sample Input
2
3
1 2 7
3 6 7
1 6
Sample Output
2
*/

import java.io.*;
import java.util.*;

class bus_routes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
        String[] st = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
        }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<routes[i].length;j++){
                ArrayList<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());
                list.add(i);
                map.put(routes[i][j], list);
            }
        }

        HashSet<Integer> busStopVisited = new HashSet<>();
        HashSet<Integer> busNoVisited = new HashSet<>();

        LinkedList<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(S);
        busStopVisited.add(S);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int rem = q.removeFirst();
                if(rem == T){
                    return level;
                }

                ArrayList<Integer> busFromThisStop = map.get(rem);
                
                for(int bus : busFromThisStop){
                    if(busNoVisited.contains(bus)){
                        continue;
                    }

                    int [] arr = routes[bus];
                    for(int busStop : arr){
                        if(busStopVisited.contains(busStop)){
                            continue;
                        }
                        q.add(busStop);
                        busStopVisited.add(busStop);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
