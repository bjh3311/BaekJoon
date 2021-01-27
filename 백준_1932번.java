package ����_1932��;
import java.util.Scanner;
public class ����_1932�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scan=new Scanner(System.in);
      int n=scan.nextInt();
      int[][] arr=new int[n][n];
      for(int i=0;i<n;i++)
      {
    	  for(int j=0;j<=i;j++)
    	  {
    		  arr[i][j]=scan.nextInt();
    	  }
      }
      int[][] dp=new int[n][n];
      dp[0][0]=arr[0][0];
      dp[1][0]=arr[1][0]+dp[0][0];
      dp[1][1]=arr[1][1]+dp[0][0];
      for(int i=2;i<n;i++)
      {
    	  for(int j=0;j<=i;j++)
    	  {
    		  if(j==0)//�ﰢ������ ���� ���ʿ��������
    		  {
    			  dp[i][j]=arr[i][j]+dp[i-1][0];
    		  }
    		  else if(j==i)//�ﰢ������ ���� �����ʿ� �������
    		  {
    			  dp[i][j]=arr[i][j]+dp[i-1][i-1];
    		  }
    		  else
    		  {
    			  dp[i][j]=arr[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j] );
    		  }
    	  }
      }
      int max=dp[n-1][0];
      for(int i=1;i<n;i++)
      {
    	  if(dp[n-1][i]>max)
    	  {
    		  max=dp[n-1][i];
    	  }
      }//�� �� �ﰢ������ �ִ밪 ã��
      System.out.println(max);
	}

}
