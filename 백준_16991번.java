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
public class ����_16991�� {

	public static int N;
	public static double W[][];
	public static double dp[][];//���� �ε����� �湮���
	public static double result=Double.MAX_VALUE;
	public static int AllVisited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		AllVisited=(int)(Math.pow(2,N)-1);//���� N�� 4��� AllVisited�� 15�̴�
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
		for(int i=1;i<=N;i++)//ó���� dp�� ��� �ִ�Ÿ��� ���ش�
		{
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i=1;i<=N;i++)//�� ��ǥ�� ���� �Է�
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
		DFS(1,1);//1���������� �����Ѵ� , 1���� �湮�Ѱɷ� ģ��
		System.out.println(result);
	}
	public static void DFS(int now,int visited)
	{
		if(visited==AllVisited)//���� �� �湮�ߴٸ�
		{
			result=Math.min(result, dp[now][AllVisited]+W[now][1]);
		}
		for(int i=1;i<=N;i++)//i�� ������ �湮�� ����
		{
			int next=(int)Math.pow(2, i-1);
			int temp= next | visited;//���� �湮�� ������ �湮�����ִ��� or������ ���� ���Ѵ�
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
