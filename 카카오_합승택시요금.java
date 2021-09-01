import java.util.*;
import java.io.*;
public class 카카오_합승택시요금 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] sb=br.readLine().split(" ");
		int n=Integer.parseInt(sb[0]);
		int s=Integer.parseInt(sb[1]);
		int a=Integer.parseInt(sb[2]);
		int b=Integer.parseInt(sb[3]);
		sb=br.readLine().split(" ");
		int e=Integer.parseInt(sb[0]);
		int[][] fares=new int[e][3];
		for(int i=0;i<e;i++)
		{
			sb=br.readLine().split(" ");
			int c=Integer.parseInt(sb[0]);
			int d=Integer.parseInt(sb[1]);
			int f=Integer.parseInt(sb[2]);
			fares[i][0]=c;
			fares[i][1]=d;
			fares[i][2]=f;
		}
		System.out.println(solution(n,s,a,b,fares));
	}
	public static int[][] map;
	public static int result=Integer.MAX_VALUE;
	public static int solution(int n,int s,int a,int b,int[][] fares)
	{
		int answer=0;
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			Arrays.fill(map[i], 100000000);
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==j)
				{
					map[i][j]=0;
				}
			}
		}
		for(int[] each:fares)
		{
			int start=each[0];
			int end=each[1];
			int cost=each[2];
			map[start][end]=cost;
			map[end][start]=cost;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				for(int k=1;k<=n;k++)
				{
					map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
		for(int i=1;i<=n;i++)
		{
			int temp=map[s][i]+map[i][a]+map[i][b];
			result=Math.min(result,temp);
		}
		answer=result;
		return answer;
	}
}
