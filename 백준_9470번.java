import java.util.*;
import java.io.*;
public class 백준_9470번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int K=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			int P=Integer.parseInt(s[2]);
			ArrayList<Integer>[] arr=new ArrayList[M+1];
			for(int i=1;i<=M;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			int[] degree=new int[M+1];
			int[] count=new int[M+1];
			int[] order=new int[M+1];
			for(int i=0;i<P;i++)
			{
				s=br.readLine().split(" ");
				int A=Integer.parseInt(s[0]);
				int B=Integer.parseInt(s[1]);
				arr[A].add(B);
				degree[B]++;
			}
			Queue<Integer> q=new LinkedList<Integer>();
			for(int i=1;i<=M;i++)
			{
				if(degree[i]==0)
				{
					q.add(i);
					order[i]=1;
				}
			}
			while(!q.isEmpty())
			{
				int temp=q.poll();
				for(int next : arr[temp])
				{
					if(order[next]<order[temp])
					{
						order[next]=order[temp];
						count[next]=1;
					}
					else if(order[next]==order[temp])
					{
						count[next]++;
					}
					degree[next]--;
					if(degree[next]==0)
					{
						q.add(next);
						order[next]+=count[next]>=2?1:0;
					}
				}
			}
			System.out.println(K+" "+order[M]);
			T--;
		}
	}
}
