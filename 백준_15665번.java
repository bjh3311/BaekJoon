import java.util.Arrays;
import java.util.Scanner;

public class 백준_15665번 {
	public static int[] arr=new int[7];
	public static int[] visited=new int[7];//방문했으면 1, 아니면 0
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
		int before=-1;//중복 방지를 위한 변수 선언
		
			for(int i=0;i<N;i++)
			{		
		       	if(visited[i]!=1&&(i==0||before!=arr_temp[i]))
		       	   	{		    		   
		       		    before=arr_temp[i];
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
		Arrays.sort(arr_temp);//입력받은 자연수를 오름차순으로 정렬
	    dfs(N,M,0,arr_temp);	
	    System.out.println(sb.toString());
	}
	
}