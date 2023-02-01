import java.util.*;
import java.io.*;

public class 백준_17070번 {

	public static int[][] map;
	public static int result;
	public static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		result=0;
		//0이 가로,1이 세로,2가 대각선
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		DFS(0,1,0);
		System.out.println(result);
	}
	public static void DFS(int y,int x,int stat)
	{
		if(y==N-1&&x==N-1)//목적지에 도착했다면
		{
			result++;
			return;
		}
		switch(stat)//0이 가로,1이 세로,2가 대각
		{
			case 0:	
				if(x+1<N&&map[y][x+1]==0)
				{
					DFS(y,x+1,0);
				}
				break;
			case 1:
				if(y+1<N&&map[y+1][x]==0)
				{
					DFS(y+1,x,1);
				}
				break;
			case 2:
				if(x+1<N&&map[y][x+1]==0)
				{
					DFS(y,x+1,0);
				}
				if(y+1<N&&map[y+1][x]==0)
				{
					DFS(y+1,x,1);
				}
				break;		
		}
		if(y+1<N&&x+1<N&&map[y][x+1]==0&&map[y+1][x+1]==0&&map[y+1][x]==0)
		{
			DFS(y+1,x+1,2);
		}
	}

}
