import java.util.*;
import java.io.*;
public class น้มุ_1956น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int V=Integer.parseInt(s[0]);
		int E=Integer.parseInt(s[1]);
		int[][] map=new int[V][V];
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				map[i][j]=100000000;
			}
		}
		for(int i=0;i<E;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a-1][b-1]=c;
		}
		for(int k=0;k<V;k++)
		{
			for(int i=0;i<V;i++)
			{
				for(int j=0;j<V;j++)
				{
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		int result=Integer.MAX_VALUE;
		for(int i=0;i<V;i++)
		{
			result=Math.min(result,map[i][i]);
		}
		if(result>=100000000)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(result);
		}
	}

}
