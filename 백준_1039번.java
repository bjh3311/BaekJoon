import java.util.*;
import java.io.*;
class Node
{
	String value;
	int count;
	public Node(String value,int count)
	{
		this.value=value;
		this.count=count;
	}
}
public class 백준_1039번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		String a=s[0];
		int M=a.length();
		int K=Integer.parseInt(s[1]);
		boolean[][] visited=new boolean[1000001][K+1];
		if(M==1)//자릿수가 한자릿수면 바꾸질 못한다. 바로 -1 출력
		{
			System.out.println("-1");
			return;
		}
		int result=-1;
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(a,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int value=Integer.parseInt(temp.value);
			if(temp.count==K)
			{
				result=Math.max(result, value);
				continue;
			}
			if(visited[value][temp.count])
			{
				continue;
			}
			visited[value][temp.count]=true;
			for(int i=0;i<temp.value.length();i++)
			{
				for(int j=i+1;j<temp.value.length();j++)
				{
					char first=temp.value.charAt(i);
					char second=temp.value.charAt(j);
					char[] change=temp.value.toCharArray();
					change[j]=first;
					change[i]=second;
					if(change[0]=='0')
					{
						continue;
					}
					q.add(new Node(String.valueOf(change),temp.count+1));
				}
			}
		}
		System.out.println(result);
	}
}
