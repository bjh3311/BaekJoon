import java.util.*;
import java.io.*;
public class DAY8_교수님은 {

	public static int[] parent;
	static long [] WeightDiff;
	//WeightDiff[2]=3 이고 parent[2]=4이면 2번의 부모는 4번이고, 4번보다 3만큼 무겁다
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		while(true)
		{
			s=br.readLine().split(" ");
			if(s[0].equals("0")&&s[1].equals("0"))
			{
				break;
			}
			int N=Integer.parseInt(s[0]);//샘플 갯수
			int M=Integer.parseInt(s[1]);//질의의 수
			parent=new int[N+1];
			for(int i=1;i<=N;i++)
			{
				parent[i]=i;//처음에 부모는 자기 자신
			}
			WeightDiff=new long[N+1];
			int a,b,w;
			for(int i=0;i<M;i++)
			{
				s=br.readLine().split(" ");
				if(s[0].equals("!"))//무게를 쟀다
				{
					a=Integer.parseInt(s[1]);
					b=Integer.parseInt(s[2]);
					w=Integer.parseInt(s[3]);
					Union(a,b,w);
				}
				else//교수가 질문한다
				{
					a=Integer.parseInt(s[1]);
					b=Integer.parseInt(s[2]);
					if(Find(a)!=Find(b))//부모가 다르다면
					{
						System.out.println("UNKNOWN");
					}
					else
					{
						System.out.println(WeightDiff[b]-WeightDiff[a]);
					}
				}
			}
			
		}
	}
	public static void Union(int a,int b,int w)
	{
		int parentA=Find(a);
		int parentB=Find(b);
		if(parentA==parentB)//같은 부모이면 따로 계산할 필요가없다
		{
			return;
		}
		WeightDiff[parentB]=WeightDiff[a]-WeightDiff[b]+w;
		parent[parentB]=parentA;

	}
	public static int Find(int a)//
	{
		if(a==parent[a])
		{
			return a;
		}
		else
		{
			int parentIndex=Find(parent[a]);
			WeightDiff[a]=WeightDiff[a]+WeightDiff[parent[a]];
			return parent[a]=parentIndex;
				
		}
	}

}
