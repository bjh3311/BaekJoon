import java.util.Scanner;

public class น้มุ_1182น๘ {
	public static int result;
	public static int[] arr=new int[20];
	public static int N;
	public static int S;
	public static void go(int toPick,int sum,int prev)
	{
		if(toPick==0)
		{
			if(sum==S)
			{
				result++;
			}
			return;
		}
			for(int i=prev+1;i<N;++i)
			{		
				go(toPick-1,sum+arr[i],i);
			}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	    N=scan.nextInt();
		S=scan.nextInt();	
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		for(int i=1;i<=N;++i)
		{	
			go(i,0,-1);
		}
		System.out.println(result);
	}
	
}