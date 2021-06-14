import java.util.*;
import java.io.*;
public class 백준_2343번 {

	public static int N,M;
	public static int[] arr;
	public static boolean binary(int size)
	{
		int cnt=0;
		int sum=0;
		for(int i=0;i<N;i++)
		{
			if(sum+arr[i]>size)
			{
				sum=arr[i];
				cnt++;
			}
			else
			{
				sum+=arr[i];
			}
		}
		if(cnt<M)//만들어진 그룹의 개수가 M보다 작다면 mid의 크기를 줄여야한다
		{
			return true;
		}
		else//만들어진 그룹의 개수가 M보다 크다면 mid의 크기를 늘려야한다.
		{
			return false;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		arr=new int[N];
		s=br.readLine().split(" ");
		int sum=0;
		int left=0;
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
			sum+=arr[i];
			if(left<arr[i])
			{
				left=arr[i];
			}
		}
		int right=sum;
		int mid=0;//블루레이의 크기
		int answer=0;
		while(left<=right)
		{
			mid=(left+right)/2;
			if(binary(mid))
			{
				answer=mid;
				right=mid-1;
			}
			else
			{
				left=mid+1;
			}
		}
		System.out.println(answer);
	}
}
