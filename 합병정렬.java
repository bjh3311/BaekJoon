package 합병정렬;
import java.util.*;
import java.io.*;
public class 합병정렬 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		merge_sort(arr);
		for(int i=0;i<N;i++)
		{
			System.out.println(arr[i]);
		}
	}
	private static int[] sorted;
	
	public static void merge_sort(int[] a)
	{
		sorted=new int[a.length];
		merge_sort(a,0,a.length-1);
		sorted=null;
		
	}
	private static void merge_sort(int[] a,int left,int right)
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
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
		int idx = left;		// 채워넣을 배열의 인덱스
		
		
		while(l <= mid && r <= right) {
			if(a[l] <= a[r]) 
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
