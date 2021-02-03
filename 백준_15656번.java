import java.util.Arrays;
import java.util.Scanner;

public class ����_15656�� {
	public static int[] arr=new int[7];
	public static int[] visited=new int[7];//�湮������ 1, �ƴϸ� 0
	public static StringBuilder sb=new StringBuilder();
	public static void dfs(int N,int M,int count,int[] arr_temp)
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
		          	arr[count]=arr_temp[i];
		           	dfs(N,M,count+1,arr_temp);   
		     }
		 }	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	    int  N=scan.nextInt();
	    int M=scan.nextInt();	
	    int[] arr_temp=new int[N];
	    for(int i=0;i<N;i++)
	    {
	    	arr_temp[i]=scan.nextInt();
	    }
		Arrays.sort(arr_temp);//�Է¹��� �ڿ����� ������������ ����
	    dfs(N,M,0,arr_temp);
	    System.out.println(sb.toString());
	}
	
}