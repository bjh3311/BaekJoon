import java.util.Scanner;
public class ����_1992�� {
	public static boolean blue(int[][] arr,int i,int j,int N)//�־��� �簢���� ���� 1���� Ȯ��
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==0)
				{
					return false;//0�� ������ false ��ȯ
				}
			}
		}
		return true;//for���� �������� �� �����ϸ� true��ȯ
	}
	public static boolean white(int[][] arr,int i,int j,int N)//�־��� �簢���� ���� 0���� Ȯ��
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==1)
				{
					return false;//1�� ������ false��ȯ
				}
			}
		}
		return true;//for���� �������� �� �����ϸ� true��ȯ
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
				quad(arr,i,j,N/2);//�� 2��и�
				quad(arr,i,j+N/2,N/2);//�� 1��и�
				quad(arr,i+N/2,j,N/2);//�� 3��и�
				quad(arr,i+N/2,j+N/2,N/2);//�� 4��и�
				System.out.print(")");
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][N];
		scan.nextLine();//���� ����
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