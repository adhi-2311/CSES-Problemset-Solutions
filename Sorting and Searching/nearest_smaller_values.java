//https://cses.fi/problemset/task/1645
//https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/


import java.util.*;
import java.io.*;
import java.math.*;
public class Cses
{  
    static long MOD = (long)(1e9 + 7);
    // IMPLEMENTATION GOES HERE
    public static void process()throws IOException
    {
     Stack<Long> s=new Stack<Long>();
     Stack<Integer> idx=new Stack<Integer>();
     int n=ni();
     long arr[]=larr(n);
    
     s.push(arr[0]);
     idx.push(1);

     for(int i=0;i<n;i++)
     {
      while(!s.empty() && s.peek()>=arr[i])
        {
         s.pop();
         idx.pop();
         }
      if(!s.empty())
        p(idx.peek()+" ");
      else
        p(0+" ");
      s.push(arr[i]);
      idx.push(i+1);
     }

    }
 
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;
 
        //oj = System.getProperty("ONLINE_JUDGE") != null;
        //if(!oj) sc=new AnotherReader(100);
 
        long s = System.currentTimeMillis();
      //int T=ni(); while(T-->0)
            process();
        out.flush();
        if(!oj)
            System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }
    static void sort(long arr[],int n)
    {
    shuffle(arr,n);
    Arrays.sort(arr);
    }
    static void shuffle(long arr[],int n)
    {
        Random r=new Random();
        for(int i=0;i<n;i++)
        {
          long temp=arr[i];
          int pos=i+r.nextInt(n-i);
          arr[i]=arr[pos];
          arr[pos]=temp;
        }
    }
 
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static String nn()throws IOException{return sc.next();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static int[] iarr(int N)throws IOException{int[]ARR=new int[N];for(int i=0;i<N;i++){ARR[i]=ni();}return ARR;}
    static long[] larr(int N)throws IOException{long[]ARR=new long[N];for(int i=0;i<N;i++){ARR[i]=nl();}return ARR;}
    static boolean multipleTC=false;
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
