import java.util.Scanner;
public class 백준_17298번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];//수열을 넣는 배열선언
		Stack s=new Stack();
		StringBuilder sb=new StringBuilder();
		s.push(0);//stack에는 인덱스를 넣는다
		for(int i=0;i<N;i++)
		{
		   arr[i]=scan.nextInt();
		}//수열 입력
		for(int i=1;i<N;i++)
		{
			while(s.size!=0)
			{
				if(arr[i]>arr[s.top()])
				{
					arr[s.top()]=arr[i];
					int a=s.pop();
				}
				else
				{
					break;
				}
			}
			s.push(i);
		}
		while(s.size!=0)
		{
			arr[s.pop()]=-1;
		}
		for(int i=0;i<N;i++)
		{
			sb.append(arr[i]+" ");
		}//결과 출력
		System.out.println(sb.toString());

	}
}
class Stack//스택 구현
{
	int[] arr=new int[1000000];
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
