import java.util.*;
import java.io.*;
class Node
{
	int y;
	int x;
	Node(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
public class 백준_11559번 {

	public static int result;
	public static boolean isBomb;
	public static String[][] map=new String[12][6];
	public static int[] dy= {-1,0,1,0};
	public static int[] dx= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		for(int i=0;i<12;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<6;j++)
			{
				map[i][j]=s[j];
			}
		}
		result=0;
		while(true)
		{
			isBomb=false;
			for(int i=0;i<12;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(!map[i][j].equals("."))
					{
						BFS(i,j,map[i][j]);
						
					}
				}
			}
			renew();
			if(!isBomb)//연쇄가 안 일어났다면
			{
				System.out.println(result);
				return;
			}
			else
			{
				result++;
			}
		}
	}
	public static void BFS(int y, int x,String color)
	{
		boolean[][] visited=new boolean[12][6];
		Queue<Node> q=new LinkedList<Node>();
		Queue<Node> bomb=new LinkedList<Node>();
		q.add(new Node(y,x));
		bomb.add(new Node(y,x));
		visited[y][x]=true;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=temp.y+dy[i];
				int nx=temp.x+dx[i];
				if(ny>=0&&ny<12&&nx>=0&&nx<6)//맵을 벗어나면 안된다
				{
					if(map[ny][nx].equals(color)&&!visited[ny][nx])
					{
						q.add(new Node(ny,nx));
						bomb.add(new Node(ny,nx));
						visited[ny][nx]=true;
					}//색깔도 같아야 하고 방문된적 없어야 한다.
				}
			}
		}
		if(bomb.size()>=4)//연쇄작용으로 맵을 빈칸으로 만들어준다
		{
			isBomb=true;
			while(!bomb.isEmpty())
			{
				Node temp=bomb.poll();
				map[temp.y][temp.x]=".";
			}
		}
	}
	public static void renew()//폭발이 끝난 후 맵을 갱신해준다.
	{
		for(int j=0;j<6;j++)
		{
			Stack<String> stack=new Stack<String>();
			for(int i=0;i<12;i++)
			{
				if(!map[i][j].equals("."))//. 이 아닌 다른 색깔이라면
				{
					stack.add(map[i][j]);
					map[i][j]=".";
				}
			}
			int index=11;
			while(!stack.isEmpty())
			{
				String temp=stack.pop();
				map[index][j]=temp;
				index--;
			}
		}
	}
}
