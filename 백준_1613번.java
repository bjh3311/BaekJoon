import java.util.*;
import java.io.*;
public class 백준_1613번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i!=j)
				{
					map[i][j]=100000000;
				}
			}
		}
		
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0])-1;
			int b=Integer.parseInt(s[1])-1;
			map[a][b]=1;//a가 b보다 빨리 일어났다는 뜻
			map[b][a]=2;//b가 a보다 늦게 일어났다 뜻
		}
		for(int k=0;k<N;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(i!=j)
					{
						if(map[i][k]==1&&map[k][j]==1)
						{
							map[i][j]=1;
						}
						else if(map[i][k]==2&&map[k][j]==2)
						{
							map[i][j]=2;
						}
					}
					
				}
			}
		}
		int count=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<count;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(map[a-1][b-1]==1)
			{
				sb.append("-1\n");
			}
			else if(map[a-1][b-1]==2)
			{
				sb.append("1\n");
			}
			else
			{
				sb.append("0\n");
			}
			
		}
		System.out.println(sb.toString());

	}

}