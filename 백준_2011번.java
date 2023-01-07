import java.util.*;
import java.io.*;

public class 백준_2011번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split("");
		long[] dp=new long[s.length];
		if(s.length==0||s[0].equals("0"))//시작부터 0이면 종료시킨다
		{
			System.out.println("0");
			return;
		}
		dp[0]=1;
		if(s.length==1)
		{
			System.out.println("1");
			return;
		}
		if(s[1].equals("0"))//2번째 숫자가 0인데 첫번째숫자가 1또는 2가 아니라면 잘못된 암호이다.
		{
			if(!s[0].equals("1")&&!s[0].equals("2"))
			{
				System.out.println("0");
				return;
			}
			dp[1]=1;
		}
		else
		{
			String temp=s[0]+s[1];
			if(Integer.parseInt(temp)>0&&Integer.parseInt(temp)<27)
			{
				dp[1]=2;
			}
			else
			{
				dp[1]=1;
			}
		}
		for(int i=2;i<s.length;i++)
		{
			if(s[i].equals("0"))//해당 인덱스의 숫자가 0이라면
			{
				if(!s[i-1].equals("1")&&!s[i-1].equals("2"))
				{
					System.out.println("0");
					return;
				}
				dp[i]=dp[i-2]%1000000;
			}
			else
			{
				if(s[i-1].equals("0"))//앞글자가 0이면
				{
					dp[i]=dp[i-1]%1000000;
				}
				else
				{
					String temp=s[i-1]+s[i];
					if(Integer.parseInt(temp)>0&&Integer.parseInt(temp)<27)
					{
						dp[i]=dp[i-2]+dp[i-1];
						dp[i]=dp[i]%1000000;
						
					}
					else
					{
						dp[i]=dp[i-1]%1000000;
					}
				}
			}
		}
		System.out.println(dp[s.length-1]%1000000);

	}

}
