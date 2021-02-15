import java.util.Scanner;
public class 백준_4889번 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Stack open_close=new Stack();
		int index=1;
		StringBuilder sb=new StringBuilder();
		int result=0;
		int open_count=0;
		int close_count=0;
		while(true)
		{
			String[] s=scan.nextLine().split("");
			if(s[0].equals("-"))
			{
				break;
			}
			for(int i=0;i<s.length;i++)
			{
				if(s[i].equals("{"))
				{
					open_close.push(1);
				}
				else
				{
					int a=open_close.pop();
					if(a<0)
					{
						close_count++;
					}
				}
			}
			while(open_close.size!=0)
			{
				int a=open_close.pop();
				open_count++;
			}
			int a=Math.min(open_count, close_count);
			if(a%2==1)
			{
				result+=a+1;
			}
			else if(a%2==0)
			{
				result+=a;
			}
			open_count=open_count-a;
			close_count=close_count-a;
			while(open_count!=0)
			{
				open_count=open_count-2;
				result++;
			}
			while(close_count!=0)
			{
				close_count=close_count-2;
				result++;
			}
				
			sb.append(index+". "+result);
			sb.append("\n");
			index++;
			result=0;
		}
		System.out.print(sb.toString());
		


	}
}
class Stack//스택 구현
{
	int[] arr=new int[2001];
	int size=0;
	public void push(int n)
	{
		arr[size]=n;
		size++;
	}
	public int pop()
	{
		if(size==0)
		{
			return -1;
		}
		else
		{
			size--;
			return arr[size];
		}
		
	}
	public int top()
	{
		if(size==0)
		{
			return -1;
		}
		else
		{
			return arr[size-1];
		}
		
	}
}