import java.util.Scanner;
public class 백준_1992번 {
	public static boolean blue(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 1인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==0)
				{
					return false;//0이 있으면 false 반환
				}
			}
		}
		return true;//for문을 문제없이 다 실행하면 true반환
	}
	public static boolean white(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 0인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==1)
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
			if(blue(arr,i,j,N))
			{
				System.out.print(1);
			}
			else if(white(arr,i,j,N))
			{
				System.out.print(0);
			}
		}
		else
		{
			if(blue(arr,i,j,N))
			{
				System.out.print(1);
			}
			else if(white(arr,i,j,N))
			{
				System.out.print(0);
			}
			else
			{
				System.out.print("(");
				quad(arr,i,j,N/2);//제 2사분면
				quad(arr,i,j+N/2,N/2);//제 1사분면
				quad(arr,i+N/2,j,N/2);//제 3사분면
				quad(arr,i+N/2,j+N/2,N/2);//제 4사분면
				System.out.print(")");
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][N];
		scan.nextLine();//개행 제거
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=scan.nextLine().split("");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.valueOf(s[j]);
			}
		}
		quad(arr,0,0,N);
		// TODO Auto-generated method stub
	}

}