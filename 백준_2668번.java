import java.util.*;
public class 백준_2668번 {
    //사이클을 구성하는 정점의 수와 정점들을 출력하는 묻는문제이다.
	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static int start;
	public static Queue<Integer> q=new LinkedList<Integer>();
	public static boolean[] real_visited;
	public static PriorityQueue<Integer> result=new PriorityQueue<Integer>();//결과값 오름차순 출력위함
	public static int count=0;
	public static void dfs(int n)
	{
		visited[n]=true;
		q.add(n);
		if(!visited[arr[n]]&&!real_visited[arr[n]])
		{
			dfs(arr[n]);
		}
		if(arr[n]==start)
		{
			while(!q.isEmpty())
			{
				count++;
			    int temp=q.poll();
			    real_visited[temp]=true;
			    result.add(temp);
			}
			return;
		}
		visited[n]=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		arr=new int[N+1];
		visited=new boolean[N+1];
		real_visited=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=scan.nextInt();
		}
		for(int i=1;i<=N;i++)
		{
			if(!real_visited[i])
			{
				start=i;
				dfs(i);
				q.clear();
			}
		}
		System.out.println(count);
		while(!result.isEmpty())
		{
			System.out.println(result.poll());
		}
	   

	}

}
