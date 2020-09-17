import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main
{
    /*
    s,e=boundaries of tree
    qs= query start index
    qe= query end index
    v= vertex of tree
    n=array size
    arr[]=given array
    1+2+4+⋯+2^[log2n]=2^[long2n]+1<4n 
    So in worst case the number of vertices will be 4n
    */
    static class SegmentTree{
        long st[], arr[];
        int n;
 
        public SegmentTree(int n, long arr[]){
            this.arr = arr;
            this.n = n;
            st = new long[4 * n + 2];
        }
        long min(long a,long b)
        {
            if(a>b)
                return b;
                return a;
        }
 
        void build(int s, int e, int v)
        {
            if(s == e)//bottom of tree
            {
                st[v] = arr[s];
                return ;
            }
 
            int mid = s + (e - s)/2;
            build(s, mid , 2 * v);//left child
            build(mid + 1, e, 2 *v+ 1);
 
            st[v] = st[2 * v]+st[2 * v + 1];
        }
 
        void set(int i, long val, int s, int e, int v){
            if(i < s || i> e)// update index completely outside the current segment
                return ;
 
            if(s == e)// update index found
            {
                st[v] = val;
                return ;
            } 
 
            int mid = s + (e - s) / 2;
            set(i, val, s, mid, 2 *v);//left
            set(i, val, mid + 1, e, 2 *v+ 1);//right
 
            st[v] =st[2 *v]+st[2 *v+1];
        }
        void update(int i, long val){
           set(i,val,0,n-1,1);
        }
 
        long query(int qs, int qe, int s, int e, int v){
            if(qs <= s && qe >= e)//complete overlapping
                return st[v];
 
            if(qs > e || qe < s)//no overlapping
                return 0;
            //partial overlapping
            int mid = s + (e - s)/2;
            return (query(qs, qe, s, mid, 2 *v)+query(qs, qe, mid + 1, e, 2 * v+ 1));
        }
        long sum(int qs,int qe)
        {
          return query(qs,qe,0,n-1,1);
        }
    }
 
    public static void process()throws IOException
    {
        int n = ni(), q = ni();
        long arr[] = new long[n];
        for(int i =0; i<n; i++)
            arr[i] = nl();
        SegmentTree ob = new SegmentTree(n, arr);
        ob.build(0,n-1, 1);
 
        while(q-- > 0){
            int choice = ni();
 
            if(choice == 2){
                int l = ni()-1, r = ni()-1;
                
                pn(ob.sum(l, r));
            }
            else{
                int i= ni()-1;
                long val= nl();
                ob.update(i,val);
            }
        }
    }
    
 
     
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;
         //PrintWriter out=new PrintWriter("output");
        //oj = System.getProperty("ONLINE_JUDGE") != null;
        //if(!oj) sc=new AnotherReader(100);
 
      //int i=1;
    //int T=ni(); while(T-->0)
      //{
        //p("Case #"+i+": ");
            process();
            //i++;
      //}
        long s = System.currentTimeMillis();
      
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
