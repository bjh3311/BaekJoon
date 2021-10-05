import java.io.*;
class Node
{
	int x;
	int y;
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
public class �˰���_�ֱ������� {

	public static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String[] s;
		Node[] arr=new Node[N];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(", ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			arr[i]=new Node(x,y);
		}
		merge_sort(arr);//x��ǥ �������� �������� ����
		System.out.println(Math.sqrt(divide(arr,0,N-1)));
		
		
	}
	private static Node[] sorted;
	public static void merge_sort(Node[] a)
	{
		sorted=new Node[a.length];
		merge_sort(a,0,a.length-1);
		sorted=null;
	}
	public static int dis(Node o1,Node o2)//�� ��尣�� �Ÿ�
	{
		int x=o1.x-o2.x;
		int y=o1.y-o2.y;
		return (x*x)+(y*y);
	}
	public static int bruteforce(Node[] arr,int start,int end)
	{
		int minDist=Integer.MAX_VALUE;
		for(int i=start;i<end;i++)
		{
			for(int j=i+1;j<=end;j++)
			{
				int k=dis(arr[i],arr[j]);
				minDist=Math.min(minDist, k);
						
			}
		}
		return minDist;
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
	public static int divide(Node[] arr,int start,int end)
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
		Node[] temp=new Node[N];//�߾Ӽ��� �������� d�ȿ� ������ ���鸸 ���� �ӽ� arrayList
		for(int i=start;i<=end;i++)
		{
			int t=arr[mid].x-arr[i].x;
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
	private static void merge(Node[] a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
		while(l <= mid && r <= right) {
			if(a[l].x <= a[r].x) 
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
