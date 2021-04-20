import java.util.*;
import java.io.*;
public class 백준_3055번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int R=Integer.parseInt(s[0]);
		int C=Integer.parseInt(s[1]);
		int[][] map=new int[R][C];
		Queue<Integer> q=new LinkedList<Integer>();
		Queue<Integer> water=new LinkedList<Integer>();
		boolean[][] visited=new boolean[R][C];
		int des_x=0;
		int des_y=0;
		for(int i=0;i<R;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<C;j++)
			{
				if(s[j].equals("."))
				{
					map[i][j]=0;
				}
				else if(s[j].equals("X"))
				{
					map[i][j]=1;
				}
				else if(s[j].equals("*"))
				{
					water.add(i);
					water.add(j);
					map[i][j]=1;
				}
				else if(s[j].equals("S"))
				{
					visited[i][j]=true;
					q.add(i);
					q.add(j);//시작위치부터 BFS를 실시할 것이기 때문에
					map[i][j]=0;
				}
				else
				{
					des_x=j;
					des_y=i;
					map[i][j]=0;
				}
			}
		}
		int[] dx= {0,-1,1,0};
		int[] dy= {-1,0,0,1};
		int time=1;
		while(!q.isEmpty())
		{
			int size=water.size()/2;
			for(int j=0;j<size;j++)
			{
				int temp_y=water.poll();
				int temp_x=water.poll();
				for(int i=0;i<4;i++)
				{
					int ny=temp_y+dy[i];
					int nx=temp_x+dx[i];
					if(ny>=0&&ny<R&&nx>=0&&nx<C)
					{
						if(map[ny][nx]==0&&(ny!=des_y||nx!=des_x))
						{
							water.add(ny);
							water.add(nx);
							map[ny][nx]=5;
						}
					}
				}
			}
			size=q.size()/2;
			for(int j=0;j<size;j++)
			{
				int temp_y=q.poll();
				int temp_x=q.poll();
				for(int i=0;i<4;i++)
				{
					int ny=temp_y+dy[i];
					int nx=temp_x+dx[i];
					if(ny>=0&&ny<R&&nx>=0&&nx<C)
					{
						if(ny==des_y&&nx==des_x)
						{
							System.out.println(time);
							System.exit(0);
						}
						if(map[ny][nx]==0&&!visited[ny][nx])
						{
							q.add(ny);
							q.add(nx);
							visited[ny][nx]=true;
						}
					}
				}
			}
			time++;
		}
		System.out.println("KAKTUS");
	}

}
