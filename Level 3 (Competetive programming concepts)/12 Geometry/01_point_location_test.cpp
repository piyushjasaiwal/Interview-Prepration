#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin>>t;
    while(t-->0){
        long x1,y1,x2,y2,x3,y3;
        cin>>x1>>y1>>x2>>y2>>x3>>y3;

        long ans = ((x3-x2)*(y2-y1)) - ((y3-y2)*(x2-x1));
        if(ans < 0){
            cout<<"LEFT\n";
        }else if(ans > 0){
            cout<<"RIGHT\n";
        }else{
            cout<<"TOUCH\n";
        }
    }
}

