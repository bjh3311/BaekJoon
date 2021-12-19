import java.util.*;
import java.io.*;
class Node
{
	int num;
	int time;
	public Node(int num,int time)
	{
		this.num=num;
		this.time=time;
	}
}
class State
{
	int time;
	public State(int time)
	{
		this.time=time;
	}
}
public class 거점점령 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int how=1;
		StringBuilder sb=new StringBuilder();
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			s=br.readLine().split(" ");
			ArrayList<Integer>[] arr=new ArrayList[N+1];
			int A_Start=Integer.parseInt(s[0]);//A시작점
			int B_Start=Integer.parseInt(s[1]);//B시작점
			ArrayList<Integer> dachi=new ArrayList<Integer>();
			int dachi_count=0;
			for(int i=1;i<=N;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<M;i++)
			{
				s=br.readLine().split(" ");
				arr[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
				arr[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
			}
			Queue<Node> q=new LinkedList<Node>();
			q.add(new Node(A_Start,0));
			State[] time=new State[N+1];
			for(int i=1;i<=N;i++)
			{
				time[i]=new State(Integer.MAX_VALUE);
			}
			boolean[] visited=new boolean[N+1];
			while(!q.isEmpty())//A시작점
			{
				Node temp=q.poll();
				if(visited[temp.num])
				{
					continue;
				}
				visited[temp.num]=true;
				time[temp.num].time=Math.min(time[temp.num].time,temp.time);
				for(int next:arr[temp.num])
				{
					if(!visited[next])
					{
						q.add(new Node(next,temp.time+1));
					}
				}
			}
			visited=new boolean[N+1];
			q.add(new Node(B_Start,0));
			while(!q.isEmpty())//B시작점
			{
				Node temp=q.poll();
				if(visited[temp.num])
				{
					continue;
				}
				visited[temp.num]=true;//방문 처리해준다
				if(time[temp.num].time>temp.time)//B걸로 만들어버린다
				{
					time[temp.num].time=temp.time;
					for(int next:arr[temp.num])
					{
						if(!visited[next])
						{
							q.add(new Node(next,temp.time+1));
						}	
					}
				}
				else if(time[temp.num].time==temp.time)//대치 장소로 만들어버린다
				{
					dachi.add(temp.num);//대치점추가 시킨다.
					for(int next:arr[temp.num])
					{
						if(!visited[next])
						{
							q.add(new Node(next,temp.time+1));
						}
					}
				}
				else//A것이므로 어떻게 할순없다
				{
					continue;
				}
				
			}
			int real_dachi=0;
			visited=new boolean[N+1];
			HashSet<Integer> qwe=new HashSet<Integer>();
			q.add(new Node(A_Start,0));
			while(!q.isEmpty())//A시작점
			{
				Node temp=q.poll();
				if(visited[temp.num])
				{
					continue;
				}
				if(dachi.contains(temp.num))//대치점으로 추정되는곳에 도달했다면
				{
					if(qwe.contains(temp.num))
					{
						continue;
					}
					qwe.add(temp.num);
					real_dachi++;
					continue;
				}
				System.out.println(temp.num);
				visited[temp.num]=true;
				time[temp.num].time=Math.min(time[temp.num].time,temp.time);
				for(int next:arr[temp.num])
				{
					if(!visited[next])
					{
						q.add(new Node(next,temp.time+1));
					}
				}
			}	
			T--;
			int A_count=0;
			for(int i=1;i<=N;i++)
			{
				if(visited[i])
				{					
					A_count++;
				}
			}
			int temp_result;

			if(A_count>=(N+1/2))//과반수 이상 불가능하다면
			{
				temp_result=0;
			}
			else if(A_count+dachi.size()<(N+1)/2)
			{
				temp_result=-1;
			}
			else
			{
				temp_result=(N+1)/2-A_count;
			}
			sb.append("#"+how+" "+real_dachi+" "+temp_result+"\n");//dachi arrayList에는 중립지점과 대치점 모두 있다
			how++;
		}
		System.out.println(sb.toString());
	}
}
