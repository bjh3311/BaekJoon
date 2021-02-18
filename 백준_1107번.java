import java.util.Scanner;

public class 백준_1107번{

	public static int[] broken=new int[10];//0이면 멀쩡 -1이면 고장
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		for(int i=0;i<M;i++)
		{
			broken[scan.nextInt()]=-1;
		}
		int result=Math.abs(N-100);
		for(int i=0;i<=1000000;i++)
		{
			int len=check(i);
			if(len>0)
			{
				int plus_minus=Math.abs(N-i);
				result=Math.min(result, plus_minus+len);
			}			
		}
		System.out.println(result);
	}
	public static int check(int i)
	{
		if(i==0)
		{
			if(broken[i]==-1)
			{
				return 0;
			}
			return 1;
		}
		int count=0;
		while(i>0)
		{
			if(broken[i%10]==-1)
			{
				return 0;
			}
			count++;
			i=i/10;
		}
		return count;
	}
}