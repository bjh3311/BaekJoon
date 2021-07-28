import java.util.*;
import java.io.*;
public class 백준_10775번 {
	public static int G,P;
	public static int result=0;
	public static int[] parents;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int G=Integer.parseInt(br.readLine());//게이트 개수
		int P=Integer.parseInt(br.readLine());//비행기 개수
		parents=new int[G+1];
		for(int i=1;i<=G;i++)
		{
			parents[i]=i;
		}
		for(int i=0;i<P;i++)
		{
			int g=Integer.parseInt(br.readLine());
			int emptyGate=find(g);
			if(emptyGate==0)//emptyGate가 0이라는뜻은 더이상 넣을 게이트가 없다는 뜻
			{
				break;
			}
			result++;
			union(emptyGate,emptyGate-1);
		}
		System.out.println(result);
	}
	public static int find(int x)
	{
		if(x==parents[x])//만약 x값이 들어왔는데 parents[x]=x , 즉 x게이트에 넣을수 있으면 x게이트에 넣는다.
		{
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	public static void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a!=b)
		{
			parents[a]=b;
		}
	}
}
