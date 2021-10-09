//https://cses.fi/problemset/task/1635
/*
Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to calculate the number of distinct ways you can produce a money sum x using the available coins.

For example, if the coins are {2,3,5} and the desired sum is 9, there are 8 ways:
2+2+5
2+5+2
5+2+2
3+3+3
2+2+2+3
2+2+3+2
2+3+2+2

Here order does not matter
               9
             / | \
            7  6  4
           /|\
          5 4 2....

*/
#include <iostream>
using namespace std;
int main()
{
long long int MOD=1000000007;
long long int n,x;
cin>>n;
cin>>x;
long long int arr[n];
     for(int i=0;i<n;i++)
      {
          int c;
          cin>>c;
          arr[i]=c;
      }
     long long int dp[x+1];
     dp[0]=1;
     for(int i=1;i<=x;i++)
        dp[i]=0;
     for(int i=1;i<=x;i++)
     {
      for(int j=0;j<n;j++)
      {
        if((i-arr[j])>=0)
        {
          dp[i]=(dp[i]+dp[i-arr[j]])%MOD;
        }
      }
     }
 
    cout<<(dp[x]);
 
 
}
