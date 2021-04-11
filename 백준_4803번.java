import java.util.*;
import java.io.*;
public class ����_4803�� {
	public static boolean[] visited;
	public static ArrayList<Integer>[] arr;
	public static int tree;
	public static int BFS(int n)
	{
		visited[n]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(n);
		int node=0;
		int edge=0;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			node+=1;
			for(int i=0;i<arr[temp].size();i++)
			{
				edge+=1;
				if(!visited[arr[temp].get(i)])
				{
					visited[arr[temp].get(i)]=true;
					q.add(arr[temp].get(i));
				}
			}
		}
		return (edge/2)+1==node?1:0;
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=0;
		while(true)
		{
			T++;
			tree=0;//Ʈ���� ���� �� �׽�Ʈ���̽����� �ʱ�ȭ
			HashMap<Integer,Integer> root=new HashMap<Integer,Integer>();//root��带 ã������
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);//��� ����
			int m=Integer.parseInt(s[1]);//���� ����
			visited=new boolean[n+1];
			if(n==0&&m==0)
			{
				break;
			}
			arr=new ArrayList[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<m;i++)
			{
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				arr[a].add(b);
				arr[b].add(a);
			}//���� �Է¹ޱ�
			for(int i=1;i<=n;i++)
			{
				if(!visited[i])//i��� Ű�� ����.�� i�� ��Ʈ����̴�
				{
					tree+=BFS(i);
				}
			}
			if(tree<=0)
			{
				System.out.println("Case "+T+": No trees.");
			}
			else if(tree==1)
			{
				System.out.println("Case "+T+": There is one tree.");
			}
			else
			{
				System.out.println("Case "+T+": A forest of "+tree+" trees.");
			}//Ʈ���� ������ ���� �ٸ��� ���
			
		}

	}

}
