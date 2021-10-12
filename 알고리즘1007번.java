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
public class 알고리즘1007번 {

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
		merge_sort(arr);//간선의 가중치 오름차순으로 정렬
		int result=0;
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;//처음에는 자기 자신 번호
		}
		for(int i=0;i<M;i++)
		{
			if(findParent(parent,arr[i].start,arr[i].end))//start와 end의 부모가 다르다면
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
	public static void unionParent(int[] arr,int a,int b)//a노드와 b노드의 집합을 합친다
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
		}//더 작은 수로 합친다
	}
	public static boolean findParent(int[] arr,int a,int b)
	{
		a=getParent(arr,a);
		b=getParent(arr,b);
		if(a==b)//부모가 같으면 false를 반환
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
		}//left==right이면 더 이상 쪼갤 수 없으므로 return 한다.
		
		int mid=(left+right)/2;//절반 위치
		merge_sort(a,left,mid);
		merge_sort(a,mid+1,right);//계속 2분할하면서 나눈다
		merge(a,left,mid,right);//병합하는 과정이다.
	}
	private static void merge(Node[] a, int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
		int idx = left;		// 채워넣을 배열의 인덱스
		
		
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
			}//왼쪽과 오른쪽 리스트를 계속 비교하면서 sorted배열에 입력한다.
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
		}//왼쪽이나 오른쪽이 먼저 끝났을때 나머지를 넣는 과정이다.
		for(int i = left; i <= right; i++) 
		{
			a[i] = sorted[i];
		}//새 배열을 기존배열에 복사
	}
}