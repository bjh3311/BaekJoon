import java.util.Arrays;
import java.util.Scanner;
public class น้มุ_1920น๘ {
	public static int[] arr;
	public static int binary(int left,int right,int num)
	{
		if(left>right)
		{
			return 0;
		}
		int mid=(left+right)/2;
	    if(arr[mid]==num)
	    {
	    	return 1;
	    }
	    else if(arr[mid]>num)
	    {
	    	return binary(left,mid-1,num);
	    }
	    else
	    {
	    	return binary(mid+1,right,num);
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb=new StringBuilder();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		Arrays.sort(arr);
		int M=scan.nextInt();
		int[] arr_2=new int[M];
		for(int i=0;i<M;i++)
		{
			arr_2[i]=scan.nextInt();
		}
		for(int i=0;i<M;i++)
		{
			sb.append(binary(0,N-1,arr_2[i]));
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}

}