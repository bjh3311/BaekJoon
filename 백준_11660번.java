import java.util.*;
import java.io.*;

public class 백준_11660번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N-1;j++)
			{	
				map[i][j+1]+=map[i][j];
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N-1;j++)
			{
				map[j+1][i]+=map[j][i];
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int x1=Integer.parseInt(s[0])-1;
			int y1=Integer.parseInt(s[1])-1;
			int x2=Integer.parseInt(s[2])-1;
			int y2=Integer.parseInt(s[3])-1;
			int result=map[x2][y2];
			if(y1-1>=0)
			{
				result=result-map[x2][y1-1];
			}
			if(x1-1>=0)
			{
				result=result-map[x1-1][y2];
			}
			if(x1-1>=0&&y1-1>=0)
			{
				result+=map[x1-1][y1-1];
			}
			sb.append(result+"\n");
		}
		System.out.print(sb.toString());
	}
}