import java.util.Scanner;
public class ����_1016�� {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long min=scan.nextLong();
		long max=scan.nextLong();
		int size=(int)(max-min+1);
		int a=(int)(Math.sqrt(max));
		boolean[] result=new boolean[size];//�������� true�̴�.���� �������� false
		for(long i=2;i<=a;i++)
		{
			long square=i*i;//���� ��
			for(long j=((min-1)/square+1)*square;j<=max;j=j+square)
			{
				result[(int)(j-min)]=true;//�������� true				
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
