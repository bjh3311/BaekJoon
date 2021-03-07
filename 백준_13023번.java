import java.util.*;
import java.io.*;
public class ����_13023�� {

	public static boolean[] visited;
	public static ArrayList<Integer>[] graph;
	public static void dfs(int count,int start)
	{
		if(count==4)
		{
			System.out.println("1");
			System.exit(0);
		}
		for(int i=0;i<graph[start].size();i++)
		{
			visited[start]=true;
			if(!visited[graph[start].get(i)])
			{
				dfs(count+1,graph[start].get(i));
			}
			visited[start]=false;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		graph=new ArrayList[N];
		visited=new boolean[N];
		for(int i=0;i<N;i++)
		{
			graph[i]=new ArrayList<Integer>();
		}//ArrayList�� ���� ��������Ʈ ����
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			graph[a].add(b);
			graph[b].add(a);
		}//ģ�� ���� �Է�
		for(int i=0;i<N;i++)
		{
			dfs(0,i);
		}
		System.out.println("0");//���α׷��� ������� �ʾҴٸ� 0�� ���

	}

}
