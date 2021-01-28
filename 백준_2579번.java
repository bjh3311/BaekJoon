package 백준_2579번;
import java.util.Scanner;
public class 백준_2579번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Scanner scan=new Scanner(System.in);
          int N=scan.nextInt();
          int[] arr=new int[N];
          for(int i=0;i<N;i++)
          {
        	  arr[i]=scan.nextInt();
          }
          int[] dp=new int[N];//dp에는 계속 최대값 입력
          dp[0]=arr[0];
          if(N==1)
          {
        	  System.out.println(arr[0]);
          }
          else if(N==2)
          {
        	  System.out.println(arr[0]+arr[1]);
          }
          else
          {
        	  dp[1]=arr[1]+dp[0];
              dp[2]=arr[2]+Math.max(arr[0],arr[1]);
              for(int i=3;i<N;i++)
              {
            	  dp[i]=arr[i]+Math.max(dp[i-2],dp[i-3]+arr[i-1] );
              }
              System.out.println(dp[N-1]);
          }
          
          
	}

}
