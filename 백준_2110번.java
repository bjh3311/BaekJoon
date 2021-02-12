import java.util.Arrays;
import java.io.*;
public class 백준_2110번 {
	public static long[] arr;
	public static long result=0;
	public static long count=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
        int C=Integer.parseInt(s[1]);
		arr=new long[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);//이분 탐색을위한 정렬
		if(C==2)
		{
			result=arr[N-1]-arr[0];
		    System.out.println(result);
		    return;
		}//공유기의 개수가 2개이면 맨끝과 앞에 설치하고 프로그램 종료
		long left=1;
		long right=arr[N-1]-arr[0];
		long mid;
		while(left<=right)
		{
			count=1;//무조건 맨 앞에 설치하고 시작한다
			mid=(left+right)/2;
			long last=arr[0]+mid;
			for(int i=1;i<N;i++)
			{
				if(arr[i]>=last)
				{
					last=arr[i]+mid;
					count++;
				}     
			}
			if(count>=C)
			{
				result=Math.max(result, mid);
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
			count=0;
		}
		System.out.println(result);
		br.close();

	}
}