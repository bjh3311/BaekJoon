import java.util.Arrays;
import java.util.HashMap;
import java.io.*;
public class 백준_10816번 {
	public static HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
	public static int[] arr;
	public static int binary(int left,int right,int num)
	{
		if(left>right)
		{
			return 0;
		}
		int mid=(left+right)/2;
	    if(arr[mid]==num)
	    {
	    	return 1;
	    }
	    else if(arr[mid]>num)
	    {
	    	return binary(left,mid-1,num);
	    }
	    else
	    {
	    	return binary(mid+1,right,num);
	    }
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(s[i]);
			arr[i]=a;
			if(map1.containsKey(a))
			{
				map1.put(a, map1.get(a)+1);
			}
			else
			{
				map1.put(a, 1);
			}
			
		}
		Arrays.sort(arr);//이분 탐색을위한 정렬
		int M=Integer.parseInt(br.readLine());
		int[] Sk=new int[M];
		 s=br.readLine().split(" ");
		for(int i=0;i<M;i++)
		{
			Sk[i]=Integer.parseInt(s[i]);
		}
		for(int i=0;i<M;i++)
		{
			if(binary(0,N-1,Sk[i])==1)
			{
				sb.append(map1.get(Sk[i])+" ");//찾았는데 있다면 hashmap을 참고해서 갯수출력
			}
			else
			{
				sb.append("0 ");//없다면 0
			}
		}
		System.out.println(sb.toString());
		br.close();

	}

}
