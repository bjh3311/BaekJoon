import java.util.*;
public class น้มุ_11866น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		Queue<Integer> q=new LinkedList<>();
		int N=scan.nextInt();
		int K=scan.nextInt();
		sb.append("<");
		for(int i=1;i<=N;i++)
		{
			q.add(i);
		}
		for(int i=0;i<N-1;i++)
		{
			for(int j=0;j<K-1;j++)
			{
				q.add(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()+">");
		System.out.println(sb.toString());
	}

}
