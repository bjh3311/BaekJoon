import java.util.*;
import java.io.*;
public class ����_1966�� {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q=new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		int bigger=0;
		for(int i=0;i<T;i++)
		{
			int count=0;//���°�� ����ϴ��� Ȯ��
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			int[] arr=new int[N];
            s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[j]=Integer.parseInt(s[j]);
			}//�ش��ε����� �߿䵵
			for(int j=0;j<N;j++)
			{
				q.add(j);
			}//q�� �ε����� ������� �ִ´�
			loops: while(true)
			{
				bigger=0;
				for(int j=0;j<N;j++)
				{
					if(arr[q.peek()]<arr[j])
					{
						bigger++;
					}
				}
				if(bigger>0)//ť�� �� �պ��� ū�� �ϳ��� �ִٸ�
				{
					q.add(q.poll());//���� �ڿ� ���ġ
				}
				else//ť��  �� �պ��� ū�� �ϳ��� ���ٸ�
				{
					if(q.peek()==M)//ť�� �� ���� ã�� �ε�����
					{
						count++;
						sb.append(count+"\n");
						q.clear();//q�ʱ�ȭ
						break loops;
					}
					else//ť�� �� ���� ã�� �ε����� �ƴϸ�
					{
						arr[q.poll()]=0;//ť���� �����ϰ� �ش��ϴ� �ε����� �߿䵵���� 0���� �ʱ�ȭ
						count++;//���Ƚ��++
					}				
				}				
			}					
		}
		System.out.print(sb.toString());

	}

}
