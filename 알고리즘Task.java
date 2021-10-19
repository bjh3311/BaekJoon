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
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(time[0].end);
		boolean ispossible;
		for(int i=1;i<N;i++)
		{
			Time temp=time[i];
			ispossible=false;
			for(int j=0;j<arr.size();j++)
			{
				if(arr.get(j)<=temp.start)//���� ������ �ִ� machine�� �ð��� ���ο� ������ ���۽ð����� �۰ų� ���ٸ�
				{
					arr.set(j, temp.end);//�ٽ� �ٲ��ش�
					ispossible=true;
					break;
				}
			}
			if(!ispossible)
			{
				arr.add(temp.end);
			}
		}
		System.out.println(arr.size());
	}
}