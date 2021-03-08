import java.util.*;
import java.io.*;
public class 백준_1012번{
	public static int[][] map;
	public static int N;
	public static int M;
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
			if(temp_y+1<M&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]==1)//오른쪽 확인
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
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]==1)//아래 확인
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
		}
	}
	public static void main (String[] agrs)throws IOException
	{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     int T=Integer.parseInt(br.readLine());
	     StringBuilder sb=new StringBuilder();
	     for(int i=0;i<T;i++)
	     {
	    	 String[] s=br.readLine().split(" ");
	    	 M=Integer.parseInt(s[0]);
		     N=Integer.parseInt(s[1]);
		     int K=Integer.parseInt(s[2]);
		     map=new int[N][M];
		     visited=new boolean[N][M];
		     int area=0;//단지수
		     for(int j=0;j<K;j++)
		     {
		    	 s=br.readLine().split(" ");
		    	 map[Integer.parseInt(s[1])][Integer.parseInt(s[0])]=1;
		     }
		     for(int j=0;j<N;j++)
		     {
		    	 for(int k=0;k<M;k++)
		    	 {
		    		 if(map[j][k]==1&&!visited[j][k])
		    		 {
		    			 BFS(j,k);
		    			 area++;//BFS가 실행될때마다 단지수 증가
		    		 }
		    	 }
		     }
		     sb.append(area+"\n");

	     }
	     System.out.println(sb.toString());
	     
	}
}