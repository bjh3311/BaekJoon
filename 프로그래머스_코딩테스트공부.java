import java.util.*;
import java.io.*;


public class 프로그래머스_코딩테스트공부 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] problems= {{10,15,2,1,2},{20,20,3,3,4}};
		System.out.println(solution(10,10,problems));

	}
	public static int solution(int alp, int cop, int[][] problems) 
	{
        int answer = Integer.MAX_VALUE;
        int[][] dp=new int[151][151];//al,co
        for(int i=0;i<=150;i++)
        {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop]=0;//초기화
        int al_max=0;
        int co_max=0;
        for(int[] temp : problems)
        {
        	al_max=Math.max(al_max, temp[0]);
        	co_max=Math.max(co_max, temp[1]);
        }//필요한 알고리즘력과 코딩력을 구한다
        for(int i=alp;i<=150;i++)
        {
        	for(int j=cop;j<=150;j++)
        	{
        		if(j+1<=150)
        		{
        			dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);
        		}
        		if(i+1<=150)
        		{
        			dp[i+1][j]=Math.min(dp[i+1][j], dp[i][j]+1);
        		}
        		for(int k=0;k<problems.length;k++)
        		{
        			if(i>=problems[k][0]&&j>=problems[k][1])//요구하는 코딩력을 만족하면
        			{
        				int al_index=i+problems[k][2];
        				int co_index=j+problems[k][3];
        				if(al_index>150)
        				{
        					al_index=150;
        				}
        				if(co_index>150)
        				{
        					co_index=150;
        				}
        				dp[al_index][co_index]=Math.min(dp[al_index][co_index], dp[i][j]+problems[k][4]);
        			}
        		}
        	}
        }   
        for(int i=al_max;i<=150;i++)
        {
        	for(int j=co_max;j<=150;j++)
        	{
        		answer=Math.min(answer, dp[i][j]);
        	}
        }
        return answer;
    }

}
