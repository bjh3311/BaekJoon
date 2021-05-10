import java.util.*;
import java.io.*;
class Node{
	int y;
	int x;
	int count;
	int crash;
	Node(int y,int x,int count,int crash)
	{
		this.x=x;
		this.y=y;
		this.count=count;
		this.crash=crash;
	}
}
	public class 백준_14442번 {

		public static int[][] map;
		public static boolean[][][] visited;
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			int K=Integer.parseInt(s[2]);
			map=new int[N][M];
			visited=new boolean[N][M][K+1];
			for(int i=0;i<N;i++)
			{
				s=br.readLine().split("");
				for(int j=0;j<M;j++)
				{
					map[i][j]=Integer.parseInt(s[j]);
				}
			}//맵 입력
			Queue<Node> q=new LinkedList<Node>();//벽 부수기전의 큐
			q.add(new Node(0,0,1,0));//마지막이 부쉈는지 확인
			for(int i=0;i<=K;i++)
			{
				visited[0][0][i]=true;
			}
			int[] nx= {0,1,0,-1};
			int[] ny= {1,0,-1,0};
			int ans=Integer.MAX_VALUE;
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				int temp_y=temp.y;//x좌표
				int temp_x=temp.x;//y좌표
				int temp_count=temp.count;
				int temp_crash=temp.crash;
				if(temp_x==M-1&&temp_y==N-1)
				{
					ans=temp.count;
					break;
				}//도착점 도착시 break
				for(int i=0;i<4;i++)
				{
					int y=temp_y+ny[i];
					int x=temp_x+nx[i];
					if(0<=y&&y<N&&0<=x&&x<M)//맵안에 있을경우
					{
						if(temp_crash<K)//벽을 부순횟수가 K보다 작다면
						{
							if(map[y][x]==1)//벽이 있다면
							{
								if(!visited[y][x][temp_crash+1])
								{
									visited[y][x][temp_crash+1]=true;
									q.add(new Node(y,x,temp_count+1,temp_crash+1));
								}
								
							}
							else//벽이 없다면
							{
								if(!visited[y][x][temp_crash])
								{
									visited[y][x][temp_crash]=true;
									q.add(new Node(y,x,temp_count+1,temp_crash));
								}
								
							}
						}
						else//벽을 최대로 부쉈다면
						{
							if(map[y][x]==0)
							{
								if(!visited[y][x][temp_crash])
								{
									visited[y][x][temp_crash]=true;
									q.add(new Node(y,x,temp_count+1,temp_crash));
								}
							}
						}
					}					
				}
			}//벽을 안부순 케이스 검사
			if(ans==Integer.MAX_VALUE)//도착점에 못도착함
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(ans);//정답 출력
			}	
		}
	}