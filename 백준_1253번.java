import java.util.*;
import java.io.*;

public class 백준_1253번 {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		int result=0;
		for(int i=0;i<N;i++)//i번째 수가 Good인지 알아본다
		{
			int start=0;
			int end=N-1;
			while(true)
			{
				if(end==i)
				{
					end--;
				}
				else if(start==i)
				{
					start++;
				}
				
				if(start>=end)//결과값을 찾을 수 없을 경우
				{
					break;
				}
				
				if(arr[start]+arr[end]>arr[i])
				{
					end--;
				}
				else if(arr[start]+arr[end]<arr[i])
				{
					start++;
				}
				else
				{
					result++;
					break;
				}	
			}
		}
		System.out.println(result);
		
	}
}
