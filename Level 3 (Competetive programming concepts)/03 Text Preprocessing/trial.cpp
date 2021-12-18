#include<bits/stdc++.h>
using namespace std;
#define lli long long int
int main(){
    string str;
        string map ;
        int k ;
        cin>>str>>map>>k;

        // for(int val:ar){
        //     System.out.print(val+" ");
        // }
        // System.out.println();
        set<pair<lli, lli>> hashmap ;
        for(int i = 0;i<str.length();i++){
            lli mod = 1000000007;
            lli bad = 0;

            lli hash1 = 0;
            lli hash2 = 0;

            lli p1 = 31;
            lli p2 = 29;
            lli pow1 = 1;
            lli pow2 = 1;
            for(int j = i;j<str.length();j++){
                if(map[str[j]-'a'] == '0'){
                    bad++;
                }
                if(bad > k){
                    break;
                }

                hash1 = (hash1+((str[j]-'a'+1)*pow1))%mod;
                hash2 = (hash2+((str[j]-'a'+1)*pow2))%mod;

                pow1 = (pow1*p1)%mod;
                pow2 = (pow2*p2)%mod;
                hashmap.insert(make_pair(hash1, hash2));
            }
        }
        // System.out.println(set);
        cout<<(hashmap.size());
}