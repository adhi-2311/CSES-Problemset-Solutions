 public static void process()throws IOException
  {
    /*
Partition equal subset sum problem + 0/1 knapsack

target sum= ((n*(n+1))/2)/2

dp[i][j] = number of ways to make sum j using subsets of the numbers 1..i .

we either include ith element or exclude it from our subset
dp[i][j]=
{
    dp[i-1][j]               if(j<i)
    dp[i-1][j]+dp[i-1][j-i]  if(j>=i)
}

ans=dp[n-1][targetSum]

dp[n-1][] is desired not n because,by excluding last element i.e n from subset we are putting
it in different subset ensuring pairs only once.

eg:
For example, if n=7, there are four solutions:
{1,3,4,6} and {2,5,7}
{1,2,5,6} and {3,4,7}
{3,5,6}   and {1,2,4,7}
{2,3,4,5} and {1,6,7}


    */
    long MOD=1000000007l;
    int n=ni();
    long sum1=(long)((n*(n+1))/2);
    if(sum1%2!=0)
    {
        pn(0);
        return;
    }
    long sum=(long)(sum1/2);
    long dp[][]=new long[n+1][(int)(sum)+1];
    
    dp[0][0]=1;
    for(int i=1;i<=n;i++)
    {
      for(int j=0;j<sum+1;j++)
      {
        dp[i][j]=(dp[i-1][j]%MOD);
        if(i<=j && dp[i-1][j-i]!=0)
        dp[i][j]=(dp[i][j]+dp[i-1][j-i])%MOD;

      }
    }
    int ans=(int)((dp[n-1][(int)(sum)]));
    pn(ans);
    
  }
