import java.util.*;
import java.io.*;
public class 백준_9935번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();//한글자씩 입력
		String bomb=br.readLine();//폭발 문자열
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			stack.push(s.charAt(i));
			if(stack.size()>=bomb.length())
			{
				boolean isbomb=true;
				for(int j=0;j<bomb.length();j++)
				{
					if(stack.get(stack.size()-bomb.length()+j)!=bomb.charAt(j))
					{
						isbomb=false;
						break;
					}
				}
				if(isbomb)
				{
					for(int j=0;j<bomb.length();j++)
					{
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(Character temp : stack)
		{
			sb.append(temp);
		}
		System.out.println(sb.length()==0?"FRULA":sb.toString());
	}
}
