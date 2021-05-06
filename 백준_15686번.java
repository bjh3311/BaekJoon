import java.util.*;
import java.io.*;
class loc//��ġ�� ��Ÿ���� ��ü
{
	int y;
	int x;
	public loc(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
public class ����_15686�� {
	static int result;//�����
	static boolean[] visited;
	static int M;
	static int N;
	static int[][] map;
	static ArrayList<loc> house;//���� ��ġ�� ��Ÿ���� ArrayList
	static ArrayList<loc> chi;
	public static void backtrack(int start,int count)
	{
		if(count==M)//�ִ� M���� �����ϸ� ġŲ�Ÿ� ������
		{
			DFS();
			return;
		}
		//����� M���� ġŲ���� ã�°���
		for(int i=start;i<chi.size();i++)
		{
			visited[i]=true;//true�̸� �̹� ��꿡�� Ȯ���� M���� ġŲ�� �� �ϳ���� ��
			backtrack(i+1,count+1);//i+1�� ����backtrack�� ���������ν� �ð�����
			visited[i]=false;
		}
	}
	public static void DFS()
	{
		int temp_result=0;
		for(int i=0;i<house.size();i++)//������ ��ġ�� Ȯ���Ѵ�
		{
			int min=Integer.MAX_VALUE;
			for(int j=0;j<chi.size();j++)
			{
				if(visited[j])//true�̸� M���� ġŲ���� �ϳ���� ��
				{
					int dis=Math.abs(house.get(i).x-chi.get(j).x)+Math.abs(house.get(i).y-chi.get(j).y);	
					min=Math.min(min,dis);
				}
			}
			temp_result=temp_result+min;
		}
		result=Math.min(result, temp_result);//temp_map������ ġŲ�Ÿ��� ���ġŲ�Ÿ��� ���������� ���ġŲ���� ����
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);//�ִ� ����
		map=new int[N][N];
		house=new ArrayList<loc>();
		chi=new ArrayList<loc>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1)//���� ��ġ�� �־��ش�
				{
					house.add(new loc(i,j));
				}
				else if(map[i][j]==2)
				{
					chi.add(new loc(i,j));
				}
			}
		}
		visited=new boolean[chi.size()];
		result=Integer.MAX_VALUE;//�ϴ� �ִ밪���� ���س��´�.
		backtrack(0,0);
		System.out.println(result);
		br.close();
	}
}
