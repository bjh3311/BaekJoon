import java.util.*;
import java.io.*;
public class 백준_6236번 {

	public static int M;
	public static boolean is_possible(int mid)
	{
		int cnt=1;
		int sum=mid;
		for(int i=0;i<N;i++)
		{
			if(mid<price[i])
			{
				return false;
			}
			if(sum-price[i]<0)
			{
				sum=mid;
				cnt++;
			}
			sum=sum-price[i];
		}
		boolean result=cnt<=M? true:false;
		return result;
	}
	public static int N;
	public static int[] price;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		price=new int[N];
		M=Integer.parseInt(s[1]);
		int left=1;
		int right=0;
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(br.readLine());
			price[i]=a;
			right+=price[i];//M이 1이면 한번 인출해서 쭉 가져야 되므로
		}
		int ans=Integer.MAX_VALUE;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(is_possible(mid))
			{
				right=mid-1;
				ans=Math.min(ans, mid);
			}
			else//false면 mid값을 늘려야한다.
			{
				left=mid+1;
			}
			
		}
		System.out.println(ans);
	}
}
