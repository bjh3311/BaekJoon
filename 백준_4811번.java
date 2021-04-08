import java.util.*;
public class น้มุ_4811น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long[] dp=new long[31];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=30;i++)
		{
			long cnt=0;
			for(int j=0;j<i;j++)
			{
				cnt+=dp[i-1-j]*dp[j];
			}
			dp[i]=cnt;
		}
		while(true)
		{
			int N=sc.nextInt();
			if(N==0)
			{
				break;
			}
			System.out.println(dp[N]);

		}

	}

}
