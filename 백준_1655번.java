import java.util.*;
import java.io.*;
public class ����_1655�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> up=new PriorityQueue<Integer>(Collections.reverseOrder());//peek�� ���� ū��
		PriorityQueue<Integer> down=new PriorityQueue<Integer>();
		//peek�� ����������
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(br.readLine());
			if(up.size()==down.size())//���� ũ�Ⱑ ������
			{
				up.offer(a);
			}
			else
			{
				down.offer(a);
			}
			if(!up.isEmpty()&&!down.isEmpty())//�Ѵ� ������� �ʴٸ�
			{
				if(up.peek()>down.peek())
				{
					int swap_a=up.poll();
					int swap_b=down.poll();
					up.offer(swap_b);
					down.offer(swap_a);
				}
			}
			sb.append(up.peek()+"\n");
		}
		System.out.print(sb.toString());
		
	}
}
