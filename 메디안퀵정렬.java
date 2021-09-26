import java.util.*;
import java.io.*;
public class �޵�������� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		MedianQuickSort(arr,0,arr.length-1);
		for(int a:arr)
		{
			System.out.println(a);
		}
	}
	public static void MedianQuickSort(int[] arr,int front,int rear)
	{
		int i, j, pivot, mid = front+(rear-front)/2; //�߰� �ε���
		threeSort(arr, front, mid, rear); //3�� �켱����
	    /* ������ ����� 3�� �ʰ��� ��쿡�� �Ʒ��� ����Ʈ ����
	       3�� �����̸� threeSort�� ���� �ѹ��� ������ ������ ���� */
		if(rear-front+1>3)
		{ //�� �Ʒ��� �Ϲ� ����Ʈ �κа� ����
			pivot = arr[mid];
			swap(arr, mid, rear-1);
			i = front; //�Ǿ��� �̹� ���ĵǾ������Ƿ� front-1�� �ƴ� front���� ����
			j = rear-1;	//�ǵڴ� �̹� ���ĵǾ������Ƿ� rear�� �ƴ� rear-1���� ����
			while(true){
				while(arr[++i]<pivot && i<rear);
				while(arr[--j]>pivot && front<j);
				if(i>=j) break;
				swap(arr, i, j);
			}
			swap(arr, i, rear-1);
			MedianQuickSort(arr, front, i-1);
			MedianQuickSort(arr, i+1, rear);
		}
	}
	public static void threeSort(int[] arr,int start,int mid,int end)
	{
		if(arr[start]>arr[mid])
		{
			swap(arr,start,mid);
		}
		if(arr[mid]>arr[end])
		{
			swap(arr,mid,end);
		}
		if(arr[start]>arr[mid])
		{
			swap(arr,start,mid);
		}
	}
	public static void swap(int[] arr,int a,int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

}
