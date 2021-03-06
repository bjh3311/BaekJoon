import java.util.*;
public class ����_14226�� {
	public static int S;
	public static int[][] visited; 
	public static void BFS()
	{
		Queue<Integer> q=new LinkedList<Integer>();
		visited[1][0]=0;//ó�� ��ġ�� 0
		q.add(1);//ó�� �̸�Ƽ�� ���� 1��
		q.add(0);//Ŭ�����忡�� 0
		while(!q.isEmpty())//q�� �� ������
		{
			int s=q.poll();//�̸�Ƽ�� ����
			int c=q.poll();//Ŭ�����忡 ����Ǿ��ִ� �̸�Ƽ�� ����
			if(visited[s][s]==-1)//Ŭ�����忡 ���翬��
			{
				visited[s][s]=visited[s][c]+1;
				q.add(s);
				q.add(s);
			}
			if(s-1>=0&&visited[s-1][c]==-1)//��������
			{
				q.add(s-1);
				q.add(c);//Ŭ������ ������ �״��
				visited[s-1][c]=visited[s][c]+1;
			}
			if(s+c<=S&&visited[s+c][c]==-1)
			{
				q.add(s+c);
				q.add(c);//Ŭ�����忡 ����Ǿ��մ� �̸�Ƽ�� ������ ����
				visited[s+c][c]=visited[s][c]+1;
			}
			
		}
		int ans=-1;
		for(int i=0;i<=S;i++)
		{
			if(visited[S][i]!=-1)
			{
				if(ans==-1||ans>visited[S][i])
				{
					ans=visited[S][i];
				}
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		S=scan.nextInt();
		visited=new int[S+2][S+2];
		for(int i=0;i<=S;i++)
		{
			Arrays.fill(visited[i], -1);//visited�� -1�� �ʱ�ȭ
		}
		BFS();
	}

}
