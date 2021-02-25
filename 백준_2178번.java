import java.util.*;
public class 백준_2178번 {
	public static int N;
	public static int M;
	public static int[][] maze;//미로
	public static int[][] result;
	public static boolean[][] visited;
	public static void BFS()
	{
		Queue<Integer> qx=new LinkedList<Integer>();
		Queue<Integer> qy=new LinkedList<Integer>();
		qx.add(0);
		qy.add(0);
		result[0][0]=1;
		visited[0][0]=true;
		while(!qx.isEmpty()&&!qy.isEmpty())
		{
			int temp_x=qx.poll();
			int temp_y=qy.poll();
			if(temp_x==N-1&&temp_y==M-1)
			{
				System.out.println(result[temp_x][temp_y]);
				System.exit(0);
			}
			if(temp_x+1>=0&&temp_x+1<N)
			{
				if(!visited[temp_x+1][temp_y]&&maze[temp_x+1][temp_y]==1)//방문된적 없고 1이어야함
				{
					qx.add(temp_x+1);
					qy.add(temp_y);
					visited[temp_x+1][temp_y]=true;
					result[temp_x+1][temp_y]=result[temp_x][temp_y]+1;
				}
			}//아래 확인
			if(temp_x-1>=0&&temp_x-1<N)
			{
				if(!visited[temp_x-1][temp_y]&&maze[temp_x-1][temp_y]==1)//방문된적 없고 1이어야함
				{
					qx.add(temp_x-1);
					qy.add(temp_y);
					visited[temp_x-1][temp_y]=true;
					result[temp_x-1][temp_y]=result[temp_x][temp_y]+1;
				}
			}//위 확인
			if(temp_y+1<M&&temp_y+1>=0)
			{
				if(!visited[temp_x][temp_y+1]&&maze[temp_x][temp_y+1]==1)//방문된적 없고 1이어야함
				{
					qx.add(temp_x);
					qy.add(temp_y+1);
					visited[temp_x][temp_y+1]=true;
					result[temp_x][temp_y+1]=result[temp_x][temp_y]+1;
				}
			}//오른쪽 확인
			if(temp_y-1>=0&&temp_y-1<M)
			{
				if(!visited[temp_x][temp_y-1]&&maze[temp_x][temp_y-1]==1)//방문된적 없고 1이어야함
				{
					qx.add(temp_x);
					qy.add(temp_y-1);
					visited[temp_x][temp_y-1]=true;
					result[temp_x][temp_y-1]=result[temp_x][temp_y]+1;
				}
			}//왼쪽 확인
		}	
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
			s=scan.nextLine().split("");
			for(int j=0;j<M;j++)
			{
				maze[i][j]=Integer.parseInt(s[j]);
			}
		}
		BFS();
	}

}
