import java.util.*;
import java.io.*;
public class 백준_13975번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//내림차순이다
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			PriorityQueue<Long> q=new PriorityQueue<Long>();
			long ans=0;
			int K=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			for(int j=0;j<K;j++)
			{
				q.add(Long.parseLong(s[j]));
			}
			while(q.size()!=1)
			{
				Long num1=q.poll();
				Long num2=q.poll();
				ans+=(num1+num2);
				q.add(num1+num2);
			}
			sb.append(ans+"\n");	
		}
		System.out.print(sb.toString());

	}

}
