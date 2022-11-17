import java.util.*;

class Node implements Comparable<Node>
{
	int v;
	int w;
	Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		if(w==o.w)
		{
			return v-o.v;
		}
		else
		{
			return w-o.w;
		}
	}
}
public class 프로그래머스_등산코스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int[][] paths= {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
		int[] gates= {1,3};
		int[] summits= {5};
		int[] temp=solution(n,paths,gates,summits);
		for(int result: temp) 
		{
			System.out.print(result+" ");
		}
	}
	public static ArrayList<Node>[] arr;
	public static boolean[] visited;
	public static int[] inten;
	public static PriorityQueue<Node> q;
 	public static int[] solution(int n,int[][] paths,int[] gates,int[] summits)
	{
		
		arr=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<paths.length;i++)
		{
			
			int start=paths[i][0];
			int end=paths[i][1];
			int weight=paths[i][2];
			arr[start].add(new Node(end,weight));
			arr[end].add(new Node(start,weight));
		}
		inten=new int[n+1];
		PriorityQueue<Node> result=new PriorityQueue<Node>();
		q=new PriorityQueue<Node>();
		visited=new boolean[n+1];
		for(int temp : gates)
		{
			visited[temp]=true;
		}
		for(int temp : summits)
		{
			visited[temp]=true;
		}
		Arrays.fill(inten, Integer.MAX_VALUE);
		for(int temp: gates)
		{
			q.add(new Node(temp,0));
			inten[temp]=0;
		}
		dijkstra();//다익스트라
		for(int end: summits)
		{
			result.add(new Node(end,inten[end]));
		}
		Node temp=result.poll();
		int summit_result=temp.v;
		int intensity_result=temp.w;
		int[] answer= {summit_result,intensity_result};
		return answer;
	}
	public static void dijkstra()
	{	
 		while(!q.isEmpty())
 		{
 			Node temp=q.poll();
 			if(inten[temp.v]<temp.w)
 			{
 				continue;
 			}
 			for(Node next : arr[temp.v])
 			{
 				if(inten[next.v]>Math.max(next.w,inten[temp.v]))
 				{
 					inten[next.v]=Math.max(next.w, inten[temp.v]);
 					if(!visited[next.v])//산봉우리나 출발점이라면 가지 않는다.
 					{
 						q.add(new Node(next.v,inten[next.v]));
 					}
	
 				}
 			}
 		}
 	}
 	
}
