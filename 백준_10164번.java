import java.util.*;
import java.io.*;
public class 백준_10164번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int K=Integer.parseInt(s[2]);
		if(K!=0)
		{
			int count=0;
			int x=0;
			int y=0;//기점이 되는 x,y좌 표
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					count++;
					if(count==K)
					{
						y=i;
						x=j;
					}
				}
			}
			int[][] map=new int[y+1][x+1];
			for(int i=0;i<=y;i++)
			{
				map[i][0]=1;
			}
			for(int i=0;i<=x;i++)
			{
				map[0][i]=1;
			}
			for(int i=1;i<=y;i++)
			{
				for(int j=1;j<=x;j++)
				{
					map[i][j]=map[i-1][j]+map[i][j-1];
				}
			}
			int[][] map_2=new int[N-y][M-x];
			for(int i=0;i<N-y;i++)
			{
				map_2[i][0]=1;
			}
			for(int i=0;i<M-x;i++)
			{
				map_2[0][i]=1;
			}
			for(int i=1;i<N-y;i++)
			{
				for(int j=1;j<M-x;j++)
				{
					map_2[i][j]=map_2[i-1][j]+map_2[i][j-1];
				}
			}
			System.out.println(map[y][x]*map_2[N-y-1][M-x-1]);
			
			
		}
		else
		{
			int[][] map=new int[N][M];
			for(int i=0;i<N;i++)
			{
				map[i][0]=1;
			}
			for(int i=0;i<M;i++)
			{
				map[0][i]=1;
			}
			for(int i=1;i<N;i++)
			{
				for(int j=1;j<M;j++)
				{
					map[i][j]=map[i-1][j]+map[i][j-1];
				}
			}
			System.out.println(map[N-1][M-1]);
		}
	}
}
