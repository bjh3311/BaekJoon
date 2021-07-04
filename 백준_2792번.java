import java.util.*;
import java.io.*;
public class น้มุ_2792น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] jew=new int[M];
		int left=1;
		int right=0;
		for(int i=0;i<M;i++)
		{
			jew[i]=Integer.parseInt(br.readLine());
			right=Math.max(jew[i], right);
		}
		int ans=Integer.MAX_VALUE;
		while(left<=right)
		{
			int mid=(left+right)/2;
			int people=0;
			for(int i=0;i<M;i++)
			{
				int div=jew[i]/mid;
				int rem=jew[i]%mid;
				if(rem==0)
				{
					people+=div;
				}
				else
				{
					people=people+div+1;
				}
			}
			if(people>N)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
				ans=Math.min(ans, mid);
			}
		}
		System.out.println(ans);
	}
}
