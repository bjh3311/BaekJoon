import java.util.*;
import java.io.*;

public class ����_17435�� {

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
				parent[i][j]=parent[i-1][parent[i-1][j]];//parent[1][i]�� i�� ù��° �� ����, parent[2][i]�� �ι�° ����
				//parent[3][i]�� 4��° ���� parent[4][i]�� 8��° ����
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
	public static int Query(int n,int x)//x�� n��° ������ ã�ƴ޶�� ����
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