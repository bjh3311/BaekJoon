import java.util.*;
import java.io.*;
class Pair implements Comparable<Pair>
{
	int x;
	int y;
	int index;//index를 나타낸다
	Pair(int x,int y,int index)
	{
		this.x=x;
		this.y=y;
		this.index=index;
	}
	public int compareTo(Pair o)//index오름차순으로 나타낸다
	{
		return index-o.index;
	}
}
public class 알고리즘_클러스터링 {

	public static int dist(Pair p1,Pair p2)
	{
		return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);//거리반환
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		Pair[] arr=new Pair[n];
		ArrayList<Pair> result=new ArrayList<Pair>();
		boolean[] center=new boolean[n];//Center로 선택되었는지 나타낸다.
		
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			arr[i]=new Pair(x,y,i);
		}
		result.add(arr[0]);//result에는 가장 첫번째 데이터를 넣는다
		center[0]=true;//0번째 데이터는 center로 선택되었다.
		int[] D=new int[n];//거리를 나타내는 배열
		for(int i=0;i<k-1;i++)//이미 한 점은 골랐기 때문에 k-1
		{
			Arrays.fill(D, 0);
			for(int j=0;j<=n-1;j++)
			{
				if(!center[j])//center점으로 선택이 안되었다면
				{
					int value=Integer.MAX_VALUE;
					for(Pair temp:result)//center점들과 비교한다
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
		Collections.sort(result);//index 오름차순으로 정렬
		for(Pair temp:result)
		{
			System.out.println(temp.x+" "+temp.y);
		}
	}
}
