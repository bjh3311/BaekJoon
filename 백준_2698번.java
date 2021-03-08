import java.util.*;
public class น้มุ_2698น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<T;i++)
		{
			int[][][] dp=new int[101][101][2];
			dp[1][0][0]=1;
			dp[1][0][1]=1;
			for(int j=2;j<=100;j++)
			{
				for(int l=0;l<=100;l++)
				{
					if(l==0)
					{
						dp[j][l][1]=dp[j-1][l][0];
					}
					else
					{
						dp[j][l][1]=dp[j-1][l-1][1]+dp[j-1][l][0];
					}
					dp[j][l][0]=dp[j-1][l][1]+dp[j-1][l][0];
				}
			}

			int n=scan.nextInt();
			int k=scan.nextInt();
			sb.append(dp[n][k][0]+dp[n][k][1]+"\n");
		}
		System.out.print(sb.toString());

	}

}
