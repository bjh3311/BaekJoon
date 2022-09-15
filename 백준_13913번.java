import java.util.*;
import java.io.*;
class Node
{
	int loc;//위치
	int sec;//시간
	int before;//이전 위치
	public Node(int loc,int sec,int before)
	{
		this.loc=loc;
		this.sec=sec;
		this.before=before;
	}
}
public class 백준_13913번 {
	public static int N;
	public static int K;
	public static int[] arr=new int[100001];//arr에는 몇 초를 저장
	public static boolean[] visited=new boolean[100001];
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		K=Integer.parseInt(s[1]);
		Queue<Node> q=new LinkedList<Node>();
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(K);
		q.add(new Node(N,0,N));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.loc<0||temp.loc>100000)
			{
				continue;
			}
			if(temp.loc==K)//도착점에 도착했다면
			{
				System.out.println(temp.sec);
				arr[temp.loc]=temp.before;
				break;
			}
			if(visited[temp.loc])//방문된 적 있다면
			{
				continue;
			}
			visited[temp.loc]=true;
			arr[temp.loc]=temp.before;
			q.add(new Node(temp.loc+1,temp.sec+1,temp.loc));
			q.add(new Node(temp.loc-1,temp.sec+1,temp.loc));
			q.add(new Node(temp.loc*2,temp.sec+1,temp.loc));
		}
		int index=K;
		while(index!=N)
		{
			stack.push(arr[index]);
			index=arr[index];
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}
	}
}