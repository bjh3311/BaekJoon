package ����_1149��;
import java.util.Scanner;
public class ����_1149�� {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scan=new Scanner(System.in);
       int N=scan.nextInt();
       int[][] arr=new int[N][3];
       int[][] dp=new int[N][3];//dynamic programming�� ���� �迭
       for(int i=0;i<N;i++)
       {
    	   arr[i][0]=scan.nextInt();
    	   arr[i][1]=scan.nextInt();
    	   arr[i][2]=scan.nextInt();
       }
       dp[0][0]=arr[0][0];
       dp[0][1]=arr[0][1];
       dp[0][2]=arr[0][2];
       for(int i=1;i<N;i++)
       {
    	   dp[i][0]=arr[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
    	   dp[i][1]=arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
    	   dp[i][2]=arr[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
       }
       int min=dp[N-1][0];
       if(min>dp[N-1][1])
       {
    	   min=dp[N-1][1];
       }
       if(min>dp[N-1][2])
       {
    	   min=dp[N-1][2];
       }
       System.out.println(min);
	}

}
