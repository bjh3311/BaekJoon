package 문제E_수의개수2;
import java.util.Scanner;
import java.util.Arrays;
public class 문제E_수의개수2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[20001];
		for(int i=0;i<N;i++)
		{
			int a=scan.nextInt();
			arr[a+10000]++;//만약 a가 -10000이면 arr[0]++
		}
		for(int i=0;i<20001;i++)
		{
			if(arr[i]>0)
			{
				System.out.println(i-10000+" "+arr[i]);
			}
		}
		
		

	}

}
