import java.util.Scanner;
public class 백준_2630번 {
	public static int blue_count=0;
	public static int white_count=0;
	public static int blue(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 파란색인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==0)
				{
					return 0;//하얀색이 있으면 0 반환
				}
			}
		}
		return 1;//for문을 문제없이 다 실행하면 1반환
	}
	public static int white(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 하얀색인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==1)
				{
					return 0;//파란색이 있으면 0반환
				}
			}
		}
		return 1;//for문을 문제없이 다 실행하면 1반환
	}
	public static void quad(int[][] arr,int i,int j,int N)
	{  
		if(N==1)
		{
			blue_count+=blue(arr,i,j,N);
			white_count+=white(arr,i,j,N);
		}
		else
		{
			if(blue(arr,i,j,N)==1)
			{
				blue_count+=blue(arr,i,j,N);
			}
			else if(white(arr,i,j,N)==1)
			{
				white_count+=white(arr,i,j,N);
			}
			else
			{
				quad(arr,i+N/2,j,N/2);//제 1사분면
				quad(arr,i,j,N/2);//제 2사분면
				quad(arr,i,j+N/2,N/2);//제 3사분면
				quad(arr,i+N/2,j+N/2,N/2);//제 4사분면
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				arr[i][j]=scan.nextInt();
			}
		}
		quad(arr,0,0,N);
		System.out.println(white_count);
		System.out.println(blue_count);
		// TODO Auto-generated method stub
	}

}
