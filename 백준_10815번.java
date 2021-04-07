import java.util.*;
import java.io.*;
public class 백준_10815번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int[] arr=new int[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		int M=Integer.parseInt(br.readLine());
		int[] arr2=new int[M];
		s=br.readLine().split(" ");
		for(int i=0;i<M;i++)
		{
			arr2[i]=Integer.parseInt(s[i]);
		}
		for(int i=0;i<M;i++)
		{
			int key=arr2[i];//찾아야 될 값
			int left=0;
			int right=N-1;
			int mid;
			int index=1;
			while(left<=right)
			{
				mid=(left+right)/2;
				if(arr[mid]>key)
				{
					right=mid-1;
				}
				else if(arr[mid]<key)
				{
					left=mid+1;
				}
				else
				{
					index=0;
					sb.append("1 ");
					break;
				}
			}
			if(index==1)
			{
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());

	}

}
