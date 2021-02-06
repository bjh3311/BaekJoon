import java.util.Scanner;
public class ����_17298�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];//������ �ִ� �迭����
		Stack s=new Stack();
		StringBuilder sb=new StringBuilder();
		s.push(0);//stack���� �ε����� �ִ´�
		for(int i=0;i<N;i++)
		{
		   arr[i]=scan.nextInt();
		}//���� �Է�
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
		}//��� ���
		System.out.println(sb.toString());

	}
}
class Stack//���� ����
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
