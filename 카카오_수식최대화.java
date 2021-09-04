import java.util.*;
import java.io.*;
public class 카카오_수식최대화 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String exp=br.readLine();
		System.out.println(solution(exp));

	}
	public static ArrayList<Long> numlist=new ArrayList<Long>();
	public static ArrayList<Character> oplist=new ArrayList<Character>();
	public static boolean[] visited=new boolean[3];
	public static char[] choice=new char[3];
	public static char[] booho= {'+','-','*'};
	public static long answer=Long.MIN_VALUE;
	public static long solution(String expression)
	{
		String s="";
		for(char a:expression.toCharArray())
		{
			if(a=='-'||a=='+'||a=='*')
			{
				numlist.add(Long.parseLong(s));
				oplist.add(a);
				s="";
				continue;
			}
			s=s+a;
		}
		numlist.add(Long.parseLong(s));
		perm(0);
		return answer;
	}
	public static void perm(int num)//DFS 순열
	{
		if(num==3)
		{
			answer=Long.max(answer, calc());
		}
		for(int i=0;i<3;i++)
		{
			if(visited[i])
			{
				continue;
			}
			choice[num]=booho[i];
			visited[i]=true;
			perm(num+1);
			visited[i]=false;
		}
	}
	public static long calc()
	{
		ArrayList<Long> calcNum=(ArrayList<Long>)numlist.clone();
		ArrayList<Character> calcOp=(ArrayList<Character>)oplist.clone();
		for(char operate:choice )
		{
			for(int i=0;i<calcOp.size();i++)
			{
				if(calcOp.get(i)==operate)
				{
					long calcResult=0;
					if(operate=='*')
					{
						calcResult=calcNum.get(i)*calcNum.get(i+1);
					}
					else if(operate=='+')
					{
						calcResult=calcNum.get(i)+calcNum.get(i+1);
					}
					else if(operate=='-')
					{
						calcResult=calcNum.get(i)-calcNum.get(i+1);
					}
					calcNum.remove(i+1);
					calcNum.set(i,calcResult);
					calcOp.remove(i);
					i=i-1;
				}
			}
		}
		return Math.abs(calcNum.get(0));
	}
}
