import java.util.*;
import java.io.*;

public class ����_11562�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		long[][] map=new long[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int u=Integer.parseInt(s[0]);
			int v=Integer.parseInt(s[1]);
			int b=Integer.parseInt(s[2]);
			if(b==0)//�ܹ���
			{
				map[u][v]=0;
				map[v][u]=1;//v���� u�� ������ u���� v�ΰ��� �Ϲ����� ���� 1���� ��������� �ٲ�����Ѵ� 
			}
			else//�����
			{
				map[u][v]=0;
				map[v][u]=0;
			}
		}
		for(int i=1;i<=n;i++)//i������ i�����δ� ���θ� �ٲ� �ʿ䰡 �����Ƿ� 0
		{	
			map[i][i]=0;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				for(int k=1;k<=n;k++)
				{
					long temp=map[j][i]+map[i][k];
					map[j][k]=Math.min(map[j][k], temp);
				}
			}
		}
		int k=Integer.parseInt(br.readLine());
		StringBuilder result=new StringBuilder();
		for(int i=0;i<k;i++)
		{
			s=br.readLine().split(" ");
			int S=Integer.parseInt(s[0]);
			int E=Integer.parseInt(s[1]);
			result.append(map[S][E]+"\n");
		}
		System.out.println(result.toString());
	}
}
