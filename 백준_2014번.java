import java.util.*;
import java.io.*;
public class น้มุ_2014น๘ {

	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		int N=sc.nextInt();
		long[] arr=new long[K];
		PriorityQueue<Long> q=new PriorityQueue<Long>();
		for(int i=0;i<K;i++)
		{
			long a=sc.nextLong();
			arr[i]=a;
			q.add(a);
		}
		long ans=0;
		for(int i=0;i<N;i++)
		{
			ans=q.poll();
			for(int j=0;j<K;j++)
			{
				long value=ans*arr[j];
				q.add(value);
				if(ans%arr[j]==0)
				{
					break;
				}
			}
		}
		System.out.println(ans);
		sc.close();

	}

}
