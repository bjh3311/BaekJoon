import java.util.*;
import java.io.*;


public class น้มุ_1976น๘ {

	public static int[] parent;
	public static int[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		String[] s;
		arr=new int[N][N];
		parent=new int[N];
		for(int i=0;i<N;i++)
		{
			parent[i]=i;
		}
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i][j]==1)
				{
					Union(i,j);
				}
			}
		}
		s=br.readLine().split(" ");
		int temp=parent[Integer.parseInt(s[0])-1];
		for(int i=1;i<M;i++)
		{
			int index=Integer.parseInt(s[i])-1;
			if(temp!=parent[index])
			{
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	public static void Union(int a,int b)
	{
		int a_parent=FindParent(a);
		int b_parent=FindParent(b);
		if(a_parent<b_parent)
		{
			parent[b_parent]=a_parent;
		}
		else
		{
			parent[a_parent]=b_parent;
		}
		
	}
	public static int FindParent(int a)
	{
		if(parent[a]==a)
		{
			return a;
		}
		else
		{	
			return parent[a]=FindParent(parent[a]);
		}
		
	}

}
