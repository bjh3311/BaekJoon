import java.util.*;
import java.io.*;
class Node
{
	int start;
	int end;
	int w;
	public Node(int start,int end,int w)
	{
		this.start=start;
		this.end=end;
		this.w=w;
	}
}
public class �˰���1007�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		Node[] arr=new Node[M];
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			arr[i]=new Node(start,end,w);
		}
		merge_sort(arr);//������ ����ġ ������������ ����
		int result=0;
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;//ó������ �ڱ� �ڽ� ��ȣ
		}
		for(int i=0;i<M;i++)
		{
			if(findParent(parent,arr[i].start,arr[i].end))//start�� end�� �θ� �ٸ��ٸ�
			{
				result+=arr[i].w;
				unionParent(parent,arr[i].start,arr[i].end);
			}
		}
		System.out.println(result);
	}
	public static int getParent(int[] arr,int x)
	{
		if(arr[x]==x)
		{
			return x;
		}
		else
		{
			return arr[x]=getParent(arr,arr[x]);
		}
	}
	public static void unionParent(int[] arr,int a,int b)//a���� b����� ������ ��ģ��
	{
		a=getParent(arr,a);
		b=getParent(arr,b);
		if(a<b)
		{
			arr[b]=a;
		}
		else
		{
			arr[a]=b;
		}//�� ���� ���� ��ģ��
	}
	public static boolean findParent(int[] arr,int a,int b)
	{
		a=getParent(arr,a);
		b=getParent(arr,b);
		if(a==b)//�θ� ������ false�� ��ȯ
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static int[] parent;
	private static Node[] sorted;
	public static void merge_sort(Node[] a)
	{
		sorted=new Node[a.length];
		merge_sort(a,0,a.length-1);
		sorted=null;
		
	}
	private static void merge_sort(Node[] a,int left,int right)
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
	private static void merge(Node[] a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
		while(l <= mid && r <= right) {
			if(a[l].w <= a[r].w) 
			{
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			else 
			{
				sorted[idx] = a[r];
				idx++;
				r++;
			}//���ʰ� ������ ����Ʈ�� ��� ���ϸ鼭 sorted�迭�� �Է��Ѵ�.
		}
		if(l > mid) {
			while(r <= right) 
			{
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		else {
			while(l <= mid)
			{
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}//�����̳� �������� ���� �������� �������� �ִ� �����̴�.
		for(int i = left; i <= right; i++) 
		{
			a[i] = sorted[i];
		}//�� �迭�� �����迭�� ����
	}
}