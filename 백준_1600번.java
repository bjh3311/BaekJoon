import java.util.*;
import java.io.*;
class Mon
{
	int y;
	int x;
	int count;
	int length;
	public Mon(int y,int x,int count,int length)
	{
		this.y=y;
		this.x=x;
		this.count=count;
		this.length=length;
	}
}
public class น้มุ_1600น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int W=Integer.parseInt(s[0]);
		int H=Integer.parseInt(s[1]);
		Queue<Mon> q=new LinkedList<>();
		boolean[][][] visited=new boolean[H][W][K+1];
		int[][] map=new int[H][W];
		for(int i=0;i<H;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<W;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		int[] dy= {-1,0,1,0,0,0,0,0};
		int[] dx= {0,1,0,-1,0,0,0,0};
		int[] h_dy= {2,2,1,1,-1,-1,-2,-2};
		int[] h_dx= {1,-1,2,-2,2,-2,1,-1};
		for(int i=0;i<=K;i++)
		{
			visited[0][0][i]=true;
		}
		q.add(new Mon(0,0,0,0));
		while(!q.isEmpty())
		{
			Mon temp=q.poll();
			int y=temp.y;
			int x=temp.x;
			int count=temp.count;
			int length=temp.length;
			if(y==H-1&&x==W-1)
			{
				System.out.println(length);
				System.exit(0);
			}
			for(int i=0;i<4;i++)
			{
				int ny=y+dy[i];
				int nx=x+dx[i];	
				if(ny>=0&&ny<H&&nx>=0&&nx<W)
				{
					if(!visited[ny][nx][count]&&map[ny][nx]==0)
					{
						visited[ny][nx][count]=true;
						q.add(new Mon(ny,nx,count,length+1));
					}
				}
			}
			if(count+1>K)
			{
				continue;
			}
			for(int i=0;i<8;i++)
			{
				int ny=y+h_dy[i];
				int nx=x+h_dx[i];
				if(ny>=0&&ny<H&&nx>=0&&nx<W)
				{
					if(!visited[ny][nx][count+1]&&map[ny][nx]==0)
					{
						visited[ny][nx][count+1]=true;
						q.add(new Mon(ny,nx,count+1,length+1));
					}
				}
			}
			
		}
		System.out.println("-1");
	}
}
