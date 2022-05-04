import java.util.*;
import java.io.*;
public class ����_10868�� {

	public static int count;
	public static int arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(s[0]);//�� ����
		int M=Integer.parseInt(s[1]);
		int a;
		for(a=1;a<=N;a++)//���׸�Ʈ Ʈ���� ũ�⸦ �����ش�
		{
			if(Math.pow(2, a)>=N)
			{
				break;
			}
		}
		count=(int)Math.pow(2, a+1)-1;
		arr=new int[count+1];//1���� ��Ʈ���
		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i=0;i<N;i++)//�� ���� �� ��忡 �Է�
		{
			int value=Integer.parseInt(br.readLine());
			arr[(count/2)+1+i]=value;
		}
		preorder(1);
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0])+count/2;
			int end=Integer.parseInt(s[1])+count/2;
			sb.append(Segment(start,end)+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int preorder(int index)//�ʱ� Ʈ�� ����
	{
		if(index>=(count/2)+1)
		{
			return arr[index];
		}
		arr[index]=Math.min(preorder(index*2), preorder((index*2)+1));
		return arr[index];
	}
	public static int Segment(int start,int end)
	{	
		int result=Integer.MAX_VALUE;
		while(start<=end)//start�� end�� �ε����� �����ش�
		{
			if(start%2==1)//start�� Ȧ�����
			{
				result=Math.min(arr[start], result);
				start=(start+1)/2;
			}
			else
			{
				start=start/2;
			}
			if(end%2==0)//end�� ¦�����
			{
				result=Math.min(arr[end], result);
				end=(end-1)/2;
			}
			else
			{
				end=end/2;
			}
		}
		return result;
	}
}
