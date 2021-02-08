import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ����_2493�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int[] arr=new int[N];//������ �ִ� �迭����
		Stack s=new Stack();
		s.push(N-1);//stack���� �ε����� �ִ´�
		StringBuilder sb=new StringBuilder();
		String[] qwe=bf.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
		   arr[i]=Integer.parseInt(qwe[i]);
		}//���� �Է�
		for(int i=N-2;i>=0;i--)
		{
			while(s.size!=0)
			{
				if(arr[i]>arr[s.top()])
				{
					arr[s.top()]=i+1;
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
			arr[s.pop()]=0;
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
	int[] arr=new int[500000];
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