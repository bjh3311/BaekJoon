import java.util.*;
import java.io.*;
public class 백준_10026번{
	public static char[][] map;
	public static int N;
	public static boolean[][] visited;
	public static void R_BFS(int i,int j)
	{
		Queue<Integer> q_x=new LinkedList<Integer>();
		Queue<Integer> q_y=new LinkedList<Integer>();
		visited[i][j]=true;
		q_x.add(i);
		q_y.add(j);
		while(!q_x.isEmpty()&&!q_y.isEmpty())
		{
			int temp_x=q_x.poll();
			int temp_y=q_y.poll();
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]=='R')//오른쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]=='R')//왼쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]=='R')//아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]=='R')//위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//R확인
	public static void G_BFS(int i,int j)
	{
		Queue<Integer> q_x=new LinkedList<Integer>();
		Queue<Integer> q_y=new LinkedList<Integer>();
		visited[i][j]=true;
		q_x.add(i);
		q_y.add(j);
		while(!q_x.isEmpty()&&!q_y.isEmpty())
		{
			int temp_x=q_x.poll();
			int temp_y=q_y.poll();
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]=='G')//오른쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]=='G')//왼쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]=='G')//아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]=='G')//위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//G확인
	public static void B_BFS(int i,int j)
	{
		Queue<Integer> q_x=new LinkedList<Integer>();
		Queue<Integer> q_y=new LinkedList<Integer>();
		visited[i][j]=true;
		q_x.add(i);
		q_y.add(j);
		while(!q_x.isEmpty()&&!q_y.isEmpty())
		{
			int temp_x=q_x.poll();
			int temp_y=q_y.poll();
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]=='B')//오른쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]=='B')//왼쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]=='B')//아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]=='B')//위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//B확인
	public static void RG_BFS(int i,int j)
	{
		Queue<Integer> q_x=new LinkedList<Integer>();
		Queue<Integer> q_y=new LinkedList<Integer>();
		visited[i][j]=true;
		q_x.add(i);
		q_y.add(j);
		while(!q_x.isEmpty()&&!q_y.isEmpty())
		{
			int temp_x=q_x.poll();
			int temp_y=q_y.poll();
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&(map[temp_x][temp_y+1]=='R'||map[temp_x][temp_y+1]=='G'))//오른쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&(map[temp_x][temp_y-1]=='R'||map[temp_x][temp_y-1]=='G'))//왼쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&(map[temp_x+1][temp_y]=='R'||map[temp_x+1][temp_y]=='G'))//아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&(map[temp_x-1][temp_y]=='R'||map[temp_x-1][temp_y]=='G'))//위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//적록색약을 위한 RG확인
	public static void main (String[] agrs)throws IOException
	{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     N=Integer.parseInt(br.readLine());
	     String s;
	     map=new char[N][N];
	     visited=new boolean[N][N];
	     int area=0;//영역 수
	     for(int i=0;i<N;i++)
	     {
	    	 s=br.readLine();
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 map[i][j]=s.charAt(j);
	    	 }
	     }
	     for(int i=0;i<N;i++)
	     {
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 if(map[i][j]=='R'&&!visited[i][j]) 
	    		 {
	    			 R_BFS(i,j);
	    			 area++;
	    		 }
	    		 else if(map[i][j]=='G'&&!visited[i][j])
	    		 {
	    			 G_BFS(i,j);
	    			 area++;
	    		 }
	    		 else if(map[i][j]=='B'&&!visited[i][j])
	    		 {
	    			 B_BFS(i,j);
	    			 area++;
	    		 }
	    	 }
	     }//정상인
	     System.out.print(area+" ");
	     area=0;
	     for(int i=0;i<N;i++)
	     {
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 visited[i][j]=false;
	    	 }
	     }
	     for(int i=0;i<N;i++)
	     {
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 if((map[i][j]=='R'||map[i][j]=='G')&&!visited[i][j]) 
	    		 {
	    			 RG_BFS(i,j);
	    			 area++;
	    		 }
	    		 else if(map[i][j]=='B'&&!visited[i][j])
	    		 {
	    			 B_BFS(i,j);
	    			 area++;
	    		 }
	    	 }
	     }//적록색약
	     System.out.print(area);
	    
	}
}