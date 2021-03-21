import java.io.*;
import java.util.*;
public class 백준_11444번 {

	public static long[][] arr;
	public static long[][] temp;
	public static long[][] init;
	public static void divide(long n)
	{
		if(n==1)//n-1이 1이면 아무것도안함
		{
			
		}
		else if(n==2)
		{
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					temp[i][j]=arr[i][j];
				}
			}
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					arr[i][j]=0;
				}
			}//arr초기화
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					for(int k=0;k<2;k++)
					{
						arr[i][j]+=(temp[i][k]*temp[k][j])%1000000007;
					}
					
				}
			}
     	}
		else if(n%2==0)//n-1이 짝수일때
		{
			divide(n/2);
			divide(2);
		}
		else//n-1이 홀수 일 때;
		{
			divide(n/2);
			divide(2);
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					temp[i][j]=arr[i][j];
				}
			}
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					arr[i][j]=0;
				}
			}//arr초기화
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					for(int k=0;k<2;k++)
					{
						arr[i][j]+=(temp[i][k]*init[k][j])%1000000007;
					}	
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		arr=new long[2][2];
		temp=new long[2][2];
		init=new long[2][2];//기본 행렬
		arr[0][0]=1;
		arr[0][1]=1;
		arr[1][0]=1;
		arr[1][1]=0;
		init[0][0]=1;
		init[0][1]=1;
		init[1][0]=1;
		init[1][1]=0;
		long n=scan.nextLong();
        if(n==1)
		{
			System.out.print(1);
		}
		else if(n==2)
		{
			System.out.print(1);
		}
		else
		{
			divide(n-1);
			System.out.println(arr[0][0]%1000000007);
		}
	}
}
