import java.util.*;
public class ����_16234�� {
	public static int N;
	public static int L;
	public static int R;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int count;
	public static void BFS(int i,int j)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		visited[i][j]=true;
		q.add(i);
		q.add(j);
		int sum=arr[i][j];//������ �α���
		count=1;//������ ����
		Queue<Integer> index=new LinkedList<Integer>();
		index.add(i);
		index.add(j);
		while(!q.isEmpty())
		{
			int y=q.poll();//y��ǥ
			int x=q.poll();//x��ǥ
			if(y+1<N&&!visited[y+1][x]&&Math.abs(arr[y][x]-arr[y+1][x])>=L&&Math.abs(arr[y][x]-arr[y+1][x])<=R)
			{
				q.add(y+1);
				q.add(x);
			    visited[y+1][x]=true;
				index.add(y+1);
				index.add(x);
				sum+=arr[y+1][x];
				count++;
			}
			if(y-1>=0&&!visited[y-1][x]&&Math.abs(arr[y][x]-arr[y-1][x])>=L&&Math.abs(arr[y][x]-arr[y-1][x])<=R)
			{
				q.add(y-1);
				q.add(x);
				visited[y-1][x]=true;
				index.add(y-1);
				index.add(x);
				sum+=arr[y-1][x];
				count++;
			}
			if(x+1<N&&!visited[y][x+1]&&Math.abs(arr[y][x]-arr[y][x+1])>=L&&Math.abs(arr[y][x]-arr[y][x+1])<=R)
			{
				q.add(y);
				q.add(x+1);
				visited[y][x+1]=true;
				index.add(y);
				index.add(x+1);
				sum+=arr[y][x+1];
				count++;
			}
			if(x-1>=0&&!visited[y][x-1]&&Math.abs(arr[y][x]-arr[y][x-1])>=L&&Math.abs(arr[y][x]-arr[y][x-1])<=R)
			{
				q.add(y);
				q.add(x-1);
				visited[y][x-1]=true;
				index.add(y);
				index.add(x-1);
				sum+=arr[y][x-1];
				count++;
			}
		}
		int value=sum/count;
		while(!index.isEmpty())
		{
			int y=index.poll();
			int x=index.poll();
			arr[y][x]=value;
		}//���ο� �� ����	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		L=scan.nextInt();
		R=scan.nextInt();
		arr=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
			   arr[i][j]=scan.nextInt();
			}
		}
		int result=0;
	    boolean invoke=false;
		for(int k=0;k<2000;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(!visited[i][j])//�湮�����̾��ٸ� BFS ����
					{
						BFS(i,j);
						if(count!=1)
						{
							invoke=true;
						}
					}
				}
			}
			if(invoke)
			{
				result++;
			}
			invoke=false;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					visited[i][j]=false;
				}
			}//visited�ʱ�ȭ
		}
		System.out.println(result);//�α��̵� Ƚ�� ���
	}
}
