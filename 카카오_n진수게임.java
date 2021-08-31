import java.util.*;
import java.io.*;
public class 카카오_n진수게임 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int t=Integer.parseInt(s[1]);
		int m=Integer.parseInt(s[2]);
		int p=Integer.parseInt(s[3]);
		System.out.println(solution(n,t,m,p));

	}
	public static String solution(int n,int t,int m,int p)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<=t*m;i++)
		{
			sb.append(Integer.toString(i,n));
		}
		StringBuilder ans=new StringBuilder();
		for(int i=p-1;ans.length()<t;i+=m)
		{
			ans.append(sb.charAt(i));
		}
		return ans.toString().toUpperCase();
	}

}
