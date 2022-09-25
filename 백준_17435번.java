import java.util.*;
import java.io.*;

public class 백준_17435번 {

	public static int[][] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		parent=new int[20][m+1];
		String[] s=br.readLine().split(" ");
		for(int i=1;i<=m;i++)
		{
			parent[0][i]=Integer.parseInt(s[i-1]);
		}
		
		for(int i=1;i<=19;i++)
		{
			for(int j=1;j<=m;j++)
			{
				parent[i][j]=parent[i-1][parent[i-1][j]];//parent[1][i]는 i의 첫번째 위 조상, parent[2][i]는 두번째 조상
				//parent[3][i]는 4번째 조상 parent[4][i]는 8번째 조상
			}
		}
		int Q=Integer.parseInt(br.readLine());
		for(int i=0;i<Q;i++)
		{
			s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int x=Integer.parseInt(s[1]);
			System.out.println(Query(n,x));
		}
	}
	public static int Query(int n,int x)//x의 n번째 조상을 찾아달라는 쿼리
	{	
		for(int b=0;b<19;b++)
		{
			if((n&(1<<b))>0)
			{
				x=parent[b][x];
			}
		}
		return x;
	}
	
}