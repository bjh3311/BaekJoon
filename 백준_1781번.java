import java.util.*;
import java.io.*;
class cup implements Comparable<cup>
{
	int dead;
	int count;
	public cup(int dead,int count)
	{
		this.dead=dead;
		this.count=count;
	}
	public int compareTo(cup o)
	{
		if(dead==o.dead)
		{
			return o.count-count;//마감기한이 같다면 
		}
		else//마감기한이 짧은게 앞으로 간다.
		{
			return dead-o.dead;
		}
	}
}
public class 백준_1781번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		ArrayList<cup> arr=new ArrayList<cup>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int dead=Integer.parseInt(s[0]);
			int count=Integer.parseInt(s[1]);
			arr.add(new cup(dead,count));
		}
		Collections.sort(arr);//마감기한이 가장 작은것이 작은인덱스로 간다.
		for(int i=0;i<N;i++)
		{
			int dead=arr.get(i).dead;
			int count=arr.get(i).count;
			q.add(count);
			if(dead<q.size())//q의사이즈는 여태까지 흘러간 시간, 시행한 시간이라고 생각한다.
			{
				q.poll();
			}
		}
		long result=0;
		while(!q.isEmpty())
		{
			result+=q.poll();
		}
		System.out.println(result);
	}
}
