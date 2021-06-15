import java.util.*;
import java.io.*;
public class 백준_1507번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];//변경된지도
		int[][] arr=new int[N][N];//원래지도
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				arr[i][j]=map[i][j];
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					if(i==j||i==k||k==j)
					{
						continue;
					}
					if(map[j][k]>map[j][i]+map[i][k])
					{
						System.out.println("-1");
						System.exit(0);
					}
					if(map[j][k]==map[j][i]+map[i][k])
					{
						arr[j][k]=Integer.MAX_VALUE;
					}
				}
			}
		}
		int sum=0;
		boolean[][] visited=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i][j]!=Integer.MAX_VALUE&&i!=j&&!visited[i][j])
				{
					sum+=arr[i][j];
					visited[i][j]=true;
					visited[j][i]=true;
				}
				
			}
		}
		System.out.println(sum);
		

	}

}
