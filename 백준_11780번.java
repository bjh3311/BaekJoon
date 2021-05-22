import java.util.*;
import java.io.*;
public class ����_11780�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][] map=new int[n][n];
		int[][] next=new int[n][n];//next[3][5]�� 5���� ���� ���ø� �����س��� �迭�̴�.
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				next[i][j]=-1;
				map[i][j]=100000005;
				if(i==j)
				{
					map[i][j]=0;
				}
			}
		}
		String[] s;
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a-1][b-1]=Math.min(map[a-1][b-1], c);
			next[a-1][b-1]=a-1;
		}//�Է�
		for(int i=0;i<n;i++)//���İ��� ���� ���
		{
			for(int j=0;j<n;j++)//���۳��
			{
				for(int k=0;k<n;k++)//�������
				{
					if(map[j][k]>map[j][i]+map[i][k])
					{
						map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
						next[j][k]=next[i][k];
					}
					
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(map[i][j]>100000000)
				{
					System.out.print(0+" ");
				}
				else
				{
					System.out.print(map[i][j]+" ");
				}	
			}
			System.out.println();
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(next[i][j]==-1)
				{
					sb.append("0\n");
				}
			
				else
				{
					Stack<Integer> path=new Stack<Integer>();
					int	 pre=j;
					path.push(j+1);
					while(i!=next[i][pre])
					{
						pre=next[i][pre];
						path.push(pre+1);
					}
					sb.append(path.size()+1+" ");
					sb.append(i+1+" ");
					while(!path.isEmpty())
					{
						sb.append(path.pop()+" ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
}