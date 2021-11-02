import java.util.*;
import java.io.*;
public class 알고리즘1009번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s;
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==j)
					{
						continue;
					}
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
}
