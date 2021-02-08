import java.util.Scanner;
public class 백준_1780번 {
	public static int minus_one=0;
	public static int zero=0;
	public static int one=0;
	public static boolean minus_count(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 1인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]!=-1)
				{
					return false;//0이 있으면 false 반환
				}
			}
		}
		return true;//for문을 문제없이 다 실행하면 true반환
	}
	public static boolean zero_count(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 0인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]!=0)
				{
					return false;//1이 있으면 false반환
				}
			}
		}
		return true;//for문을 문제없이 다 실행하면 true반환
	}
	public static boolean one_count(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 0인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]!=1)
				{
					return false;//1이 있으면 false반환
				}
			}
		}
		return true;//for문을 문제없이 다 실행하면 true반환
	}
	public static void quad(int[][] arr,int i,int j,int N)
	{  
		if(N==1)
		{
			if(one_count(arr,i,j,N))
			{
				one++;
			}
			else if(zero_count(arr,i,j,N))
			{
				zero++;
			}
			else
			{
				minus_one++;
			}
		}
		else
		{
			if(one_count(arr,i,j,N))
			{
				one++;
			}
			else if(zero_count(arr,i,j,N))
			{
				zero++;
			}
			else if(minus_count(arr,i,j,N))
			{
				minus_one++;
			}
			else
			{
				quad(arr,i,j,N/3);
				quad(arr,i,j+N/3,N/3);
				quad(arr,i,j+(2*N)/3,N/3);
				quad(arr,i+N/3,j,N/3);
				quad(arr,i+N/3,j+N/3,N/3);
				quad(arr,i+N/3,j+(2*N)/3,N/3);
				quad(arr,i+(2*N)/3,j,N/3);
				quad(arr,i+(2*N)/3,j+N/3,N/3);
				quad(arr,i+(2*N)/3,j+(2*N)/3,N/3);
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][N];
		scan.nextLine();//개행 제거
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				arr[i][j]=scan.nextInt();
			}
		}
		quad(arr,0,0,N);
		System.out.println(minus_one);
		System.out.println(zero);
		System.out.println(one);
		// TODO Auto-generated method stub
	}
}