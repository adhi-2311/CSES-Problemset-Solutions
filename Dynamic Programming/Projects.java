static class Pair{
        long s,e,p;
        Pair(long _s,long _e,long _p)
        {
            s=_s;
            e=_e;
            p=_p;
        }
    }
    public static int bs(Pair arr[],int i)
    {
        int l=0,h=i-1;
        int ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(arr[mid].e<arr[i].s)
            {
              if(arr[mid+1].e < arr[i].s)
                l=mid+1;
            else
                return mid;
            }
            else
              h=mid-1;
        }
        return ans;
    }
   
  public static void process()throws IOException
  {
 
     int n=ni();
    Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new Pair(nl(),nl(),nl());
        }
        Arrays.sort(arr,(a,b)->Long.compare(a.e,b.e));
        long dp[]=new long[n];
        dp[0]=arr[0].p;
        
        for(int i=1;i<n;i++)
        {
            int j=bs(arr,i);
 
            if(j!=-1)
            dp[i]=Math.max(dp[j]+arr[i].p,dp[i-1]);
            else
            dp[i]=Math.max(arr[i].p,dp[i-1]);
          
        }
        pn(dp[n-1]);
 
  }
