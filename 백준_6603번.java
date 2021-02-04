import java.util.Arrays;
import java.util.Scanner;
public class 백준_6603번 {
	public static int[] visited=new int[49];//방문했으면 1 아니면 0
	public static int[] result=new int[6];
    public static StringBuilder sb=new StringBuilder();
	public static void lotto(int S,int M,int count,int[] arr_temp)
	{
		if(count==M)
		{
			for(int i=0;i<M;i++)
			{
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		else if(count==0)
		{
			for(int i=0;i<S;i++)
			{
				if(visited[i]!=1)
				{
					result[count]=arr_temp[i];
					visited[i]=1;
					lotto(S,M,count+1,arr_temp);
					visited[i]=0;
				}
			}
		}
		else
		{
			for(int i=0;i<S;i++)
			{
				if(visited[i]!=1&&arr_temp[i]>result[count-1])
				{
					result[count]=arr_temp[i];
					visited[i]=1;
					lotto(S,M,count+1,arr_temp);
					visited[i]=0;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int S;//선택된 집합의 원수의 수
        Scanner scan=new Scanner(System.in);	    
		// TODO Auto-generated method stub
		while(true)
		{
			S=scan.nextInt();
			if(S==0)
			{
				break;
			}
			else
			{
				int[] arr_temp=new int[S];
				for(int i=0;i<S;i++)
				{
					arr_temp[i]=scan.nextInt();
				}
				lotto(S,6,0,arr_temp);
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		}

	}

}
