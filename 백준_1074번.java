import java.util.Scanner;
public class ����_1074�� {
	public static int count=0;
	public static StringBuilder sb=new StringBuilder();
	public static void Z(int N,int r,int c,int i,int j)//i,j�� ���� ��
	{
		if(N==1)
		{
			if(r<i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("2 ");
				
			}//�� 2��и�
			else if(r>=i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("1 ");
				
			}//1��и�
			else if(r<i+two_pow(N)/2&&c>=j+two_pow(N)/2)
			{
				sb.append("3 ");
				
			}//�� 3��и�
			else
			{
				sb.append("4 ");
			}//�� 4�и�
		}
		else
		{
			if(r<i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("2 ");
				Z(N-1,r,c,i,j);
			}//�� 2��и�
			else if(r>=i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("1 ");
				Z(N-1,r,c,i+two_pow(N)/2,j);
			}//1��и�
			else if(r<i+two_pow(N)/2&&c>=j+two_pow(N)/2)
			{
				sb.append("3 ");
				Z(N-1,r,c,i,j+two_pow(N)/2);
			}//�� 3��и�
			else
			{
				sb.append("4 ");
				Z(N-1,r,c,i+two_pow(N)/2,j+two_pow(N)/2);
			}//�� 4�и�
		}
		
	}
	public static int two_pow(int a)//2�� ��� ���ϴ� �Լ�
	{
		int temp=1;
		for(int i=0;i<a;i++)
		{
			temp=temp*2;
		}
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int r=scan.nextInt();
		int c=scan.nextInt();
		Z(N,c,r,0,0);
		String[] s=sb.toString().split(" ");
		int sum=0;
		int init=two_pow(N)*two_pow(N);
		for(int i=0;i<N;i++)
		{
			if(Integer.parseInt(s[i])==2)
			{
				sum+=0;
			}//2��и��ϰ��
			else if(Integer.parseInt(s[i])==1)
			{
				sum+=init/4;
			}//1��и��ϰ��
			else if(Integer.parseInt(s[i])==3)
			{
				sum+=init/2;
			}//3��и��ϰ��
			else
			{
				sum+=(init/4)*3;
			}//4��и��ϰ��
			init=init/4;
		}
		System.out.println(sum);
	}

}
