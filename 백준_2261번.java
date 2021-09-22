import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int x;
	int y;
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int compareTo(Node o)
	{
		return x-o.x;
	}//x좌표 기준으로 정렬
}
class temp_Node implements Comparable<temp_Node>//나중에 y좌표로 정렬할떄 쓸 class
{
	int x;
	int y;
	public temp_Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int compareTo(temp_Node o)
	{
		return y-o.y;
	}
}
public class 백준_2261번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s;
		ArrayList<Node> arr=new ArrayList<Node>();
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			arr.add(new Node(x,y));
		}
		Collections.sort(arr);//x좌표 오름차순으로 정렬
		System.out.println(divide(arr,0,n-1));
	}
	public static int dis(Node o1,Node o2)//두 노드간의 거리
	{
		int x=o1.x-o2.x;
		int y=o1.y-o2.y;
		return (x*x)+(y*y);
	}
	public static int bruteforce(ArrayList<Node> arr,int start,int end)
	{
		int minDist=Integer.MAX_VALUE;
		for(int i=start;i<end;i++)
		{
			for(int j=i+1;j<=end;j++)
			{
				int k=dis(arr.get(i),arr.get(j));
				minDist=Math.min(minDist, k);
			}
		}
		return minDist;
	}
	public static int divide(ArrayList<Node> arr,int start,int end)//2분할 시키는 
	{
		int n=end-start+1;//start부터 end index까지 점의 개수
		if(n<=3)//3개 이하라면 bruteforce함수로 
		{
			return bruteforce(arr,start,end);
		}
		int mid=(start+end)/2;
		int d=Math.min(divide(arr,start,mid), divide(arr,mid+1,end));
		//mid를 기준으로 왼쪽 그룹과 오른쪽 그룹에서 가장 짧은 거리 d구하기
		
		
		//중앙선을 기준으로 양쪽으로 d 거리 이내에 들어오는 점들 고려
		//y좌표 기준으로 오름차순 정렬
		ArrayList<temp_Node> temp=new ArrayList<>();//중앙선을 기준으로 d안에 들어오는 점들만 넣을 임시 arrayList
		for(int i=start;i<=end;i++)
		{
			int t=arr.get(mid).x-arr.get(i).x;
			if(t*t<d)
			{
				temp.add(new temp_Node(arr.get(i).x,arr.get(i).y));
			}
		}
		Collections.sort(temp);//y좌표 오름차순으로 정렬
		for(int i=0;i<temp.size();i++)
		{
			for(int j=i+1;j<temp.size();j++)
			{
				int t=temp.get(j).y-temp.get(i).y;
				
				if(t*t<d)
				{
					d=Math.min(d, (temp.get(j).x-temp.get(i).x)*(temp.get(j).x-temp.get(i).x)+
							(temp.get(j).y-temp.get(i).y)*(temp.get(j).y-temp.get(i).y));
				}
				else
				{
					break;
				}
			}
		}
		return d;
	}

}
