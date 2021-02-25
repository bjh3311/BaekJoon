import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 백준_14502번 {
	public static int N;
	public static int M;
	public static int[][] maze;//연구소의 원본
	public static int[][] result;//연구소의 복사본
	public static boolean[][] visited;//빈칸이면 true
	public static int max;
	public static void permutation(int count)//벽 3개 세우는 경우의수
	{
		if(count==3)//벽을 3개 다 짓고 BFS실시
		{
			BFS();
			return;
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(visited[i][j])
				{
					visited[i][j]=false;
					maze[i][j]=1;
					permutation(count+1);
					maze[i][j]=0;
					visited[i][j]=true;
				}
			}
		}
	}
	public static void BFS()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				result[i][j]=maze[i][j];
			}
		}//result에 연구소 본판을 복사
		Queue<Integer> qx=new LinkedList<Integer>();
		Queue<Integer> qy=new LinkedList<Integer>();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(result[i][j]==2)//바이러스가 있다면
				{
					qx.add(i);
					qy.add(j);
					while(!qx.isEmpty()&&!qy.isEmpty())
					{
						int temp_x=qx.poll();
						int temp_y=qy.poll();						
						if(temp_x+1>=0&&temp_x+1<N)
						{
							if(result[temp_x+1][temp_y]==0)//방문된적 없고 1이어야함
							{
								qx.add(temp_x+1);
								qy.add(temp_y);
								result[temp_x+1][temp_y]=2;
							}
						}//아래 확인
						if(temp_x-1>=0&&temp_x-1<N)
						{
							if(result[temp_x-1][temp_y]==0)//방문된적 없고 1이어야함
							{
								qx.add(temp_x-1);
								qy.add(temp_y);
								result[temp_x-1][temp_y]=2;
							}
						}//위 확인
						if(temp_y+1<M&&temp_y+1>=0)
						{
							if(result[temp_x][temp_y+1]==0)//방문된적 없고 1이어야함
							{
								qx.add(temp_x);
								qy.add(temp_y+1);
								result[temp_x][temp_y+1]=2;
							}
						}//오른쪽 확인
						if(temp_y-1>=0&&temp_y-1<M)
						{
							if(maze[temp_x][temp_y-1]==0)//방문된적 없고 1이어야함
							{
								qx.add(temp_x);
								qy.add(temp_y-1);
								result[temp_x][temp_y-1]=2;
							}
						}//왼쪽 확인
					}	
				}
			}
		}
		int count=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(result[i][j]==0)
				{
					count++;
				}
			}
		}
		max=Math.max(count, max);
		
	}
	public static void main(String[] agrs)
	{
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		scan.nextLine();//개행문자 제거
		maze=new int[N][M];
		visited=new boolean[N][M];
		result=new int[N][M];
	    String[] s;
		for(int i=0;i<N;i++)
		{
			s=scan.nextLine().split(" ");
			for(int j=0;j<M;j++)
			{
				maze[i][j]=Integer.parseInt(s[j]);
				if(maze[i][j]==0)
				{
					visited[i][j]=true;
				}
			}
		}
		permutation(0);
		System.out.println(max);
	}
}