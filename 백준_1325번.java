import java.util.*;
import java.io.*;
public class 백준_1325번 {

	public static ArrayList<Integer>[] trust=(ArrayList<Integer>[]) new ArrayList[10001];
	public static int N;
	public static int M;
	public static boolean[] visited=new boolean[10001];
	public static int[] result=new int[10001];
	public static void DFS(int start)
	{
		visited[start]=true;
		for(int vv:trust[start])
		{
			if(!visited[vv])
			{
			   result[vv]++;
			   DFS(vv);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++)
		{
			trust[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			trust[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		for(int i=1;i<=N;i++)
		{
			visited=new boolean[10001];
			DFS(i);	
		}
		int max=0;
		for(int i=1;i<=N;i++)
		{
			if(max<result[i])
			{
				max=result[i];
			}
		}//최대값 찾기
		for(int i=1;i<=N;i++)
		{
			if(max==result[i])
			{
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString());
	}

}
