import java.util.*;
import java.io.*;
public class น้มุ_11403น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++)
		{
			String[] s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					if(map[j][i]==1&&map[i][k]==1)
					{
						map[j][k]=1;
					}
				}
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}

}
