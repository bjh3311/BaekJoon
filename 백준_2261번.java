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
	}//x��ǥ �������� ����
}
class temp_Node implements Comparable<temp_Node>//���߿� y��ǥ�� �����ҋ� �� class
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
public class ����_2261�� {

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
		Collections.sort(arr);//x��ǥ ������������ ����
		System.out.println(divide(arr,0,n-1));
	}
	public static int dis(Node o1,Node o2)//�� ��尣�� �Ÿ�
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
	public static int divide(ArrayList<Node> arr,int start,int end)//2���� ��Ű�� 
	{
		int n=end-start+1;//start���� end index���� ���� ����
		if(n<=3)//3�� ���϶�� bruteforce�Լ��� 
		{
			return bruteforce(arr,start,end);
		}
		int mid=(start+end)/2;
		int d=Math.min(divide(arr,start,mid), divide(arr,mid+1,end));
		//mid�� �������� ���� �׷�� ������ �׷쿡�� ���� ª�� �Ÿ� d���ϱ�
		
		
		//�߾Ӽ��� �������� �������� d �Ÿ� �̳��� ������ ���� ���
		//y��ǥ �������� �������� ����
		ArrayList<temp_Node> temp=new ArrayList<>();//�߾Ӽ��� �������� d�ȿ� ������ ���鸸 ���� �ӽ� arrayList
		for(int i=start;i<=end;i++)
		{
			int t=arr.get(mid).x-arr.get(i).x;
			if(t*t<d)
			{
				temp.add(new temp_Node(arr.get(i).x,arr.get(i).y));
			}
		}
		Collections.sort(temp);//y��ǥ ������������ ����
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
