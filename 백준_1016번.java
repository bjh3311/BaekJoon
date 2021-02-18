import java.util.Scanner;
public class 백준_1016번 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long min=scan.nextLong();
		long max=scan.nextLong();
		int size=(int)(max-min+1);
		int a=(int)(Math.sqrt(max));
		boolean[] result=new boolean[size];//제곱수면 true이다.제곱 ㄴㄴ수면 false
		for(long i=2;i<=a;i++)
		{
			long square=i*i;//제곱 수
			for(long j=((min-1)/square+1)*square;j<=max;j=j+square)
			{
				result[(int)(j-min)]=true;//제곱수면 true				
			}
		}
		long count=0;
		for(int i=0;i<max-min+1;i++)
		{
			if(!result[i])
			{
				count++;
			}
		}
		System.out.println(count);

	}

}
