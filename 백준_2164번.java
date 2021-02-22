import java.util.*;
public class น้มุ_2164น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		for(int i=1;i<=N;i++)
		{
			q.offer(i);
		}
		for(int i=0;i<N-1;i++)
		{
			q.remove();
			q.offer(q.poll());
		}
		System.out.println(q.peek());
	}

}
