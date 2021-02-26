import java.util.*;
import java.io.*;
public class 백준_11286번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer n1,Integer n2)
			{
				if(Math.abs(n1)==Math.abs(n2))
				{
					return n1-n2;//n1이 음수고 n2가 양수면 그대로 둔다.
				}
				else
				{
					return Math.abs(n1)-Math.abs(n2);
				}
			}
		});
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(br.readLine());
			if(a==0)
			{
				if(q.isEmpty())//우선순위 큐가 비어있다면
				{
					sb.append("0\n");
				}
				else
				{
					sb.append(q.poll()+"\n");
				}
			}
			else
			{
				q.add(a);
			}
		}
		System.out.print(sb.toString());

	}

}
