import java.util.Arrays;
import java.util.Scanner;
public class ����_14225�� {
	public static int[] result=new int[2000001];
	public static int[] visited=new int[21];//�湮�ߴ��� Ȯ���ϱ� ���� �迭
	public static int[] arr=new int[21];
	public static int temp=0;
	public static void rec(int[] S,int N,int count,int M)
	{
		if(count==M)
		{
		}
		else if(count==0)
		{
			for(int i=0;i<N;i++)
			{
				if(visited[i]==0)
				{
					visited[i]=1;
					temp+=S[i];
					result[temp]=1;
					arr[count]=i;
					rec(S,N,count+1,M);
					visited[i]=0;
					temp=0;
				}
			}
		}
		else
		{
			for(int i=0;i<N;i++)
			{
				if(visited[i]==0)
				{
					if(i>arr[count-1])
					{
				    	visited[i]=1;
				    	temp+=S[i];
				    	arr[count]=i;
				    	result[temp]=1;
					    rec(S,N,count+1,M);
				    	visited[i]=0;
				    	temp=temp-S[i];
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] S=new int[N];//���� S	
		for(int i=0;i<N;i++)
		{
			S[i]=scan.nextInt();
		}//���� S�Է�
		for(int i=1;i<=N;i++)
		{
			rec(S,N,0,i);
		}
		result[0]=1;
		for(int i=0;i<2000001;i++)
		{
			if(result[i]==0)
			{
				System.out.println(i);
				break;
				
			}
		}
	}
}