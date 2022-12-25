import java.util.*;
public class 프로그래머스_두큐합같게만들기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] que1= {1,2,1,2};
		int[] que2= {1,10,1,2};

		System.out.println(solution(que1,que2));
	}
	public static int solution(int[] que1,int[] que2)
	{
		long temp1=0;
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();
		for(int i=0;i<que1.length;i++)
		{
			temp1+=que1[i];
			q1.add(que1[i]);
		}
		long temp2=0;
		for(int i=0;i<que2.length;i++)
		{
			temp2+=que2[i];
			q2.add(que2[i]);
		}
		if((temp1+temp2)%2==1)
		{
			return -1;
		}//두 큐의 합이 홀수라면 절대 같아질수 없다
		long sum=temp1+temp2;
		sum=sum/2;
		int p1=0,p2=0;
		int limit=que1.length*2;
		while(p1<=limit&&p2<=limit)
		{
			if(temp1==sum)
			{
				return p1+p2;
			}
			if(temp1>sum)
			{
				temp1=temp1-q1.peek();
				temp2=temp2+q1.peek();
				q2.add(q1.poll());
				p1++;
			}
			else
			{
				temp1=temp1+q2.peek();
				temp2=temp2-q2.peek();
				q1.add(q2.poll());
				p2++;
			}
		}
		return -1;
	}
}
