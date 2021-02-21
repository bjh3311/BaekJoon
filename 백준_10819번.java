import java.util.Scanner;
public class 백준_10819번 {
	public static int[] arr;
	public static int[] arr_temp;
	public static boolean[] visited;//방문된적없으면 false 있으면 true
	public static int N;
	public static int max=0;
	public static void backtrack(int n)
	{
		if(n==N)
		{
			int sum=0;
			for(int i=0;i<N-1;i++)
			{
				sum+=Math.abs(arr_temp[i]-arr_temp[i+1]);
			}
			if(max<sum)
			{
				max=sum;
			}
			return;
		}
		for(int i=0;i<N;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				arr_temp[n]=arr[i];
				backtrack(n+1);
				visited[i]=false;
				arr_temp[n]=0;
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		arr=new int[N];
		arr_temp=new int[N];
		visited=new boolean[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		backtrack(0);
		System.out.println(max);
		
		

	}

}
