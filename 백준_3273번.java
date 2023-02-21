import java.util.*;
import java.io.*;


public class 백준_3273번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		if(N==0)
		{
			System.out.println("0");
			System.exit(0);
		}
		int[] arr=new int[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		int x=Integer.parseInt(br.readLine());
		int left=0;
		int right=N-1;
		int answer=0;
		int sum=0;
		while(left<right)
		{
			sum=arr[left]+arr[right];
			if(sum>=x)
			{
				if(sum==x)
				{
					answer++;
				}
				right--;
			}
			else if(sum<x)
			{
				left++;
			}
		}
		System.out.println(answer);
	}

}
