import java.util.*;
import java.io.*;
class Pair implements Comparable<Pair>
{
	int x;
	int y;
	int index;//index�� ��Ÿ����
	Pair(int x,int y,int index)
	{
		this.x=x;
		this.y=y;
		this.index=index;
	}
	public int compareTo(Pair o)//index������������ ��Ÿ����
	{
		return index-o.index;
	}
}
public class �˰���_Ŭ�����͸� {

	public static int dist(Pair p1,Pair p2)
	{
		return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);//�Ÿ���ȯ
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		Pair[] arr=new Pair[n];
		ArrayList<Pair> result=new ArrayList<Pair>();
		boolean[] center=new boolean[n];//Center�� ���õǾ����� ��Ÿ����.
		
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			arr[i]=new Pair(x,y,i);
		}
		result.add(arr[0]);//result���� ���� ù��° �����͸� �ִ´�
		center[0]=true;//0��° �����ʹ� center�� ���õǾ���.
		int[] D=new int[n];//�Ÿ��� ��Ÿ���� �迭
		for(int i=0;i<k-1;i++)//�̹� �� ���� ����� ������ k-1
		{
			Arrays.fill(D, 0);
			for(int j=0;j<=n-1;j++)
			{
				if(!center[j])//center������ ������ �ȵǾ��ٸ�
				{
					int value=Integer.MAX_VALUE;
					for(Pair temp:result)//center����� ���Ѵ�
					{
						value=Math.min(value, dist(arr[j],temp));
					}
					D[j]=value;
				}
			}
			int max=0;
			int index=0;
			for(int j=0;j<=n-1;j++)
			{
				if(max<D[j])
				{
					max=D[j];
					index=j;
				}
			}
			result.add(arr[index]);
			center[index]=true;
		}
		Collections.sort(result);//index ������������ ����
		for(Pair temp:result)
		{
			System.out.println(temp.x+" "+temp.y);
		}
	}
}
