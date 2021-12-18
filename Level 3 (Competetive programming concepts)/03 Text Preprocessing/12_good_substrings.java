import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
You've got string s, consisting of small English letters. Some of the English letters are good, the rest are bad.

A substring s[l...r] (1 ≤ l ≤ r ≤ |s|) of string s  =  s1s2...s|s| (where |s| is the length of string s) is string  slsl + 1...sr.

The substring s[l...r] is good, if among the letters  sl, sl + 1, ..., sr there are at most k bad ones (look at the sample's explanation to understand it more clear).

Your task is to find the number of distinct good substrings of the given string s. Two substrings s[x...y] and s[p...q] are considered distinct if their content is different, i.e. s[x...y] ≠ s[p...q].

Input
The first line of the input is the non-empty string s, consisting of small English letters, the string's length is at most 1500 characters.

The second line of the input is the string of characters "0" and "1", the length is exactly 26 characters. If the i-th character of this string equals "1", then the i-th English letter is good, otherwise it's bad. That is, the first character of this string corresponds to letter "a", the second one corresponds to letter "b" and so on.

The third line of the input consists a single integer k (0 ≤ k ≤ |s|) — the maximum acceptable number of bad characters in a good substring.

Output
Print a single integer — the number of distinct good substrings of string s.

Examples
inputCopy
ababab
01000000000000000000000000
1
outputCopy
5
inputCopy
acbacbacaa
00000000000000000000000000
2
outputCopy
8
Note
In the first example there are following good substrings: "a", "ab", "b", "ba", "bab".

In the second example there are following good substrings: "a", "aa", "ac", "b", "ba", "c", "ca", "cb".
*/

class good_substrings{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String map = s.next();
        int k = s.nextInt();

        // for(int val:ar){
        //     System.out.print(val+" ");
        // }
        // System.out.println();
        Set<pair> set = new HashSet<>();
        for(int i = 0;i<str.length();i++){
            long mod = 1000000007;
            int bad = 0;

            long hash1 = 0;
            long hash2 = 0;

            long p1 = 31;
            long p2 = 29;
            long pow1 = 1;
            long pow2 = 1;
            for(int j = i;j<str.length();j++){
                if(map.charAt(str.charAt(j)-'a') == '0'){
                    bad++;
                }
                if(bad > k){
                    break;
                }

                hash1 = (hash1+((str.charAt(j)-'a'+1)*pow1))%mod;
                hash2 = (hash2+((str.charAt(j)-'a'+1)*pow2))%mod;

                pow1 = (pow1*p1)%mod;
                pow1 = (pow1*p2)%mod;
                set.add(new pair(hash1, hash2));
            }
        }
        // System.out.println(set);
        System.out.println(set.size());
    }

    static class pair{
        long a, b;
        pair(long a, long b){
            this.a = a;
            this.b = b;
        }

        // to insert different pairs in set otherwise it will be adding duplicate pairs
        public boolean equals(Object o){
            if(o instanceof pair){
                pair p = (pair)o;
                return p.a == this.a && p.b == this.b;
            }
            return false;
        }

        @Override
        public int hashCode(){
            return (int)((Long.valueOf(a).hashCode())*31 + (Long.valueOf(b)));
        }
    }
}