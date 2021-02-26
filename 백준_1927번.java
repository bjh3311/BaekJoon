import java.util.*;
import java.io.*;
public class ����_1927�� {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> q=new PriorityQueue<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(br.readLine());
			if(a==0)
			{
				if(q.isEmpty())//���������
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
