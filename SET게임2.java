import java.util.*;
import java.io.*;
class Figure
{
	int num;
	String color;
	String shape;
	String pattern;
	public Figure(int num,String color,String shape,String pattern)
	{
		this.num=num;
		this.color=color;
		this.shape=shape;
		this.pattern=pattern;
	}
}
class Comb
{
	int a;
	int b;
	int c;
	public Comb(int a,int b,int c)
	{
		this.a=a;
		this.b=b;
		this.c=c;
	}
}
public class SET����2 {
	
	public static boolean isPossible(Figure a,Figure b,Figure c)//SET�� �����Ѱ�??
	{
		HashSet<Integer> Num=new HashSet<Integer>();
		HashSet<String> Color=new HashSet<String>();
		HashSet<String> Shape=new HashSet<String>(); 
		HashSet<String> Pattern=new HashSet<String>();
		Num.add(a.num);
		Num.add(b.num);
		Num.add(c.num);
		if(Num.size()==2)//2�̸� ��ΰ��ų� ��� �ٸ� �����ǰ����� �������� �ƴϴ�!!
		{
			return false;
		}
		Color.add(a.color);
		Color.add(b.color);
		Color.add(c.color);
		if(Color.size()==2)//2�̸� ��ΰ��ų� ��� �ٸ� �����ǰ����� �������� �ƴϴ�!!
		{
			return false;
		}
		Shape.add(a.shape);
		Shape.add(b.shape);
		Shape.add(c.shape);
		if(Shape.size()==2)//2�̸� ��ΰ��ų� ��� �ٸ� �����ǰ����� �������� �ƴϴ�!!
		{
			return false;
		}
		Pattern.add(a.pattern);
		Pattern.add(b.pattern);
		Pattern.add(c.pattern);
		if(Pattern.size()==2)//2�̸� ��ΰ��ų� ��� �ٸ� �����ǰ����� �������� �ƴϴ�!!
		{
			return false;
		}
		return true;
	}
	public static void recur(int count,int index)
	{
		result=Math.max(result, count);
		for(int i=index;i<com.size();i++)
		{
			int a=com.get(i).a;
			int b=com.get(i).b;
			int c=com.get(i).c;
			if(!visited[a]&&!visited[b]&&!visited[c])//�� �� �湮������ ���ٸ�
			{
				visited[a]=true;
				visited[b]=true;
				visited[c]=true;
				recur(count+1,index+1);
				visited[a]=false;
				visited[b]=false;
				visited[c]=false;
			}
		}
	}
	public static int result;
	public static int N;
	public static Figure[] arr;
	public static boolean[] visited;
	public static ArrayList<Comb> com;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int how=1;
		while(T>0)
		{
			N=Integer.parseInt(br.readLine());
			arr=new Figure[N];
			String[] s;
			result=0;
			for(int i=0;i<N;i++)//ī������ �Է¹���
			{
				s=br.readLine().split("");
				for(int j=0;j<4;j++)
				{
					int num=Integer.parseInt(s[0]);
					String color=s[1];
					String shape=s[2];
					String pattern=s[3];
					arr[i]=new Figure(num,color,shape,pattern);
				}
			}
			visited=new boolean[N];
			com=new ArrayList<Comb>();
			for(int i=0;i<N;i++)
			{
				for(int j=i+1;j<N;j++)
				{
					for(int k=j+1;k<N;k++)
					{
						if(isPossible(arr[i],arr[j],arr[k]))//��Ʈ�� �����ϸ�
						{
							com.add(new Comb(i,j,k));//��Ʈ�� �����ϴ� ���� i,j,k�� �߰����ش�.
						}
					}
				}
			}
			recur(0,0);
			sb.append("#"+how+" "+result+"\n");
			T--;
			how++;
		}
		System.out.println(sb.toString());
	}
}
