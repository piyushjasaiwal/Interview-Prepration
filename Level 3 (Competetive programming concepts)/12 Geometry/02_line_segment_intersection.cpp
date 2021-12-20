#include<bits/stdc++.h>
using namespace std;

bool isTouch(long x1, long y1, long x2, long y2, long x3, long y3){
    long ans = ((x3-x2)*(y2-y1)) - ((y3-y2)*(x2-x1));
    return ans == 0;
}

int main(){
    int t ;
    cin>>t;
    while(t--){
        long x1, y1, x2, y2, x3, y3, x4, y4;
        cin>>x1>>y1>>x2>>y2>>x3>>y3>>x4>>y4;

        long val = ((x4-x3)*(y2-y1)) - ((y4-y3)*(x2-x1));
        if(val == 0){
            if(isTouch(x1, y1, x2, y2, x3, y3) && isTouch(x1, y1, x2, y2, x4, y4)){
                cout<<"YES\n";
            }else{
                cout<<"NO\n";
            }
        }else{
            cout<<"YES\n";
        }
    }
}