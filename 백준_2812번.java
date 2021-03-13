import java.io.*;
import java.util.*;
public class 백준_2812번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack=new Stack<Integer>();
		Stack<Integer> stack_2=new Stack<Integer>();
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		s=br.readLine().split("");
		int[] arr=new int[N];
		int count=0;
		stack.push(Integer.parseInt(s[0]));
		for(int i=1;i<N;i++)
		{
			int a=Integer.parseInt(s[i]);
			while(!stack.isEmpty()&&stack.peek()<a&&count<K)
			{
				stack.pop();//수를 제거
				count++;
			}
			stack.push(a);
		}
		while(!stack.isEmpty())
		{
			stack_2.push(stack.pop());
		}
		for(int i=0;i<N-K;i++)
		{
			if(!stack_2.isEmpty())
			{
				System.out.print(stack_2.pop());
			}
			
		}
	}
}
