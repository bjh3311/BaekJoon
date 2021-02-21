import java.util.Scanner;
public class 백준_10971번 {
	public static int[][] arr;
	public static int N;
	public static int min=100000000;
	public static int[] route;
	public static boolean[] visited;//각 도시를 방문했는지 확인
	public static void TSP(int n)
	{
		if(n==N)
		{
			int sum=0;
			route[N]=route[0];
			for(int i=0;i<N;i++)
			{
				if(arr[route[i]][route[i+1]]==0)
				{
					return;
				}
				sum+=arr[route[i]][route[i+1]];
			}
			if(min>sum)
			{
				min=sum;
				return;
			}
		}
		for(int i=0;i<N;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				route[n]=i;
				TSP(n+1);
				visited[i]=false;
				route[n]=0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		arr=new int[N][N];
		route=new int[N+1];
		visited=new boolean[N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				arr[i][j]=scan.nextInt();
			}
		}
		TSP(0);
		System.out.println(min);

	}

}
