package 스터디1011번_조합2;
import java.util.Scanner;
public class 스터디1011번_조합2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Scanner scan=new Scanner(System.in);
          int N=scan.nextInt();
          int R=scan.nextInt();
          arr[1][0]=1;
          arr[1][1]=1;
          System.out.println(Pas(N,R));
	}
	public static long[][] arr=new long[51][51];
	public static long Pas(int n,int r)
	{
		if(n==r||r==0)
		{
			arr[n][r]=1;
		}
		else
		{
			if(arr[n][r]==0)
			{
				arr[n][r]=Pas(n-1,r-1)+Pas(n-1,r);
			}
				
		}
	
			return arr[n][r];
	}

}
