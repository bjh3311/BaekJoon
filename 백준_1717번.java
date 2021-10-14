import java.util.*;
import java.io.*;
public class น้มุ_1717น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		parent=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int op=Integer.parseInt(s[0]);
			int a=Integer.parseInt(s[1]);
			int b=Integer.parseInt(s[2]);
			if(op==0)
			{	
				Union(a,b);
			}
			else
			{
				if(findParent(a)==findParent(b))
				{
					bw.write("YES\n");
				}
				else
				{
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
		bw.close();
		
	}
	public static int[] parent;
	public static void Union(int a,int b)
	{
		int x=findParent(a);
		int y=findParent(b);
		if(x!=y)
		{
			if(x<y)
			{
				parent[y]=x;
			}
			else
			{
				parent[x]=y;
			}
		}
		
	}
	public static int findParent(int a)
	{
		if(parent[a]==a)
		{
			return a;
		}
		return a=findParent(parent[a]);
	}
}
