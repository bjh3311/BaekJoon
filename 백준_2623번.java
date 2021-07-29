import java.util.*;
import java.io.*;
public class 백준_2623번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] indegree=new int[N+1];
		int[][] map=new int[N+1][N+1];
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int[] temp=new int[a];
			for(int j=0;j<a;j++)
			{
				temp[j]=Integer.parseInt(s[j+1]);
			}
			for(int j=0;j<a;j++)
			{
				for(int k=j;k<a-1;k++)
				{
					if(map[temp[k]][temp[k+1]]==0)
					{
						arr[temp[k]].add(temp[k+1]);
						map[temp[k]][temp[k+1]]=1;
						indegree[temp[k+1]]++;
					}
						
				}
			}
		}//간선 입력받기
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(indegree[i]==0)
			{
				q.add(i);
			}
		}
		Queue<Integer> result=new LinkedList<Integer>();
		while(!q.isEmpty())
		{
			int temp=q.poll();
			result.add(temp);
			for(int next: arr[temp])
			{
				indegree[next]--;
				if(indegree[next]==0)
				{
					q.add(next);
				}
			}
		}
		if(result.size()==N)//결과값이 잘 나온다면
		{
			while(!result.isEmpty())
			{
				System.out.println(result.poll());
			}
		}
		else
		{
			System.out.println("0");
		}
	}
}