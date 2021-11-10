import java.util.*;
import java.io.*;
public class 백준_15483번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split("");
		String[] t=br.readLine().split("");
		int[][] E=new int[s.length+1][t.length+1];
		for(int i=0;i<=s.length;i++)//초기값 설정
		{
			E[i][0]=i;
		}
		for(int i=0;i<=t.length;i++)//초기값 설정
		{
			E[0][i]=i;
		}
		for(int i=1;i<=s.length;i++)
		{
			for(int j=1;j<=t.length;j++)
			{
				
				if(s[i-1].equals(t[j-1]))//i번째 문자와 j번째 문자가 같다면....
				{
					E[i][j]=threeMin(E[i-1][j-1],E[i-1][j]+1,E[i][j-1]+1);
				}
				else//다르다면
				{
					E[i][j]=threeMin(E[i-1][j-1]+1,E[i-1][j]+1,E[i][j-1]+1);
				}
			}
		}
		System.out.println(E[s.length][t.length]);
	}
	public static int threeMin(int a,int b,int c)
	{
		int result=Math.min(a, b);
		result=Math.min(result, c);
		return result;
	}

}
