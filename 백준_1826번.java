import java.util.*;
import java.io.*;
class oil_bank implements Comparable<oil_bank>
{
	int dis;
	int oil;
	public oil_bank(int dis,int oil)
	{
		this.dis=dis;
		this.oil=oil;
	}
	@Override
	public int compareTo(oil_bank o)
	{
		return dis-o.dis;//�Ÿ��� ª���� ū �켱������ ������
	}
}
public class ����_1826�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<oil_bank> info=new PriorityQueue<oil_bank>();//������ ������ ����ִ�.
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			info.add(new oil_bank(a,b));
		}
		s=br.readLine().split(" ");
		int L=Integer.parseInt(s[0]);//���������� �Ÿ�
		int P=Integer.parseInt(s[1]);//���� �����ִ� �⸧�� ��
		int result=0;//�����
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());//���� ū �⸧�� ���� ū �켱���� ����
		while(P<L)//���� �������ִ¿��ᰡ �Ÿ����� ��������
		{
			while(!info.isEmpty()&&P>=info.peek().dis)//ó�� ������ �ִ� ����� �� �� �ִ� ������ �� �Է¹޴´�
			{
				oil_bank temp=info.poll();
				q.add(temp.oil);
			}
			if(q.isEmpty())//���� ������ �ִ� ����� �� �� �ִ� �����Ұ� ���ٸ�...
			{
				result=-1;
				break;
			}
			P=P+q.poll();
			result++;
		}
		System.out.println(result);
	}
}
