import java.util.*;
import java.io.*;
public class 백준_11404번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][] map=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
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
		}//입력
		for(int i=0;i<n;i++)//거쳐가는 기준 노드
		{
			for(int j=0;j<n;j++)//시작노드
			{
				for(int k=0;k<n;k++)//도착노드
				{
					map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
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
	}
}
