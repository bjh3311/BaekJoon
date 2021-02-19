package ����_2580��;
import java.util.Scanner;
public class ����_2580�� {

	public static int[][] sdoku=new int[9][9];
	public static boolean[][] garo=new boolean[9][10];//boolean�� �⺻���� false
	public static boolean[][] sero=new boolean[9][10];//���° �����ٿ��� ������� 7�� true���� false���� ��Ÿ��
	public static boolean[][] square=new boolean[9][10];
	public static void fill(int count)
	{
		if(count==81)
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					System.out.print(sdoku[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int i=count/9;
		int j=count%9;
		if(sdoku[i][j]==0)//����ִٸ�
		{
			int k=3*(i/3)+(j/3);
			for(int n=1;n<=9;n++)
			{
				if(!garo[i][n]&&!sero[j][n]&&!square[k][n])
				{
					sdoku[i][j]=n;
					garo[i][n]=true;
					sero[j][n]=true;
					square[k][n]=true;
					fill(count+1);
					sdoku[i][j]=0;
					garo[i][n]=false;
					sero[j][n]=false;
					square[k][n]=false;
				}
			}
		}
		else
		{
			fill(count+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				sdoku[i][j]=scan.nextInt();
				int k=3*(i/3)+(j/3);
				if(sdoku[i][j]!=0)
				{				
					garo[i][sdoku[i][j]]=true;
					sero[j][sdoku[i][j]]=true;
					square[k][sdoku[i][j]]=true;
				}
			}
		}			
		fill(0);
	}

}
