import java.util.Scanner;
public class 백준_1074번 {
	public static int count=0;
	public static StringBuilder sb=new StringBuilder();
	public static void Z(int N,int r,int c,int i,int j)//i,j는 최초 점
	{
		if(N==1)
		{
			if(r<i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("2 ");
				
			}//제 2사분면
			else if(r>=i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("1 ");
				
			}//1사분면
			else if(r<i+two_pow(N)/2&&c>=j+two_pow(N)/2)
			{
				sb.append("3 ");
				
			}//제 3사분면
			else
			{
				sb.append("4 ");
			}//제 4분면
		}
		else
		{
			if(r<i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("2 ");
				Z(N-1,r,c,i,j);
			}//제 2사분면
			else if(r>=i+two_pow(N)/2&&c<j+two_pow(N)/2)
			{
				sb.append("1 ");
				Z(N-1,r,c,i+two_pow(N)/2,j);
			}//1사분면
			else if(r<i+two_pow(N)/2&&c>=j+two_pow(N)/2)
			{
				sb.append("3 ");
				Z(N-1,r,c,i,j+two_pow(N)/2);
			}//제 3사분면
			else
			{
				sb.append("4 ");
				Z(N-1,r,c,i+two_pow(N)/2,j+two_pow(N)/2);
			}//제 4분면
		}
		
	}
	public static int two_pow(int a)//2의 몇승 구하는 함수
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
			}//2사분면일경우
			else if(Integer.parseInt(s[i])==1)
			{
				sum+=init/4;
			}//1사분면일경우
			else if(Integer.parseInt(s[i])==3)
			{
				sum+=init/2;
			}//3사분면일경우
			else
			{
				sum+=(init/4)*3;
			}//4사분면일경우
			init=init/4;
		}
		System.out.println(sum);
	}

}
