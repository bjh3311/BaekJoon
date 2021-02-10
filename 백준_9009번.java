import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class ����_9009�� {
    public static int[] Fibonnaci=new int[41];//�Ǻ���ġ���� ���ϱ�����
    public static int Fib(int n)//������ȹ������ �Ǻ���ġ���� ���Ϸ�����
    {
         if(n<2)
         {
        	 return n;
         }
         else
         {
        	 if(Fibonnaci[n]==0)
        	 {
        		 Fibonnaci[n]=Fib(n-1)+Fib(n-2);
        	 }
        	 return Fibonnaci[n];
         }
    }
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();//�׽�Ʈ ���̽� ���� �Է�
		int[] num=new int[T];//�־��� �����Է�
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<T;i++)
		{
			num[i]=scan.nextInt();
		}//�־��� ���� ����Է�
		Fibonnaci[0]=0;
		Fibonnaci[1]=1;//�Ǻ���ġ �ʱⰪ ����
		int a=Fib(40);//���������ν� �Ǻ���ġ�� 40���� ��� ����
		int[][] result=new int[T][41];//����� �迭 ����
		for(int i=0;i<T;i++)
		{
			for(int j=40;j>0;j--)
			{
				if(num[i]>Fibonnaci[j])
				{
					result[i][j]=Fibonnaci[j];
					num[i]=num[i]-Fibonnaci[j];
				}
				if(num[i]==Fibonnaci[j])
				{
					result[i][j]=Fibonnaci[j];
					break;
				}
			}
		}//�׸��� �˰������� ��� �迭�� �Է�
		for(int i=0;i<T;i++)
		{
			for(int j=1;j<=40;j++)
			{
				if(result[i][j]!=0)
				{
					bw.write(result[i][j]+" ");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
     }
}

