package ����_1874��;
import java.util.Scanner;
public class ����_1874�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s=new Stack();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int index=1;
		StringBuilder result=new StringBuilder();
		loops:for(int i=0;i<N;i++)
		{
		     int a=scan.nextInt();
		     while(true)
		     {
		    	 if(index>N+10)
		    	 {
		    		 result.setLength(0);
		    		 result.append("NO");
		    		 break loops;/*���� �ε������� N���� Ŀ���� 
		    		       result string�� �ʱ�ȭ�ϰ� No�� �߰��� �� loopsŻ��*/
		    	 }
		    	 if(s.top()==a)
		    	 {
		    		int qwe=s.pop();
		    		result.append("-");
		    		result.append("\n");
		    		break;
		    	 }
		    	 else
		    	 {
		    		 s.push(index);
		    		 index++;
		    		 result.append("+");
		    		 result.append("\n");
		    	 }
		    	 
		     }
		}
		System.out.println(result.toString());
		
	}
	

}
class Stack//���� ����
{
	int[] arr=new int[100000];
	int size=0;
	public void push(int n)
	{
		arr[size]=n;
		size++;
	}
	public int pop()
	{
		size--;
		return arr[size];
	}
	public int top()
	{
		if(size==0)
		{
			return -1000;
		}
		else
		{
			int a=size-1;
			return arr[a];
		}
		
	}
}
