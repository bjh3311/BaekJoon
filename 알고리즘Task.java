import java.util.*;
import java.io.*;

class Time implements Comparable<Time>
{
	int start;
	int end;
	public Time(int start,int end)
	{
		this.start=start;
		this.end=end;
	}
	public int compareTo(Time o)//���۽ð�������� �������� ����
	{
		return start-o.start;
	}
}
class Machine implements Comparable<Machine>
{
	int num;//��� ��ȣ
	int end;//������ �ð�
	public Machine(int num,int end)
	{
		this.num=num;
		this.end=end;
	}
	public int compareTo(Machine o)//�� �ð��� ������ �켱������ ũ��
	{
		return end-o.end;
	}
}
public class �˰���Task {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s;
		Time[] time=new Time[N];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int Si=Integer.parseInt(s[0]);
			int Fi=Integer.parseInt(s[1]);
			time[i]=new Time(Si,Fi);
		}
		Arrays.sort(time);//���۽ð��� �������� �������� ����
		PriorityQueue<Machine> q=new PriorityQueue<Machine>();
		int num=1;
		q.add(new Machine(num,time[0].end));
		boolean ispossible;
		for(int i=1;i<N;i++)
		{
			Time temp=time[i];
			Machine m=q.poll();
			if(m.end<=temp.start)
			{
				q.add(new Machine(m.num,temp.end));
			}
			else
			{
				q.add(m);
				num++;
				q.add(new Machine(num,temp.end));
			}
			
		}
		System.out.println(num);
	}
}