import java.util.*;
import java.io.*;
public class 백준_2696번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int i=0;i<T;i++)
		{
			int N=scan.nextInt();
			System.out.println((N+1)/2);
			StringBuilder sb=new StringBuilder();
			PriorityQueue<Integer> down=new PriorityQueue<Integer>(Collections.reverseOrder());//peek가 가장 큰값
			PriorityQueue<Integer> up=new PriorityQueue<Integer>();//peek가 가장 작은값
			for(int j=0;j<N;j++)
			{
				int a=scan.nextInt();
				if(down.size()==up.size())
				{
					down.add(a);
				}
				else
				{
					up.add(a);
				}
				if(!down.isEmpty()&&!up.isEmpty())
				{
					if(down.peek()>up.peek())
					{
						int temp=down.poll();
						down.add(up.poll());
						up.add(temp);
					}
				}//swap
				if((j+1)%2==1)//홀수일때만 중간값 말하기
				{
					sb.append(down.peek()+" ");
				}
			}
			System.out.println(sb.toString());	
		}
	}
}
