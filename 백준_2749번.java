import java.util.*;
public class 백준_2749번 {
	public static long arr[][]=new long[2][2];
	public static long temp[][]=new long[2][2];
	public static long init[][]=new long[2][2];

	public static void divide(long n)
	{
		if(n==1)//n은 1이면 아무것도안함
		{
			
		}
		else if(n==2)//n은 2일시 주어진 arr를 제곱
		{
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					temp[i][j]=arr[i][j];
				}//temp에 arr를 복사
			}
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					arr[i][j]=0;
				}
			}				
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					for(int k=0;k<2;k++)
					{
						arr[i][j]+=(temp[i][k]*temp[k][j])%1000000;
					}
				}
			}
		}
		else if(n%2==0)
		{
			divide(n/2);
			divide(2);
		}
		else
		{
			divide(n/2);
			divide(2);
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					temp[i][j]=arr[i][j];
				}//temp에 arr를 복사
			}
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					arr[i][j]=0;
				}
			}
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
					for(int k=0;k<2;k++)
					{
						arr[i][j]+=(temp[i][k]*init[k][j])%1000000;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		long n=scan.nextLong();
		arr[0][0]=1;
		arr[0][1]=1;
		arr[1][0]=1;
		arr[1][1]=0;
		init[0][0]=1;
		init[0][1]=1;
		init[1][0]=1;
		init[1][1]=0;
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
			System.out.println(arr[0][0]%1000000);
		}

	}

}
