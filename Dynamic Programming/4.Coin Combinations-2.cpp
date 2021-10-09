/*
Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to calculate the number of distinct ordered ways you can produce a money sum x using the available coins.

For example, if the coins are {2,3,5} and the desired sum is 9, there are 3 ways:
2+2+5
3+3+3
2+2+2+3

Here ordering matters, so we take each coin and check the number of ways they can make a sum i
1.
coins[0]=2
dp[]
possible

2
2+2
2+2+2

amount  0 1 2 3 4 5 6 7 8 9
        -------------------
ways    1 0 1 0 1 0 1 0 1 0
-------------------------------------------------------------------------
2.
coins[1]=3
dp[]
possible

2     +3
2+2   +3
2+2+2 +3
3
3+3
3+3+3

amount  0 1 2 3 4 5 6 7 8 9
        -------------------
ways    1 0 1 1 1 1 2 1 2 2
-------------------------------------------------------------------------
2.
coins[2]=5
dp[]
possible


3+5
5
2+5
3+5
2+2+5


amount  0 1 2 3 4 5 6 7 8 9
        -------------------
ways    1 0 1 1 1 2 2 2 3 3

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
      cin>>arr[i];
      
     long long int dp[x+1];
     for(int i=0;i<=x;i++)
     dp[i]=0;
     dp[0]=1;
     
    for(int i=0;i<n;i++)
     {
      for(int j=arr[i];j<=x;j++)
      {
        dp[j]=(dp[j]%MOD+dp[j-arr[i]]%MOD)%MOD;
      }
     }
 
    cout<<dp[x];
 
 
}
