package �պ�����;
import java.util.*;
import java.io.*;
public class �պ����� {

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
		}//left==right�̸� �� �̻� �ɰ� �� �����Ƿ� return �Ѵ�.
		
		int mid=(left+right)/2;//���� ��ġ
		merge_sort(a,left,mid);
		merge_sort(a,mid+1,right);//��� 2�����ϸ鼭 ������
		merge(a,left,mid,right);//�����ϴ� �����̴�.
	}
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
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
