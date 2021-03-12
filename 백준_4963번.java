import java.util.*;
import java.io.*;
public class ����_4963��{
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
			if(temp_y+1<N&&!visited[temp_x][temp_y+1]&&map[temp_x][temp_y+1]==1)//������ Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y+1);
				visited[temp_x][temp_y+1]=true;
			}
			if(temp_y-1>=0&&!visited[temp_x][temp_y-1]&&map[temp_x][temp_y-1]==1)//���� Ȯ��
			{
				q_x.add(temp_x);
				q_y.add(temp_y-1);
				visited[temp_x][temp_y-1]=true;
			}
			if(temp_x+1<M&&!visited[temp_x+1][temp_y]&&map[temp_x+1][temp_y]==1)//�Ʒ� Ȯ��
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y);
				visited[temp_x+1][temp_y]=true;
			}
			if(temp_x-1>=0&&!visited[temp_x-1][temp_y]&&map[temp_x-1][temp_y]==1)//�� Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y);
				visited[temp_x-1][temp_y]=true;
			}
			if(temp_y-1>=0&&temp_x-1>=0&&!visited[temp_x-1][temp_y-1]&&map[temp_x-1][temp_y-1]==1)//������ Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y-1);
				visited[temp_x-1][temp_y-1]=true;
			}
			if(temp_y-1>=0&&temp_x+1<M&&!visited[temp_x+1][temp_y-1]&&map[temp_x+1][temp_y-1]==1)//���ʾƷ� Ȯ��
			{
				q_x.add(temp_x+1);
				q_y.add(temp_y-1);
				visited[temp_x+1][temp_y-1]=true;
			}
			if(temp_y+1<N&&temp_x-1>=0&&!visited[temp_x-1][temp_y+1]&&map[temp_x-1][temp_y+1]==1)//������ Ȯ��
			{
				q_x.add(temp_x-1);
				q_y.add(temp_y+1);
				visited[temp_x-1][temp_y+1]=true;
			}
			if(temp_y+1<N&&temp_x+1<M&&!visited[temp_x+1][temp_y+1]&&map[temp_x+1][temp_y+1]==1)//�����Ʒ� Ȯ��
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
		     int area=0;//������
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
		    			 area++;//BFS�� ����ɶ����� ������ ����
		    		 }
		    	 }
		     }
		     System.out.println(area);
	}
}
}