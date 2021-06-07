import java.util.*;
import java.io.*;
public class 백준_1719번 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] map=new int[N+1][N+1];
		int[][] route=new int[N+1][N+1];//경로
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(i!=j)
				{
					map[i][j]=10000000;
				}
			}
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a][b]=c;
			map[b][a]=c;
			route[a][b]=b;
			route[b][a]=a;
		}
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				for(int k=1;k<=N;k++)
				{
					if(map[j][k]>map[j][i]+map[i][k])
					{
						map[j][k]=map[j][i]+map[i][k];
						route[j][k]=route[j][i];
					}
				}
			}
		}
		for(int i=1;i<=N;i++)//경로 출력
		{
			for(int j=1;j<=N;j++)
			{
				if(i==j)
				{
					System.out.print("- ");
				}
				else
				{
					System.out.print(route[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
