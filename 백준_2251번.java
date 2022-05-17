import java.util.*;
import java.io.*;
class Node
{
	int A;
	int B;
	int C;
	public Node(int A,int B,int C)
	{
		this.A=A;
		this.B=B;
		this.C=C;
	}
}
public class 백준_2251번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int A=Integer.parseInt(s[0]);
		int B=Integer.parseInt(s[1]);
		int C=Integer.parseInt(s[2]);
		boolean[][][] arr=new boolean[A+1][B+1][C+1];
		boolean[][] result=new boolean[A+1][C+1];
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(0,0,C));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int temp_A=temp.A;
			int temp_B=temp.B;
			int temp_C=temp.C;
			if(arr[temp_A][temp_B][temp_C])
			{
				continue;
			}
			arr[temp_A][temp_B][temp_C]=true;
			result[temp_A][temp_C]=true;
			if(temp_A>0)//A에 물이 있을때 B나 C로 옮긴다
			{
				if(temp_A+temp_C>=C)
				{
					q.add(new Node(temp_A-C+temp_C,temp_B,C));
				}
				else
				{
					q.add(new Node(0,temp_B,temp_A+temp_C));
				}
				if(temp_A+temp_B>=B)
				{
					q.add(new Node(temp_A-B+temp_B,B,temp_C));
				}
				else
				{
					q.add(new Node(0,temp_A+temp_B,temp_C));
				}
			}
			if(temp_B>0)//B에 물이 있을때 A나 C로 옮긴다
			{
				if(temp_B+temp_A>=A)
				{
					q.add(new Node(A,temp_B-A+temp_A,temp_C));
				}
				else
				{
					q.add(new Node(temp_A+temp_B,0,temp_C));
				}
				if(temp_B+temp_C>=C)
				{
					q.add(new Node(temp_A,temp_B-C+temp_C,C));
				}
				else
				{
					q.add(new Node(temp_A,0,temp_B+temp_C));
				}
			}
			if(temp_C>0)//C에 물이 있을때 A나 B로 옮긴다
			{
				if(temp_A+temp_C>=A)
				{
					q.add(new Node(A,temp_B,temp_C-A+temp_A));
				}
				else
				{
					q.add(new Node(temp_A+temp_C,temp_B,0));
				}
				if(temp_B+temp_C>=B)
				{
					q.add(new Node(temp_A,B,temp_C-B+temp_B));
				}
				else
				{
					q.add(new Node(temp_A,temp_B+temp_C,0));
				}
			}
		}
		for(int i=0;i<=C;i++)
		{
			if(result[0][i])
			{
				System.out.print(i+" ");
			}
		}
	}
}
