import java.util.*;
import java.io.*;
class jew implements Comparable<jew>
{
	int weight;
	int value;
	public jew(int weight,int value)
	{
		this.weight=weight;
		this.value=value;
	}
	@Override
	public int compareTo(jew target)
	{
		if(this.weight>target.weight)
		{
			return 1;
		}
		else if(this.weight<target.weight)
		{
			return -1;
		}
		else
		{
			if(this.value<target.value)
			{
				return 1;
			}
			else if(this.value>target.value)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	}
}
public class 백준_1202번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//보석의 개수
		int K=Integer.parseInt(s[1]);//가방의 개수
		int[] bag=new int[K];
		jew[] jew_info=new jew[N];
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			jew_info[i]=new jew(a,b);
		}
		for(int i=0;i<K;i++)
		{
			bag[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(jew_info);//무게가 올라가는 순으로 정렬
		Arrays.sort(bag);//무게가 올라가는 순으로 정렬
		long result=0;
		int index=0;
		for(int i=0;i<K;i++)//모든 가방엔 최대한 보석을 담자
		{
			while(index<N&&jew_info[index].weight<=bag[i])
			{
				q.add(jew_info[index].value);
				index++;
			}
			if(!q.isEmpty())//첫번째 요소는 가장 큰 가격을 의미한다
			{
				result+=q.poll();
			}
		}
		System.out.println(result);
	}
}
