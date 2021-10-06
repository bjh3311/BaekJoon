import java.util.*;
import java.io.*;
class Node
{
	long x;
	long y;
	public Node(long x,long y)
	{
		this.x=x;
		this.y=y;
	}
}
public class �˰���_�ֱ������� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s;
		ArrayList<Node> arr=new ArrayList<Node>();
		long x;
		long y;
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(", ");
			x=Long.parseLong(s[0]);
			y=Long.parseLong(s[1]);
			arr.add(new Node(x,y));
		}
		System.gc();
		merge_sort(arr);//x��ǥ ������������ ����
		System.out.printf("%.6f",Math.sqrt(divide(arr,0,n-1)));
	}
	public static long dis(Node o1,Node o2)//�� ��尣�� �Ÿ�
	{
		long x=o1.x-o2.x;
		long y=o1.y-o2.y;
		return (x*x)+(y*y);
	}
	public static long bruteforce(ArrayList<Node> arr,int start,int end)
	{
		long minDist=Long.MAX_VALUE;
		for(int i=start;i<end;i++)
		{
			for(int j=i+1;j<=end;j++)
			{
				long k=dis(arr.get(i),arr.get(j));
				minDist=Math.min(minDist, k);
			}
		}
		return minDist;
	}
	public static long divide(ArrayList<Node> arr,int start,int end)//2���� ��Ű�� 
	{
		int n=end-start+1;//start���� end index���� ���� ����
		if(n<=3)//3�� ���϶�� bruteforce�Լ��� 
		{
			return bruteforce(arr,start,end);
		}
		int mid=(start+end)/2;
		long d=Math.min(divide(arr,start,mid), divide(arr,mid+1,end));
		//mid�� �������� ���� �׷�� ������ �׷쿡�� ���� ª�� �Ÿ� d���ϱ�
		
		
		//�߾Ӽ��� �������� �������� d �Ÿ� �̳��� ������ ���� ���
		//y��ǥ �������� �������� ����
		ArrayList<Node> temp=new ArrayList<>();//�߾Ӽ��� �������� d�ȿ� ������ ���鸸 ���� �ӽ� arrayList
		for(int i=start;i<=end;i++)
		{
			long t=arr.get(mid).x-arr.get(i).x;
			if(t*t<d)
			{
				temp.add(new Node(arr.get(i).x,arr.get(i).y));
			}
		}
		merge_sort2(temp);//y��ǥ ������������ ����
		for(int i=0;i<temp.size();i++)
		{
			for(int j=i+1;j<temp.size();j++)
			{
				long t=temp.get(j).y-temp.get(i).y;
				
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
		temp=null;
		return d;
	}
	private static void merge_sort2(ArrayList<Node> a,int left,int right)//y��ǥ ����
	{
		
		if(left==right)
		{
			return;
		}//left==right�̸� �� �̻� �ɰ� �� �����Ƿ� return �Ѵ�.
		
		int mid=(left+right)/2;//���� ��ġ
		merge_sort2(a,left,mid);
		merge_sort2(a,mid+1,right);//��� 2�����ϸ鼭 ������
		merge2(a,left,mid,right);//�����ϴ� �����̴�.
	}
	public static void merge_sort2(ArrayList<Node> a)
	{
		sorted=new Node[a.size()];
		merge_sort2(a,0,a.size()-1);
		sorted=null;
	}
	private static void merge2(ArrayList<Node> a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
		while(l <= mid && r <= right) {
			if(a.get(l).y <= a.get(r).y) 
			{
				sorted[idx] = a.get(l);
				idx++;
				l++;
			}
			else 
			{
				sorted[idx] = a.get(r);
				idx++;
				r++;
			}//���ʰ� ������ ����Ʈ�� ��� ���ϸ鼭 sorted�迭�� �Է��Ѵ�.
		}
		if(l > mid) {
			while(r <= right) 
			{
				sorted[idx] = a.get(r);
				idx++;
				r++;
			}
		}
		else {
			while(l <= mid)
			{
				sorted[idx] = a.get(l);
				idx++;
				l++;
			}
		}//�����̳� �������� ���� �������� �������� �ִ� �����̴�.
		for(int i = left; i <= right; i++) 
		{
			a.set(i, sorted[i]);
		}//�� �迭�� �����迭�� ����
	}
	private static void merge_sort(ArrayList<Node> a,int left,int right)//x��ǥ ����
	{
		
		if(left==right)
		{
			return;
		}//left==right�̸� �� �̻� �ɰ� �� �����Ƿ� return �Ѵ�.
		
		int mid=(left+right)/2;//���� ��ġ
		merge_sort(a,left,mid);
		merge_sort(a,mid+1,right);//��� 2�����ϸ鼭 ������
		merge(a,left,mid,right);//�����ϴ� �����̴�.
	}
	public static void merge_sort(ArrayList<Node> a)
	{
		sorted=new Node[a.size()];
		merge_sort(a,0,a.size()-1);
		sorted=null;
	}
	private static void merge(ArrayList<Node> a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
		while(l <= mid && r <= right) {
			if(a.get(l).x <= a.get(r).x) 
			{
				sorted[idx] = a.get(l);
				idx++;
				l++;
			}
			else 
			{
				sorted[idx] = a.get(r);
				idx++;
				r++;
			}//���ʰ� ������ ����Ʈ�� ��� ���ϸ鼭 sorted�迭�� �Է��Ѵ�.
		}
		if(l > mid) {
			while(r <= right) 
			{
				sorted[idx] = a.get(r);
				idx++;
				r++;
			}
		}
		else {
			while(l <= mid)
			{
				sorted[idx] = a.get(l);
				idx++;
				l++;
			}
		}//�����̳� �������� ���� �������� �������� �ִ� �����̴�.
		for(int i = left; i <= right; i++) 
		{
			a.set(i, sorted[i]);
		}//�� �迭�� �����迭�� ����
	}
	private static Node[] sorted;
}