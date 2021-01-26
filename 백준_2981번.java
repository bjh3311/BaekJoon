package ����_2981��;
import java.util.Arrays;
import java.util.Scanner;
public class ����_2981�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner scan=new Scanner(System.in);
         int N=scan.nextInt();
         int[] arr=new int[N];
         for(int i=0;i<N;i++)
         {
        	 arr[i]=scan.nextInt();
         }
         Arrays.sort(arr);
         int gcd=arr[1]-arr[0];
         for(int i=2;i<N;i++)
         {
        	 gcd=findGCD(Math.max(arr[i]-arr[i-1],gcd),Math.min(arr[i]-arr[i-1], gcd));
         }
         for(int i=2;i<=gcd;i++)
         {
        	 if(gcd%i==0)
        	 {
        		 System.out.println(i);
        	 }
         }
	}
	public static int findGCD(int a,int b)//��Ŭ���� ȣ�������� �ִ����� ã��
	{
		int r=a%b;
		if(r==0)
		{
			return b;
		}
		else
		{
			return findGCD(b,r);
		}
	}

}
