/*
1. Generate all primes between 'a'  and 'b'(both are included).
2. Print every number in new line.
3. Allowed time Complexity : O(nlog(log n)), where n = b - a.
4. Allowed Space Complexity : O(n), where n = b -a;
Note : Please focus on constraints.
Input Format
(Input is managed for you)
22
51
Output Format
23
29
31
37
41
43
47
Question Video

  COMMENTConstraints
1. 1 <= a <= b <= 10^9
2. b - a <= 10^5
Sample Input
22
51
Sample Output
23
29
31
37
41
43
47
*/

import java.util.*;

class segmented_seive {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~

    public static void segmentedSieveAlgo(int a, int b) {
        // write your code here
        int root_b = (int)(Math.sqrt(b));
        ArrayList<Integer> primes = make_seive(root_b);
        boolean [] segmented_seive = new boolean[b-a+1];
        Arrays.fill(segmented_seive, true);
        if(1-a >= 0){
            segmented_seive[1-a] = false;
        }
        for(int prime : primes){
            int start = (int)Math.ceil((1.0*a)/prime);
            if(start == 1){
                start++;
            }
            int start_index = (prime*start);
            while(start_index <= b){
                segmented_seive[start_index-a] = false;
                start_index += prime;
            }
        }

        for(int i = a;i<=b;i++){
            if(segmented_seive[i-a]){
                System.out.println(i);
            }
        }
    }

    public static ArrayList<Integer> make_seive(int n){
        boolean [] seive = new boolean[n+1];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;

        for(int i = 2;i<=n;i++){
            if(seive[i]){
                long last = 1L*i*i;
                if(last <= n){
                    for(int j = i*i;j<=n;j+=i){
                        seive[j] = false;
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2;i<=n;i++){
            if(seive[i]){
                list.add(i);
            }
        }
        return list;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
    }
}
