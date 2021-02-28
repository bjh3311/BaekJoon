import java.io.*;
public class ����_9009�� {
    public static long[] Fibonnaci=new long[46];//�Ǻ���ġ���� ���ϱ�����
    public static long Fib(int n)//������ȹ������ �Ǻ���ġ���� ���Ϸ�����
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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());//�׽�Ʈ ���̽� ���� �Է�
		long[] num=new long[T];//�־��� �����Է�
		for(int i=0;i<T;i++)
		{
			num[i]=Long.parseLong(br.readLine());
		}//�־��� ���� ����Է�
		Fibonnaci[0]=0;
		Fibonnaci[1]=1;//�Ǻ���ġ �ʱⰪ ����
		long a=Fib(45);//���������ν� �Ǻ���ġ�� 40���� ��� ����
		long[][] result=new long[T][46];//����� �迭 ����
		for(int i=0;i<T;i++)
		{
			for(int j=45;j>0;j--)
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
			for(int j=1;j<=45;j++)
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

