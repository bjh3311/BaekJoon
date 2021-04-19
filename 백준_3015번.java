import java.util.*;
import java.io.*;
class Pair
{
	int key;
	int same;//동일한 키의 사람 숫자 나타냄
	public Pair(int key,int same)
	{
		this.key=key;
		this.same=same;
	}
}
public class 백준_3015번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Pair> s=new Stack<Pair>();
		long result=0;
		int a=Integer.parseInt(br.readLine());
		s.push(new Pair(a,1));
		for(int i=1;i<N;i++)
		{
			a=Integer.parseInt(br.readLine());
			Pair temp=new Pair(a,1);
			while(!s.isEmpty())
			{
				if(s.peek().key<a)
				{
					result+=s.peek().same;
					s.pop();
					
				}
				else if(s.peek().key>a)
				{
					result++;
					break;
				}
				else
				{
					int count=s.pop().same;
					result+=count;
					temp.same=count+1;
				}
			}	
			s.push(temp);
		}
		System.out.println(result);
	}
}