import java.util.*;
import java.io.*;
public class 카카오2022_2번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		System.out.println(solution(n,k));
	}
	public static int solution(int n,int k)
	{
		int answer=0;
		String num=convert(n,k);
		System.out.println(num);
		prime[0]=true;
		prime[1]=true;//0과 1은 소수가 아니다.
		era();
		int start=0;
		int end=0;
		for(int i=0;i<num.length();i++)
		{
			if(num.charAt(i)=='0')
			{
				end=i;
				if(start<end)
				{
					int temp=Integer.parseInt(num.substring(start,end));
					if(!prime[temp])
					{
						answer++;
					}
				}	
				start=i+1;
			}
		}
		end=num.length();
		if(start<end)
		{
			int temp=Integer.parseInt(num.substring(start,end));
			if(!prime[temp])
			{
				answer++;
			}
		}
		return answer;
	}
	public static boolean prime[] =new boolean[100000001];//false면 소수이다.
	public static String convert(int n,int k)//진법 변환기
	{
		StringBuilder sb = new StringBuilder();
	    int current = n;
        while(current > 0){
            sb.append(current % k);
            current /= k;
        }
        sb=sb.reverse();
        return sb.toString();
	}
	public static void era()//에라토스테네스의 체
	{
		for(int i=2;i*i<=100000001;i++)
		{
			if(!prime[i])
			{
				for(int j=i*i;j<=10000001;j+=i)
				{
					prime[j]=true;
				}
			}
			
		}
	}

}
