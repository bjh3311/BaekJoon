import java.util.*;
import java.io.*;
public class 메디안퀵정렬 {

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
		int i, j, pivot, mid = front+(rear-front)/2; //중간 인덱스
		threeSort(arr, front, mid, rear); //3개 우선정렬
	    /* 정렬할 대상이 3개 초과인 경우에만 아래의 퀵소트 수행
	       3개 이하이면 threeSort를 통해 한번에 정렬이 끝나기 때문 */
		if(rear-front+1>3)
		{ //이 아래는 일반 퀵소트 부분과 동일
			pivot = arr[mid];
			swap(arr, mid, rear-1);
			i = front; //맨앞은 이미 정렬되어있으므로 front-1이 아닌 front부터 시작
			j = rear-1;	//맨뒤는 이미 정렬되어있으므로 rear가 아닌 rear-1부터 시작
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
