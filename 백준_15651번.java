import java.util.Scanner;
public class น้มุ_15651น๘ {
	public static int[] arr=new int[7];
	public static int[] visited=new int[7];
	public static StringBuilder sb=new StringBuilder();
	public static void dfs(int N,int M,int count) 
	{
			if(count==M)
			{
				for(int i=0;i<M;i++)
				{
					sb.append(arr[i]+" ");
				}
				sb.append("\n");	
				return;
			}
			for(int i=0;i<N;i++)
			{
				if(visited[i]!=1)
				{	
					arr[count]=i+1;
					dfs(N,M,count+1);
				}	
		    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	    int  N=scan.nextInt();
		int M=scan.nextInt();	
		dfs(N,M,0);	
		System.out.println(sb.toString());
	}
	
}