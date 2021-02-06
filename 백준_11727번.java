import java.util.Scanner;
public class น้มุ_11727น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] dp=new int[N];
		if(N==1)
		{
			System.out.println("1");
		}
		else if(N==2)
		{
			System.out.println("3");
		}
		else
		{
			dp[0]=1;
			dp[1]=3;
			for(int i=2;i<N;i++)
			{
				dp[i]=((dp[i-2]*2)+dp[i-1])%10007;
			}
			System.out.println(dp[N-1]);
		}
	
		

	}

}
