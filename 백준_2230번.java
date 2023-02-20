import java.util.*;
import java.io.*;

public class 백준_2230번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int left=0;
		int right=0;
		int ans=Integer.MAX_VALUE;
		while(left<=N-1&&right<=N-1)
		{
			if(Math.abs(arr[left]-arr[right])>=M)
			{
				ans=Math.min(ans, Math.abs(arr[left]-arr[right]));
				left++;
			}
			else
			{
				right++;
			}
		}
		System.out.println(ans);
	}
}
