import java.util.*;
import java.io.*;
public class ����_10026��{
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
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]=='R')//������ Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]=='R')//���� Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]=='R')//�Ʒ� Ȯ��
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]=='R')//�� Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//RȮ��
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
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]=='G')//������ Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]=='G')//���� Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]=='G')//�Ʒ� Ȯ��
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]=='G')//�� Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//GȮ��
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
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]=='B')//������ Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]=='B')//���� Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]=='B')//�Ʒ� Ȯ��
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]=='B')//�� Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//BȮ��
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
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&(map[temp_x][temp_y+1]=='R'||map[temp_x][temp_y+1]=='G'))//������ Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&(map[temp_x][temp_y-1]=='R'||map[temp_x][temp_y-1]=='G'))//���� Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<N&&!visited[temp_x+1][temp_y]&&(map[temp_x+1][temp_y]=='R'||map[temp_x+1][temp_y]=='G'))//�Ʒ� Ȯ��
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&(map[temp_x-1][temp_y]=='R'||map[temp_x-1][temp_y]=='G'))//�� Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
		}		
	}//���ϻ����� ���� RGȮ��
	public static void main (String[] agrs)throws IOException
	{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     N=Integer.parseInt(br.readLine());
	     String s;
	     map=new char[N][N];
	     visited=new boolean[N][N];
	     int area=0;//���� ��
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
	     }//������
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
	     }//���ϻ���
	     System.out.print(area);
	    
	}
}