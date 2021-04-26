import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int vertex;
	int weight;
	public Node(int vertex,int weight)
	{
		this.vertex=vertex;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}
}//우선순위큐에 가중치가 가장 낮은게 큰 우선순위를 갖도록 구현
public class 백준_11779번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[] before=new int[n+1];//되추적을 위한 배열
		boolean[] visited=new boolean[n+1];//방문했는지 알아보는 배열
		int[] dis=new int[n+1];//거리 배열
		Arrays.fill(dis, Integer.MAX_VALUE);//거리는 일단 가장 큰값으로 초기화 시켜둔다.
		ArrayList<Node>[] map=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			map[i]=new ArrayList<Node>();
		}
		String[] s;
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a].add(new Node(b,c));
		}
		s=br.readLine().split(" ");
		int start=Integer.parseInt(s[0]);
		int end=Integer.parseInt(s[1]);
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(start,0));
		dis[start]=0;
		int count=1;//몇개인지 세기 위함이다
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<map[v].size();i++)
				{
					int next=map[v].get(i).vertex;
					if(!visited[next]&&dis[next]>dis[v]+map[v].get(i).weight)
					{
						dis[next]=dis[v]+map[v].get(i).weight;
						q.add(new Node(next,dis[next]));
						before[next]=v;
					}
						
				}
			}
			visited[v]=true;//마지막은 방문 처리
			
		}
		System.out.println(dis[end]);
		Stack<Integer> result=new Stack<Integer>();
		int index=end;//end에서 시작해서 되추적 시작
		while(true)
		{
			result.push(index);
			if(index==start)//시작점에 도착했으면
			{
				break;
			}
			index=before[index];//되추적 실시
			count++;//방문한 갯수 증가
		}
		System.out.println(count);//몇개인지 출력
		while(!result.isEmpty())
		{
			System.out.print(result.pop()+" ");
		}
	}
}
