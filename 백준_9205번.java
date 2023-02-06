import java.util.*;
import java.io.*;
class Node
{
	int x;
	int y;
	Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}   
public class 백준_9205번 {

	public static int dx,dy;//destination
	public static int sx,sy;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			int N=Integer.parseInt(br.readLine());
			Queue<Node> q=new LinkedList<Node>();
			String[] s;
			s=br.readLine().split(" ");
			sx=Integer.parseInt(s[0]);
			sy=Integer.parseInt(s[1]);
			List<Node> list=new LinkedList<Node>();
			for(int i=0;i<N;i++)
			{
				s=br.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				int y=Integer.parseInt(s[1]);
				list.add(new Node(x,y));
			}
			s=br.readLine().split(" ");
			dx=Integer.parseInt(s[0]);
			dy=Integer.parseInt(s[1]);
			System.out.println(BFS(list)?"happy":"sad");
			T--;
		}
	}
	public static boolean BFS(List<Node> list)
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(sx,sy));
		boolean[] visited=new boolean[list.size()];
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(Math.abs(temp.x-dx)+Math.abs(temp.y-dy)<=1000)
			{
				return true;
			}
			for(int i=0;i<list.size();i++)
			{
				if(!visited[i])
				{
					if(Math.abs(temp.x-list.get(i).x)+Math.abs(temp.y-list.get(i).y)<=1000)
					{
						visited[i]=true;
						q.add(new Node(list.get(i).x,list.get(i).y));
					}
				}
			}
		}
		return false;
	}
}
