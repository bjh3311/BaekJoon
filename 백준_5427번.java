import java.util.*;
import java.io.*;
public class น้มุ_5427น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int w=Integer.parseInt(s[0]);
			int h=Integer.parseInt(s[1]);
			boolean[][] visited=new boolean[h][w];
			int[][] map=new int[h][w];
			Queue<Integer> sk=new LinkedList<Integer>();
			Queue<Integer> fire=new LinkedList<Integer>();
			for(int i=0;i<h;i++)
			{
				s=br.readLine().split("");
				for(int j=0;j<w;j++)
				{
					if(s[j].equals("#"))
					{
						map[i][j]=1;
					}
					else if(s[j].equals("."))
					{
						map[i][j]=0;
					}
					else if(s[j].equals("*"))
					{
						fire.add(i);
						fire.add(j);
						map[i][j]=1;
					}
					else if(s[j].equals("@"))
					{
						sk.add(i);
						sk.add(j);
						map[i][j]=0;
					}
				}
			}
			int Time=0;
			int index=1;
			loops: while(!sk.isEmpty())
			{
				
				int size=fire.size()/2;
				for(int i=0;i<size;i++)
				{
					int temp_y=fire.poll();
					int temp_x=fire.poll();
					for(int j=0;j<4;j++)
					{
						int y=temp_y+dy[j];
						int x=temp_x+dx[j];
						if(y>=0&&y<h&&x>=0&&x<w)
						{
							if(map[y][x]==0)
							{
								fire.add(y);
								fire.add(x);
								map[y][x]=1;
							}
							
						}
					}
				}
				size=sk.size()/2;
				for(int i=0;i<size;i++)
				{
					int temp_y=sk.poll();
					int temp_x=sk.poll();
					if(temp_y==0||temp_y==h-1||temp_x==0||temp_x==w-1)
					{
						System.out.println(Time+1);
						index=2;
						break loops;
					}
					for(int j=0;j<4;j++)
					{
						int y=temp_y+dy[j];
						int x=temp_x+dx[j];
						if(y>=0&&y<h&&x>=0&&x<w)
						{
							if(map[y][x]==0&&!visited[y][x])
							{
								visited[y][x]=true;
								sk.add(y);
								sk.add(x);
							}
						}
					}
				}
				Time++;
			}
			if(index==1)
			{
				System.out.println("IMPOSSIBLE");
			}
			T--;
		}
	}
}
