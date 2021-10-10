public static void process()throws IOException
  {
 
    /*           (i,j)
             /      \
      (i+1,j)        (i,j-1)-------------P1
      /    \          /     \
  (i+2,j) (i+1,j-1)(i+1,j-1) (i,j-2)--------P2
 
   For player1
  f(i,j)=max(min(a[i]+f(i+2,j), a[i]+f(i+1,j-1)) ,min(a[i]+f(i+1,j-1),a[j]+f(i,j-2)));
  */
   
 
  int n=ni();
  long arr[]=larr(n);
  long dp[][]=new long[n][n];
  
  for(int len=1;len<=n;len++)
  {
    for(int i=0;i+len<=n;i++)
    {
      int j=i+len-1;
      long val1=((i+2<=j)?dp[i+2][j]:0);
      long val2=((i+1<=j-1)?dp[i+1][j-1]:0);
      long val3=+((i<=j-2)?dp[i][j-2]:0);
      dp[i][j]=Math.max(arr[i]+Math.min(val1,val2),arr[j]+Math.min(val2,val3));
    }
  }
  pn(dp[0][n-1]);
 
 
  }
 
