import java.util.Scanner;

public class ����_15649�� {
	public static int[] arr=new int[8];
	public static int[] visited=new int[8];
	public static void dfs(int N,int M,int count)
	{
		if(count==M)
		{
			for(int i=0;i<M;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++)
		{
			if(visited[i]!=1)
			{	
				arr[count]=i+1;//count�� ���°�� ������ ���ڶ�� ��
				visited[i]=1;
				dfs(N,M,count+1);
				visited[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	    int  N=scan.nextInt();
		int M=scan.nextInt();	
		dfs(N,M,0);
		
		
			
		
	}
	
}