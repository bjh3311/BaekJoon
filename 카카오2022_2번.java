import java.util.*;
import java.io.*;
public class īī��2022_2�� {

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
		prime[1]=true;//0�� 1�� �Ҽ��� �ƴϴ�.
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
	public static boolean prime[] =new boolean[100000001];//false�� �Ҽ��̴�.
	public static String convert(int n,int k)//���� ��ȯ��
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
	public static void era()//�����佺�׳׽��� ü
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
