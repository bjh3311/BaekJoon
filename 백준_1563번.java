import java.util.*;

public class 백준_1563번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][][] dp=new int[N][2][3];//2번쨰 인덱스는 지각을했는지안했는지,3번째인덱스는 연속결석수
		if(N==1)
		{
			System.out.println("3");
			System.exit(0);
		}
		dp[1][0][0]=2;//출출,결출
		dp[1][0][1]=1;//출결
		dp[1][0][2]=1;//결결
		dp[1][1][0]=3;
		dp[1][1][1]=1;
		dp[1][1][2]=0;
		for(int i=2;i<N;i++)
		{
			dp[i][0][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%1000000;
			dp[i][0][1]=dp[i-1][0][0];
			dp[i][0][2]=dp[i-1][0][1];
			dp[i][1][0]=(dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2]+dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%1000000;
			dp[i][1][1]=dp[i-1][1][0];
			dp[i][1][2]=dp[i-1][1][1];
		}
		long sum=0;
		for(int i=0;i<3;i++)
		{
			sum+=dp[N-1][0][i];
			sum+=dp[N-1][1][i];
		}
		System.out.println(sum%1000000);
		

	}

}
