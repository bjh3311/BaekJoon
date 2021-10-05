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
public class 알고리즘_최근접점쌍 {

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
		merge_sort(arr);//x좌표 기준으로 오름차순 정렬
		System.out.println(Math.sqrt(divide(arr,0,N-1)));
		
		
	}
	private static Node[] sorted;
	public static void merge_sort(Node[] a)
	{
		sorted=new Node[a.length];
		merge_sort(a,0,a.length-1);
		sorted=null;
	}
	public static int dis(Node o1,Node o2)//두 노드간의 거리
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
		}//left==right이면 더 이상 쪼갤 수 없으므로 return 한다.
		
		int mid=(left+right)/2;//절반 위치
		merge_sort(a,left,mid);
		merge_sort(a,mid+1,right);//계속 2분할하면서 나눈다
		merge(a,left,mid,right);//병합하는 과정이다.
	}
	public static int divide(Node[] arr,int start,int end)
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
		Node[] temp=new Node[N];//중앙선을 기준으로 d안에 들어오는 점들만 넣을 임시 arrayList
		for(int i=start;i<=end;i++)
		{
			int t=arr[mid].x-arr[i].x;
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
	private static void merge(Node[] a, int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
		int idx = left;		// 채워넣을 배열의 인덱스
		
		
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
