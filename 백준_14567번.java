import java.util.*;
import java.io.*;
	
	
public class ����_14567�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		int[] degree=new int[N+1];
		int[] sem=new int[N+1];
		int A;
		int B;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			A=Integer.parseInt(s[0]);
			B=Integer.parseInt(s[1]);
			degree[B]++;//�������� ����
			arr[A].add(B);
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(degree[i]==0)//���������� ���ٸ� ���������� ���ٴ� ���̴�
			{
				sem[i]=1;//�׷��Ƿ� 1�б⸸�� ��������
				q.add(i);
			}
		}
		while(!q.isEmpty())
		{
			int now=q.poll();
			for(int i=0;i<arr[now].size();i++)
			{
				int next=arr[now].get(i);
				degree[next]--;
				if(degree[next]==0)
				{
					sem[next]=sem[now]+1;
					q.add(next);
				}
			}
		}
		for(int i=1;i<=N;i++)
		{
			System.out.print(sem[i]+" ");
		}
	}
}
