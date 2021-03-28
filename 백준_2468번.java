import java.util.*;
import java.io.*;
public class 백준_2468번{
	public static int[][] map;
	public static int N;
	public static boolean[][] visited;
	public static void BFS(int i,int j)
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
			if(temp_y+1<N&&!visited[temp_x][temp_y+1])//오른쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1])//왼쪽 확인
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y])//아래 확인
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y])//위 확인
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}
	}
	public static void main (String[] agrs)throws IOException
	{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     N=Integer.parseInt(br.readLine());
	     String[] s;
	     map=new int[N][N];
	     int area=0;//단지수
	     for(int i=0;i<N;i++)
	     {
	    	 s=br.readLine().split(" ");
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 map[i][j]=Integer.parseInt(s[j]);
	    	 }
	     }
	     int result=0;
	     for(int k=1;k<=100;k++)
	     {
	    	 area=0;
	    	 visited=new boolean[N][N];//매번 초기화
	    	 for(int i=0;i<N;i++)
	    	 {
	    		 for(int j=0;j<N;j++)
	    		 {
	    			 if(map[i][j]<=k)
	    			 {
	    				 visited[i][j]=true;
	    			 }
	    		 }
	    	 }
	    	 for(int i=0;i<N;i++)
		     {
		    	 for(int j=0;j<N;j++)
		    	 {
		    		 if(!visited[i][j])
		    		 {
		    			 BFS(i,j);
		    			 area++;//BFS가 실행될때마다 단지수 증가
		    		 }
		    	 }
		     }
	    	 result=Math.max(area,result);
	     }
	     if(result==0)
	     {
	    	 System.out.println("1");
	     }
	     else
	     {
	    	 System.out.println(result);
	     }
	    
	}
}