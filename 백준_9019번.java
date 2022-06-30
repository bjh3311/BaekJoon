import java.util.*;


import java.io.*;
class Reg
{
	int num;
	String command;
	public Reg(int num,String command)
	{
		this.num=num;
		this.command=command;
	}
	public int D()
	{
		return (num*2)%10000;
	}
	public int S()
	{
		return num == 0 ? 9999 : num - 1;
	}
	public int L()
	{
		return (num%1000)*10+num/1000;
	}
	public int R()
	{
		return (num/10)+(num%10)*1000;
	}
}
public class 백준_9019번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			boolean[] visited=new boolean[10000];//초기값은 다 false
			String[] s=br.readLine().split(" ");
			int d1=Integer.parseInt(s[0]);
			int d2=Integer.parseInt(s[1]);
			visited[d1]=true;
			Queue<Reg> q=new LinkedList<Reg>();
			q.add(new Reg(d1,""));
			while(!q.isEmpty())//큐가 빌 때 까지 계속해서 한다
			{
				Reg cur=q.poll();
				if(cur.num==d2)//레지스터값이 같다면 
				{
					System.out.println(cur.command);
					break;
				}
				if(!visited[cur.D()])
				{
					q.add(new Reg(cur.D(),cur.command+"D"));
					visited[cur.D()]=true;
				}
				if(!visited[cur.S()])
				{
					q.add(new Reg(cur.S(),cur.command+"S"));
					visited[cur.S()]=true;
				}
				if(!visited[cur.L()])
				{
					q.add(new Reg(cur.L(),cur.command+"L"));
					visited[cur.L()]=true;
				}
				if(!visited[cur.R()])
				{
					q.add(new Reg(cur.R(),cur.command+"R"));
					visited[cur.R()]=true;
				}
			}
			T--;
		}
	}
}
