import java.util.*;
import java.io.*;
class Node
{
	int y;
	int x;
	int dir;//진행방향이 위아래면 1, 왼쪽오른쪽이면 -1
	Node(int y,int x,int dir)
	{
		this.y=y;
		this.x=x;
		this.dir=dir;
	}
}
public class 카카오_경주로건설 {

	public static int N;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,1,-1};
	public static int[][][] cost;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[][] board=new int[N][N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(s[j]);
			}
		}
		System.out.println(solution(board));	
	}
	public static int solution(int[][] board) {
	N=board.length;
	    	cost=new int[N][N][2];//3번째 인덱스는 0 수평으로 들어왔을때, 1이면 수직으로 들어왔을때
	    	Queue<Node> q=new LinkedList<Node>();
	        int answer = Integer.MAX_VALUE;
	        q.add(new Node(0,0,0));
	        for(int i=0;i<N;i++)
	        {
	        	for(int j=0;j<N;j++)
	        	{
	        		cost[i][j][0]=10000000;
	        		cost[i][j][1]=10000000;
	        	}
	        }
	        cost[0][0][0]=0;
	        cost[0][0][1]=0;
	        while(!q.isEmpty())
	        {
	        	Node temp=q.poll();
	        	for(int i=0;i<2;i++)//x만 움직임
	        	{
	        		int ny=temp.y+dy[i];
	        		int nx=temp.x+dx[i];   		
	        		if(ny>=0&&ny<N&&nx>=0&&nx<N)//맵안에 있다면
	        		{
	        			if(board[ny][nx]==0)
	        			{
	        				if(temp.dir==1)
	        				{
	        					if(cost[ny][nx][0]>=cost[temp.y][temp.x][1]+600)
	        					{
	        						cost[ny][nx][0]=cost[temp.y][temp.x][1]+600;
	        						q.add(new Node(ny,nx,-1));
	        					}
	        				}
	        				else if(temp.dir==-1)
	        				{
	        					if(cost[ny][nx][0]>=cost[temp.y][temp.x][0]+100)
	        					{
	        						
	        						cost[ny][nx][0]=cost[temp.y][temp.x][0]+100;
	        						q.add(new Node(ny,nx,-1));
	        					}
	        				}
	        				else
	        				{
	        					if(cost[ny][nx][0]>=cost[temp.y][temp.x][0]+100)
	        					{
	        						cost[ny][nx][0]=cost[temp.y][temp.x][0]+100;
	        						q.add(new Node(ny,nx,-1));
	        					}
	        				}
	        			}
	        		}
	        	}
	        	for(int i=2;i<4;i++)//y만 움직임
	        	{
	        		int ny=temp.y+dy[i];
	        		int nx=temp.x+dx[i];		
	        		if(ny>=0&&ny<N&&nx>=0&&nx<N)//맵안에 있다면
	        		{
	        			if(board[ny][nx]==0)
	        			{
	        				if(temp.dir==1)
	        				{
	        					if(cost[ny][nx][1]>=cost[temp.y][temp.x][1]+100)
	        					{
	        						cost[ny][nx][1]=cost[temp.y][temp.x][1]+100;
	        						q.add(new Node(ny,nx,1));
	        					}
	        				}
	        				else if(temp.dir==-1)
	        				{
	        					if(cost[ny][nx][1]>=cost[temp.y][temp.x][0]+600)
	        					{
	        						cost[ny][nx][1]=cost[temp.y][temp.x][0]+600;
	        						q.add(new Node(ny,nx,1));
	        					}
	        				}
	        				else
	        				{
	        					if(cost[ny][nx][1]>=cost[temp.y][temp.x][1]+100)
	        					{
	        						cost[ny][nx][1]=cost[temp.y][temp.x][1]+100;
	        						q.add(new Node(ny,nx,1));
	        					}
	        				}
	        					
	        			}
	        		}
	        	}
	        }
	        answer=Math.min(cost[N-1][N-1][0], cost[N-1][N-1][1]);
	        return answer;
	    }
}