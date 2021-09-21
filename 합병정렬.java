package �պ�����;
import java.util.*;
import java.io.*;
public class �պ����� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		merge_sort(arr);
		for(int i=0;i<N;i++)
		{
			System.out.print(arr[i]+" ");
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
		
		merge(a,left,mid,right);
	}
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// ���� �κи���Ʈ ������
		int r = mid + 1;	// ������ �κи���Ʈ�� ������ 
		int idx = left;		// ä������ �迭�� �ε���
		
		
		while(l <= mid && r <= right) {
			/*
			 *  ���� �κи���Ʈ l��° ���Ұ� ������ �κи���Ʈ r��° ���Һ��� �۰ų� ���� ���
			 *  ������ l��° ���Ҹ� �� �迭�� �ְ� l�� idx�� 1 ������Ų��.
			 */
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			/*
			 *  ������ �κи���Ʈ r��° ���Ұ� ���� �κи���Ʈ l��° ���Һ��� �۰ų� ���� ���
			 *  �������� r��° ���Ҹ� �� �迭�� �ְ� r�� idx�� 1 ������Ų��.
			 */
			else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		/*
		 * ���� �κи���Ʈ�� ���� ��� �� �迭�� ä������ ��� (l > mid)
		 * = ������ �κи���Ʈ ���Ұ� ���� �������� ���
		 * ������ �κи���Ʈ�� ������ ���ҵ��� �� �迭�� ä���ش�.
		 */
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		/*
		 * ������ �κи���Ʈ�� ���� ��� �� �迭�� ä������ ��� (r > right)
		 * = ���� �κи���Ʈ ���Ұ� ���� �������� ���
		 * ���� �κи���Ʈ�� ������ ���ҵ��� �� �迭�� ä���ش�.
		 */
		else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		
		/*
		 * ���ĵ� �� �迭�� ������ �迭�� �����Ͽ� �Ű��ش�.
		 */
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}

}
