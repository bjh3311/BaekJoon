package 백준_1541;
import java.util.Scanner;

public class 백준_1541번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		String[] arr=s.split("\\-");
		int result=Add(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			result -=Add(arr[i]);
		}
		System.out.println(result);
		

	}
	public static int Add(String i)
	{
		String[] arr=i.split("\\+");
		int result=0;
		for(int j=0;j<arr.length;j++)
		{
			result+=Integer.parseInt(arr[j]);
		}
		return result;
	}

}
