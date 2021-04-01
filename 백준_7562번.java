import java.util.*;
import java.io.*;
public class 백준_7562번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			int I=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			boolean[][] visited=new boolean[I][I];
			int[][] result=new int[I][I];
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			s=br.readLine().split(" ");
			int x_goal=Integer.parseInt(s[0]);
			int y_goal=Integer.parseInt(s[1]);
			int[] arr_y= {2,1,-1,-2,-2,-1,1,2};
			int[] arr_x= {1,2,2,1,-1,-2,-2,-1};
			Queue<Integer> q=new LinkedList<Integer>();
			visited[y][x]=true;
			q.add(y);
			q.add(x);
			while(!q.isEmpty())
			{
				int temp_y=q.poll();
				int temp_x=q.poll();
				if(temp_y==y_goal&&temp_x==x_goal)
				{
					break;
				}
				for(int j=0;j<8;j++)
				{
					int ny=temp_y+arr_y[j];
					int nx=temp_x+arr_x[j];
					if(0<=ny&&ny<I&&0<=nx&&nx<I)//맵 안에 있다면
					{
						if(!visited[ny][nx])
						{
							visited[ny][nx]=true;
							result[ny][nx]=result[temp_y][temp_x]+1;
							q.add(ny);
							q.add(nx);
						}
					}
				}	
			}
			sb.append(result[y_goal][x_goal]+"\n");
		}
		System.out.print(sb.toString());
	}

}
