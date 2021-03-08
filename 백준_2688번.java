import java.util.Scanner;
public class น้มุ_2688น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<T;i++)
		{
			int n=scan.nextInt();
			long[][] dp=new long[n][10];
			for(int j=0;j<=9;j++)
			{
			        dp[0][j]=1;	
			}
			for(int j=1;j<n;j++)
			{
				for(int k=0;k<=9;k++)
				{
					for(int l=k;l>=0;l--)
					{
						dp[j][k]+=dp[j-1][l];
					}
				}
			}
			long sum=0;
			for(int j=0;j<=9;j++)
			{
				sum+=dp[n-1][j];
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb.toString());

	}

}
