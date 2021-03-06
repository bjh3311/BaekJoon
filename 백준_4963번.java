import java.util.*;
import java.io.*;
public class 백준_4963번{
	public static int[][] map;
	public static int N;
	public static int M;
	public static boolean[][] visited;
	public static PriorityQueue<Integer> result=new PriorityQueue<Integer>();
	public static void BFS(int i,int j)
	{
		Queue<Integer> q_x=new LinkedList<Integer>();
		Queue<Integer> q_y=new LinkedList<Integer>();
		visited[i][j]=true;
		q_x.add(i);
		q_y.add(j);
		int count=1;
		while(!q_x.isEmpty()&&!q_y.isEmpty())
		{
			int temp_x=q_x.poll();
			int temp_y=q_y.poll();
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]==1)//오른쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]==1)//왼쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<M&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]==1)//아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]==1)//위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
			if(temp_y-1>=0&&temp_x-1>=0&&!visited[temp_x-1][temp_y-1]&&map[temp_x-1][temp_y-1]==1)//왼쪽위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y-1);
				visited[temp_x-1][temp_y-1]=true;
			}
			if(temp_y-1>=0&&temp_x+1<M&&!visited[temp_x+1][temp_y-1]&&map[temp_x+1][temp_y-1]==1)//왼쪽아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y-1);
				visited[temp_x+1][temp_y-1]=true;
			}
			if(temp_y+1<N&&temp_x-1>=0&&!visited[temp_x-1][temp_y+1]&&map[temp_x-1][temp_y+1]==1)//오른위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y+1);
				visited[temp_x-1][temp_y+1]=true;
			}
			if(temp_y+1<N&&temp_x+1<M&&!visited[temp_x+1][temp_y+1]&&map[temp_x+1][temp_y+1]==1)//오른아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y+1);
				visited[temp_x+1][temp_y+1]=true;
			}
		
		}

		
	}
	public static void main (String[] agrs)throws IOException
	{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     while(true)
	     {
	    	 String[] s=br.readLine().split(" ");
	    	 N=Integer.parseInt(s[0]);
	    	 M=Integer.parseInt(s[1]);
	    	 if(N==0&&M==0)
	    	 {
	    		 break;
	    	 }
		     map=new int[M][N];
		     visited=new boolean[M][N];
		     int area=0;//단지수
		     for(int i=0;i<M;i++)
		     {
		    	 s=br.readLine().split(" ");
		    	 for(int j=0;j<N;j++)
		    	 {
		    		 map[i][j]=Integer.parseInt(s[j]);
		    	 }
		     }
		     for(int i=0;i<M;i++)
		     {
		    	 for(int j=0;j<N;j++)
		    	 {
		    		 if(map[i][j]==1&&!visited[i][j])
		    		 {
		    			 BFS(i,j);
		    			 area++;//BFS가 실행될때마다 단지수 증가
		    		 }
		    	 }
		     }
		     System.out.println(area);
	}
}
}