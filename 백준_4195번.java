import java.util.*;
import java.io.*;


public class 백준_4195번 {

	public static int[] cnt;//부모간의 거리
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			cnt=new int[200001];
			parent=new int[200001];
			for(int i=1;i<=200000;i++)
			{
				parent[i]=i;
			}
			Arrays.fill(cnt, 1);
			int F=Integer.parseInt(br.readLine());
			String[] s;
			int index=1;
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			for(int i=0;i<F;i++)
			{
				s=br.readLine().split(" ");
				if(!map.containsKey(s[0]))
				{
					map.put(s[0], index);
					index++;
				}
				if(!map.containsKey(s[1]))
				{
					map.put(s[1], index);
					index++;
				}
				Union(map.get(s[0]),map.get(s[1]));
				System.out.println(cnt[Find(map.get(s[1]))]);
			}
			T--;
		}
	}
	public static void Union(int v1,int v2)
	{
		v1=Find(v1);
		v2=Find(v2);
		if(v1==v2)//v1 v2가 같다면 이미 연결되어있는 친구 관계
		{
			return ;
		}
		parent[v2]=v1;//v1밑으로 v2가들어감, 즉 v2의 부모가 v1
		cnt[v1]=cnt[v1]+cnt[v2];
	}
	public static int Find(int v1)
	{
		if(parent[v1]==v1)
		{
			return v1;
		}
		int p_v1=Find(parent[v1]);
		return p_v1;
	}
}
