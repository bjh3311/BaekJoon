import java.util.*;
import java.io.*;
	
	
public class 백준_14567번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		int[] degree=new int[N+1];
		int[] sem=new int[N+1];
		int A;
		int B;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			A=Integer.parseInt(s[0]);
			B=Integer.parseInt(s[1]);
			degree[B]++;//진입차수 증가
			arr[A].add(B);
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(degree[i]==0)//진입차수가 없다면 선수과목이 없다는 뜻이다
			{
				sem[i]=1;//그러므로 1학기만에 수강가능
				q.add(i);
			}
		}
		while(!q.isEmpty())
		{
			int now=q.poll();
			for(int i=0;i<arr[now].size();i++)
			{
				int next=arr[now].get(i);
				degree[next]--;
				if(degree[next]==0)
				{
					sem[next]=sem[now]+1;
					q.add(next);
				}
			}
		}
		for(int i=1;i<=N;i++)
		{
			System.out.print(sem[i]+" ");
		}
	}
}
