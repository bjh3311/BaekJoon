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
	public int compareTo(Time o)//시작시간순서대로 오름차순 정렬
	{
		return start-o.start;
	}
}
public class 알고리즘Task {

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
		Arrays.sort(time);//시작시간을 기준으로 오름차순 정렬
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(time[0].end);
		boolean ispossible;
		for(int i=1;i<N;i++)
		{
			Time temp=time[i];
			ispossible=false;
			for(int j=0;j<arr.size();j++)
			{
				if(arr.get(j)<=temp.start)//만약 가지고 있는 machine중 시간이 새로운 업무의 시작시간보다 작거나 같다면
				{
					arr.set(j, temp.end);//다시 바꿔준다
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