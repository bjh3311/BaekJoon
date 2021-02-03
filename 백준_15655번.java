import java.util.Arrays;
import java.util.Scanner;

public class 백준_15655번 {
	public static int[] arr=new int[8];
	public static int[] visited=new int[8];//방문했으면 1, 아니면 0
	public static void dfs(int N,int M,int count,int[] arr_temp)
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
		else if(count==0)
		{
			for(int i=0;i<N;i++)
			{		
		       	if(visited[i]!=1)
		       	   	{		           
		            	arr[count]=arr_temp[i];
			          	visited[i]=1;
			           	dfs(N,M,count+1,arr_temp);
			            visited[i]=0;				
		        }
		    }	
		}
		else
		{
			for(int i=0;i<N;i++)
			{		
		       	if(visited[i]!=1)
		       	{   	
		            if(arr_temp[i]>arr[count-1])
		            {
		            	arr[count]=arr_temp[i];
			          	visited[i]=1;
			           	dfs(N,M,count+1,arr_temp);
			            visited[i]=0;
		            }
		       					
		        }
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
		Arrays.sort(arr_temp);//입력받은 자연수를 오름차순으로 정렬
	    dfs(N,M,0,arr_temp);	
	}
	
}