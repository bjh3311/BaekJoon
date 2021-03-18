import java.util.*;
public class 백준_1461번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		PriorityQueue<Integer> q_plus=new PriorityQueue<Integer>(Collections.reverseOrder());//내림차순
		PriorityQueue<Integer> q_minus=new PriorityQueue<Integer>(Collections.reverseOrder());
		//내림차순
		int max=0;//최대값 찾기
		for(int i=0;i<N;i++)
		{
			int x=scan.nextInt();
			if(Math.abs(x)>Math.abs(max))
			{
				max=Math.abs(x);
			}
			if(x>0)
			{
				q_plus.add(x);
			}
			else
			{
				q_minus.add(Math.abs(x));
			}
		}
		int ans=0;
		while(!q_plus.isEmpty())
		{
			int temp=q_plus.poll();
			for(int i=0;i<M-1;i++)
			{
				q_plus.poll();
				if(q_plus.isEmpty())
				{
					break;
				}
			}
			ans+=2*temp;
		}
		while(!q_minus.isEmpty())
		{
			int temp=q_minus.poll();
			for(int i=0;i<M-1;i++)
			{
				q_minus.poll();
				if(q_minus.isEmpty())
				{
					break;
				}
			}
			ans+=2*temp;
		}
		ans=ans-max;
		System.out.println(ans);
		
	}
}