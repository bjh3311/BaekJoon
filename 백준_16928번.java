import java.util.*;
import java.io.*;

class Node
{
	int loc;
	int count;
	public Node(int loc,int count)
	{
		this.loc=loc;
		this.count=count;
	}
}
public class 백준_16928번 {

	public static int[] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new int[101];
		boolean[] visited=new boolean[101];
		for(int i=1;i<=100;i++)
		{
			map[i]=i;
		}
		String[] s=br.readLine().split(" ");
		int a=Integer.parseInt(s[0]);
		int b=Integer.parseInt(s[1]);
		for(int i=0;i<a+b;i++)
		{
			s=br.readLine().split(" ");
			int temp=Integer.parseInt(s[0]);
			int value=Integer.parseInt(s[1]);
			map[temp]=value;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(1,0));
		visited[1]=true;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.loc==100)
			{
				System.out.println(temp.count);
				break;
			}
			for(int i=1;i<=6;i++)
			{
				if(temp.loc+i<=100&&!visited[temp.loc+i])
				{
					if(temp.loc+i==map[temp.loc+i])//특별한 자리가 아니라면
					{
						q.add(new Node(temp.loc+i,temp.count+1));
						visited[temp.loc+i]=true;
					}
					else
					{
						q.add(new Node(map[temp.loc+i],temp.count+1));
						visited[map[temp.loc+i]]=true;
					}
					
				}
			}
		}
	}

}
