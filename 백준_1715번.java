import java.util.*;
import java.io.*;
public class น้มุ_1715น๘ {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(br.readLine());
			q.add(a);
		}
		int ans=0;
		while(q.size()!=1)
		{
			int num1=q.poll();
			int num2=q.poll();
			ans+=num1+num2;
			q.add(num1+num2);
		}
		System.out.println(ans);
	}
}
