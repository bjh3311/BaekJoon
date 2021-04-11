import java.util.*;
import java.io.*;
public class 백준_4803번 {
	public static boolean[] visited;
	public static ArrayList<Integer>[] arr;
	public static int tree;
	public static int BFS(int n)
	{
		visited[n]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(n);
		int node=0;
		int edge=0;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			node+=1;
			for(int i=0;i<arr[temp].size();i++)
			{
				edge+=1;
				if(!visited[arr[temp].get(i)])
				{
					visited[arr[temp].get(i)]=true;
					q.add(arr[temp].get(i));
				}
			}
		}
		return (edge/2)+1==node?1:0;
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=0;
		while(true)
		{
			T++;
			tree=0;//트리의 개수 매 테스트케이스마다 초기화
			HashMap<Integer,Integer> root=new HashMap<Integer,Integer>();//root노드를 찾기위함
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);//노드 개수
			int m=Integer.parseInt(s[1]);//간선 개수
			visited=new boolean[n+1];
			if(n==0&&m==0)
			{
				break;
			}
			arr=new ArrayList[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<m;i++)
			{
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				arr[a].add(b);
				arr[b].add(a);
			}//간선 입력받기
			for(int i=1;i<=n;i++)
			{
				if(!visited[i])//i라는 키는 없다.즉 i는 루트노드이다
				{
					tree+=BFS(i);
				}
			}
			if(tree<=0)
			{
				System.out.println("Case "+T+": No trees.");
			}
			else if(tree==1)
			{
				System.out.println("Case "+T+": There is one tree.");
			}
			else
			{
				System.out.println("Case "+T+": A forest of "+tree+" trees.");
			}//트리의 개수에 따라 다르게 출력
			
		}

	}

}
