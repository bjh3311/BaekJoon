import java.util.*;
import java.io.*;
public class 백준_7569번 {
	public static int N;
	public static int M;
	public static int H;
	public static int[][][] arr;
	public static int[][][] day;
	public static boolean[][][] visited;
	public static Queue<Integer> q=new LinkedList<Integer>();
	public static void BFS()
	{
		while(!q.isEmpty())
		{
			int temp_y=q.poll();
			int temp_x=q.poll();
		    int temp_z=q.poll();
			if(temp_x+1<M&&!visited[temp_y][temp_x+1][temp_z]&&arr[temp_y][temp_x+1][temp_z]==0)
			{
				q.add(temp_y);
				q.add(temp_x+1);
				q.add(temp_z);
				visited[temp_y][temp_x+1][temp_z]=true;
				day[temp_y][temp_x+1][temp_z]=day[temp_y][temp_x][temp_z]+1;
				arr[temp_y][temp_x+1][temp_z]=1;
			}
			if(temp_x-1>=0&&!visited[temp_y][temp_x-1][temp_z]&&arr[temp_y][temp_x-1][temp_z]==0)
			{
				q.add(temp_y);
				q.add(temp_x-1);
				q.add(temp_z);
				visited[temp_y][temp_x-1][temp_z]=true;
				day[temp_y][temp_x-1][temp_z]=day[temp_y][temp_x][temp_z]+1;
				arr[temp_y][temp_x-1][temp_z]=1;
			}
			if(temp_y+1<N&&!visited[temp_y+1][temp_x][temp_z]&&arr[temp_y+1][temp_x][temp_z]==0)
			{
				q.add(temp_y+1);
				q.add(temp_x);
				q.add(temp_z);
				visited[temp_y+1][temp_x][temp_z]=true;
				day[temp_y+1][temp_x][temp_z]=day[temp_y][temp_x][temp_z]+1;
				arr[temp_y+1][temp_x][temp_z]=1;
			}
			if(temp_y-1>=0&&!visited[temp_y-1][temp_x][temp_z]&&arr[temp_y-1][temp_x][temp_z]==0)
			{
				q.add(temp_y-1);
				q.add(temp_x);
				q.add(temp_z);
				visited[temp_y-1][temp_x][temp_z]=true;
				day[temp_y-1][temp_x][temp_z]=day[temp_y][temp_x][temp_z]+1;
				arr[temp_y-1][temp_x][temp_z]=1;
			}
			if(temp_z-1>=0&&!visited[temp_y][temp_x][temp_z-1]&&arr[temp_y][temp_x][temp_z-1]==0)
			{
				q.add(temp_y);
				q.add(temp_x);
				q.add(temp_z-1);
				visited[temp_y][temp_x][temp_z-1]=true;
				day[temp_y][temp_x][temp_z-1]=day[temp_y][temp_x][temp_z]+1;
				arr[temp_y][temp_x][temp_z-1]=1;
			}
			if(temp_z+1<H&&!visited[temp_y][temp_x][temp_z+1]&&arr[temp_y][temp_x][temp_z+1]==0)
			{
				q.add(temp_y);
				q.add(temp_x);
				q.add(temp_z+1);
				visited[temp_y][temp_x][temp_z+1]=true;
				day[temp_y][temp_x][temp_z+1]=day[temp_y][temp_x][temp_z]+1;
				arr[temp_y][temp_x][temp_z+1]=1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		M=Integer.parseInt(s[0]);
		N=Integer.parseInt(s[1]);
		H=Integer.parseInt(s[2]);
		arr=new int[N][M][H];
		day=new int[N][M][H];
		visited=new boolean[N][M][H];
		for(int k=0;k<H;k++)
		{
			for(int i=0;i<N;i++)
			{
				s=br.readLine().split(" ");
				for(int j=0;j<M;j++)
				{
					arr[i][j][k]=Integer.parseInt(s[j]);
				}
			}
		}
		for(int k=0;k<H;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(arr[i][j][k]==1)
					{
						q.offer(i);
						q.offer(j);
						q.offer(k);
					}
				}
			}
		}
		BFS();
		int max=0;
		for(int k=0;k<H;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{	
					max=Math.max(max, day[i][j][k]);
				}
				
			}//날짜중 최대값 찾기
		}
		
		for(int k=0;k<H;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(arr[i][j][k]==0)
					{
						System.out.println(-1);
						System.exit(0);
					}
				
				}
			}//안익은 토마토가 있다면 -1출력하고 프로그램 종료
		}
		System.out.println(max);
	}
}
