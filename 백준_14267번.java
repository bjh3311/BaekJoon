import java.util.*;
import java.io.*;
public class 백준_14267번 {

	public static int n;
	public static ArrayList<Integer>[] arr;
	public static int[] result;
	public static void DFS(int n,int value)
	{
		result[n]=result[n]+value;
		for(int i=0;i<arr[n].size();i++)
		{
			DFS(arr[n].get(i),result[n]);
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		result=new int[n+1];
		arr=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		s=br.readLine().split(" ");
		for(int i=1;i<n;i++)
		{
			arr[Integer.parseInt(s[i])].add(i+1);//직속상사 관계 입력
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			result[a]=result[a]+b;
		}
		DFS(1,0);
		for(int i=1;i<=n;i++)
		{
			System.out.print(result[i]+" ");
		}//결과값 출력
	}
}
