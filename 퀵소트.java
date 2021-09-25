import java.util.*;
import java.io.*;
public class Äü¼ÒÆ® {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		QuickSort(arr,0,arr.length-1);
		for(int a:arr)
		{
			System.out.println(a+" ");
		}

	}
	public static void QuickSort(int[] arr,int start,int end)
	{
		int left=start;
		int right=end;
		int pivot=arr[(start+end)/2];
		while(left<=right)
		{
			while(arr[left]<pivot)
			{
				left++;
			}
			while(arr[right]>pivot)
			{
				right--;
			}
			if(left<=right)
			{
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		if(start<right)
		{
			QuickSort(arr,start,right);
		}
		if(end>left)
		{
			QuickSort(arr,left,end);
		}
	}

}
