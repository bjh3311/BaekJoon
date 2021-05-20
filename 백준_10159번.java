import java.util.*;
import java.io.*;
public class 백준_10159번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
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
		String[] s;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0])-1;
			int b=Integer.parseInt(s[1])-1;
			map[a][b]=1;//a가 b보다 무겁다는 뜻
			map[b][a]=2;//b가 a보다 가볍다는 뜻
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
		for(int i=0;i<N;i++)
		{
			int count=0;
			for(int j=0;j<N;j++)
			{
				if(i!=j&&map[i][j]>=100000000)
				{
					count++;
				}
			}
			System.out.println(count);
		}

	}

}
