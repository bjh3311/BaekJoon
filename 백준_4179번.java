import java.util.*;
import java.io.*;
public class 백준_4179번 {

	public static String[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int R=Integer.parseInt(s[0]);
		int C=Integer.parseInt(s[1]);
		map=new String[R][C];
		Queue<Integer> fire_loc=new LinkedList<Integer>();//불의 위치
		Queue<Integer> jihun=new LinkedList<Integer>();
		boolean[][] visited=new boolean[R][C];
		for(int i=0;i<R;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<C;j++)
			{
				map[i][j]=s[j];
				if(s[j].equals("F"))
				{
					fire_loc.add(i);
					fire_loc.add(j);//불의 위치를 fire_loc큐에 넣어준다
				}
				if(s[j].equals("J"))
				{
					jihun.add(i);
					jihun.add(j);
					visited[i][j]=true;
				}//지훈이 위치 저장
			}
		}
		int[] nx= {0,1,0,-1};
		int[] ny= {1,0,-1,0};
		int ans=0;
		while(!jihun.isEmpty())
		{
			int size=fire_loc.size()/2;
			for(int i=0;i<size;i++)
			{
				int temp_y=fire_loc.poll();
				int temp_x=fire_loc.poll();
				for(int j=0;j<4;j++)
				{
					int y=temp_y+ny[j];
					int x=temp_x+nx[j];
					if(0<=y&&y<R&&0<=x&&x<C)//맵안에 있다면
					{
						if(!map[y][x].equals("F")&&!map[y][x].equals("#"))//벽이 아니고 불이아니라면
						{
							fire_loc.add(y);
							fire_loc.add(x);
							map[y][x]="F";
						}
					}
				}
			}
			int jihun_size=jihun.size()/2;
			for(int i=0;i<jihun_size;i++)
			{
				int temp_y=jihun.poll();
				int temp_x=jihun.poll();
				if(temp_y==0||temp_y==R-1||temp_x==0||temp_x==C-1)
				{
					System.out.println(ans+1);
					System.exit(0);//시스템종료
				}
				for(int j=0;j<4;j++)
				{
					int y=temp_y+ny[j];
					int x=temp_x+nx[j];
					if(0<=y&&y<R&&0<=x&&x<C)//맵안에 있다면
					{
						if(!map[y][x].equals("#")&&!map[y][x].equals("F")&&!visited[y][x])//벽이 불이아니면
						{
							jihun.add(y);
							jihun.add(x);
							visited[y][x]=true;
						}
					}
				}
			}
			ans++;
		}
		System.out.println("IMPOSSIBLE");
	}
}
