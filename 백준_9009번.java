import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class 백준_9009번 {
    public static int[] Fibonnaci=new int[41];//피보나치수를 구하기위함
    public static int Fib(int n)//동적계획법으로 피보나치수를 구하려고함
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
		int T=scan.nextInt();//테스트 케이스 갯수 입력
		int[] num=new int[T];//주어진 정수입력
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<T;i++)
		{
			num[i]=scan.nextInt();
		}//주어진 정수 모두입력
		Fibonnaci[0]=0;
		Fibonnaci[1]=1;//피보나치 초기값 설정
		int a=Fib(40);//실행함으로써 피보나치값 40까지 모두 구함
		int[][] result=new int[T][41];//결과값 배열 선언
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
		}//그리디 알고리즘으로 결과 배열에 입력
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

