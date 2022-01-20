import java.util.*;
import java.io.*;

public class DAY4_최대공약수하나빼기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int[] arr=new int[N];
		int[] LR=new int[N];//왼쪽에서 오른쪽
		int[] RL=new int[N];//오른쪽에서 왼쪽
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		LR[0]=arr[0];
		RL[N-1]=arr[N-1];//초기값 세팅
		for(int i=1;i<N;i++)
		{
			LR[i]=gcd(LR[i-1],arr[i]);
		}
		for(int i=N-2;i>=0;i--)
		{
			RL[i]=gcd(RL[i+1],arr[i]);
		}
		int max=0;
		int maxIndex=0;
		for(int i=0;i<N;i++)
		{
			int gcd=0;
			if(i==0)
			{
				gcd=RL[1];
			}
			else if(i==N-1)
			{
				gcd=LR[N-2];
			}
			else
			{
				gcd=gcd(LR[i-1],RL[i+1]);
			}
			if(arr[i]%gcd!=0&&gcd>max)
			{
				max=gcd;
				maxIndex=i;
			}
		}
		if(max==0)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(max+" "+arr[maxIndex]);
		}
		
		
	}
	//gcd(a,b)==gcd(b,a%b), stop when a%b==0
	public static int gcd(int a,int b)//유클리드 호제법
	{
		while(b!=0)
		{
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
}
