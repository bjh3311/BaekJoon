import java.util.*;
import java.io.*;
public class น้มุ_16562น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int k=Integer.parseInt(s[2]);
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;
		}
		int[] cost=new int[N+1];
		s=br.readLine().split(" ");
		for(int i=1;i<=N;i++)
		{
			cost[i]=Integer.parseInt(s[i-1]);
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			
		}

	}
	public static int[] parent;
	public static int Find(int x)
	{
		
	}
	public static void Union(int x,int y)
	{
		
	}

}
