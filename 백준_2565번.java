import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
public class น้มุ_2565น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][2];
		int[] dp=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i][0]=scan.nextInt();
			arr[i][1]=scan.nextInt();
		}
		Arrays.sort(arr,new Comparator<int[]>(){
			public int compare(int[] o1,int[] o2)
			{
				return o1[0]-o2[0];
			}
		});
		dp[0]=1;
		for(int i=1;i<N;i++)
		{
			if(dp[i]==0)
			{
				dp[i]=1;
			}
			for(int j=0;j<i;j++)
			{
				if(arr[i][1]>arr[j][1])
				{
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(N-dp[N-1]);

	}

}
