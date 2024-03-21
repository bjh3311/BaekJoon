import java.util.*;
import java.io.*;
public class 백준_16637번 {

	public static int result = Integer.MIN_VALUE;
	public static ArrayList<Integer> num = new ArrayList<Integer>();
	public static ArrayList<Character> oper = new ArrayList<Character>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("");
		for(int i=0;i<N;i++)
		{
			if(i%2==0)
			{
				num.add(Integer.parseInt(s[i]));
			}
			else
			{
				oper.add(s[i].charAt(0));
			}
		}
		recur(num.get(0),0);
		System.out.println(result);
	}
	public static void recur(int total,int index)
	{
		if(index==oper.size())
		{
			result = Math.max(total, result);
			return ;
		}
		//괄호 쳐서 연산 후 넘어감
		int temp = cal(total,num.get(index+1),oper.get(index));
		recur(temp,index+1);
		
		if(index+2<=num.size()-1)
		{
			temp = cal(total,
					cal(num.get(index+1),num.get(index+2),oper.get(index+1)),
					oper.get(index));
			recur(temp,index+2);
		}
		
	}
	public static int cal(int a,int b,char S)
	{
		switch(S)
		{
			case '+' : return a+b;
			case '-' : return a-b;
			case '*' : return a*b;
			default : return a+b;
		
		}
	}
}