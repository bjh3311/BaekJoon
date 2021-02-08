import java.util.Scanner;
public class ����_2630�� {
	public static int blue_count=0;
	public static int white_count=0;
	public static int blue(int[][] arr,int i,int j,int N)//�־��� �簢���� ���� �Ķ������� Ȯ��
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==0)
				{
					return 0;//�Ͼ���� ������ 0 ��ȯ
				}
			}
		}
		return 1;//for���� �������� �� �����ϸ� 1��ȯ
	}
	public static int white(int[][] arr,int i,int j,int N)//�־��� �簢���� ���� �Ͼ������ Ȯ��
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==1)
				{
					return 0;//�Ķ����� ������ 0��ȯ
				}
			}
		}
		return 1;//for���� �������� �� �����ϸ� 1��ȯ
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
				quad(arr,i+N/2,j,N/2);//�� 1��и�
				quad(arr,i,j,N/2);//�� 2��и�
				quad(arr,i,j+N/2,N/2);//�� 3��и�
				quad(arr,i+N/2,j+N/2,N/2);//�� 4��и�
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
