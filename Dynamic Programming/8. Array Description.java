
public static void process()throws IOException
  {
 
     int n=ni();
     int m=ni();
     int arr[]=iarr(n);
     long MOD=1000000007l;
     long dp[][]=new long[m+2][n];
     int ans=0;
     if(arr[0]==0)
     {
      for(int i=1;i<=m;i++)
        dp[i][0]=1l;
     }
     else
      dp[arr[0]][0]=1l;
 
     
      for(int i=1;i<n;i++)
      {
        if(arr[i]!=0)
        {
          dp[arr[i]][i]=(dp[arr[i]-1][i-1]%MOD +dp[arr[i]][i-1]%MOD + dp[arr[i]+1][i-1]%MOD)%MOD;
        } 
        else
        {
          for(int j=1;j<=m;j++)
          {
            dp[j][i]=(dp[j-1][i-1]%MOD+ dp[j][i-1]%MOD +dp[j+1][i-1]%MOD)%MOD;
          }
          
        }
      }
     
     
      if(arr[n-1]!=0)
        {
          pn(dp[arr[n-1]][n-1]%MOD);
          return;
        }
 
      long sum=0l;
      for(int i=1;i<=m;i++)
        sum=(sum%MOD+dp[i][n-1]%MOD)%MOD;
      pn(sum%MOD);
        
    
 
  }
