import java.util.*;
import java.io.*;
class Node
{
	int x;
	int y;
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
public class 백준_16991번 {

	public static int N;
	public static double W[][];
	public static double dp[][];//뒤의 인덱스는 방문기록
	public static double result=Double.MAX_VALUE;
	public static int AllVisited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		AllVisited=(int)(Math.pow(2,N)-1);//만약 N이 4라면 AllVisited는 15이다
		W=new double[N+1][N+1];
		dp=new double[N+1][AllVisited+1];
		Node[] arr=new Node[N+1];
		String[] s;
		for(int i=1;i<=N;i++)
		{
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			arr[i]=new Node(x,y);
		}
		for(int i=1;i<=N;i++)//처음에 dp는 모두 최대거리로 해준다
		{
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i=1;i<=N;i++)//각 좌표간 간선 입력
		{
			for(int j=i+1;j<=N;j++)
			{
				double temp=((arr[i].x-arr[j].x)*(arr[i].x-arr[j].x))+((arr[i].y-arr[j].y)*(arr[i].y-arr[j].y));
				double weight=Math.sqrt(temp);
				W[i][j]=weight;
				W[j][i]=weight;
			}
		}
		dp[1][1]=0;
		DFS(1,1);//1번에서부터 시작한다 , 1번은 방문한걸로 친다
		System.out.println(result);
	}
	public static void DFS(int now,int visited)
	{
		if(visited==AllVisited)//만약 다 방문했다면
		{
			result=Math.min(result, dp[now][AllVisited]+W[now][1]);
		}
		for(int i=1;i<=N;i++)//i가 다음에 방문할 지점
		{
			int next=(int)Math.pow(2, i-1);
			int temp= next | visited;//다음 방문할 지점이 방문된적있는지 or연산을 통해 구한다
			if(temp==visited)
			{
				continue;
			}
			int nextVisited=temp;
			if(dp[i][nextVisited]>dp[now][visited]+W[now][i])
			{
				dp[i][nextVisited]=dp[now][visited]+W[now][i];
				DFS(i,nextVisited);
			}
			
		}
	}

}
