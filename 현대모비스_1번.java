import java.util.*;
import java.io.*;
public class 현대모비스_1번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] dice=new int[N][6];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<6;j++)
			{
				dice[i][j]=Integer.parseInt(s[j]);
			}
		}
		System.out.println(solution(dice));	
	}
	public static boolean[] visited;
	public static boolean[] visited_result=new boolean[10000];
	public static int solution(int[][] dice)
	{
		int count=dice.length;
		visited=new boolean[count];
		recur(dice,count);
		int answer=0;
		for(int i=1;i<10000;i++)
		{
			if(!visited_result[i])
			{
				answer=i;
				break;
			}
		}
		return answer;
	}
	public static String sb="";
	public static void recur(int[][] dice,int count)
	{
		if(count==0)
		{
			return;
		}
		for(int i=0;i<dice.length;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				for(int j=0;j<6;j++)
				{
					sb=sb+(Integer.toString(dice[i][j]));
					visited_result[Integer.parseInt(sb)]=true;
					recur(dice,count-1);
					sb=sb.substring(0,sb.length()-1);
				}
				visited[i]=false;
			}
		}
	}
}
