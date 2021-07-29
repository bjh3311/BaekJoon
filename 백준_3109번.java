import java.util.*;
import java.io.*;
public class ����_3109�� {
	public static int R;
	public static int C;
	public static boolean[][] visited;
	public static int[][] map;
	public static int[] dy= {-1,0,1};
	public static int result=0;
	public static boolean DFS(int y,int x)
	{
		if(x==C-1)//x��ǥ�� �� �� ���� �����ߴٴ� ��
		{
			result++;
			return true;//���� ������Ƿ� return true;
		}
		for(int i=0;i<3;i++)
		{
			int ny=y+dy[i];
			int nx=x+1;
			if(ny<0||ny>=R||map[ny][nx]==1||visited[ny][nx])//�ʹ��̰ų� �������� �湮�����ְų� �ǹ��� ������� continue;
			{
				continue;
			}
			visited[ny][nx]=true;
			if(DFS(ny,nx))
			{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		R=Integer.parseInt(s[0]);
		C=Integer.parseInt(s[1]);
		map=new int[R][C];
		visited=new boolean[R][C];
		for(int i=0;i<R;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<C;j++)
			{
				if(s[j].equals("x"))
				{
					map[i][j]=1;
				}
				else
				{
					map[i][j]=0;
				}
			}
		}

		for(int i=0;i<R;i++)
		{
			visited[i][0]=true;
			DFS(i,0);
		}
		System.out.println(result);

	}
}
