import java.util.*;
import java.io.*;
public class 백준_10868번 {

	public static int count;
	public static int arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(s[0]);//총 갯수
		int M=Integer.parseInt(s[1]);
		int a;
		for(a=1;a<=N;a++)//세그먼트 트리의 크기를 정해준다
		{
			if(Math.pow(2, a)>=N)
			{
				break;
			}
		}
		count=(int)Math.pow(2, a+1)-1;
		arr=new int[count+1];//1번이 루트노드
		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i=0;i<N;i++)//각 값들 잎 노드에 입력
		{
			int value=Integer.parseInt(br.readLine());
			arr[(count/2)+1+i]=value;
		}
		preorder(1);
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0])+count/2;
			int end=Integer.parseInt(s[1])+count/2;
			sb.append(Segment(start,end)+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int preorder(int index)//초기 트리 생성
	{
		if(index>=(count/2)+1)
		{
			return arr[index];
		}
		arr[index]=Math.min(preorder(index*2), preorder((index*2)+1));
		return arr[index];
	}
	public static int Segment(int start,int end)
	{	
		int result=Integer.MAX_VALUE;
		while(start<=end)//start와 end의 인덱스를 맞춰준다
		{
			if(start%2==1)//start가 홀수라면
			{
				result=Math.min(arr[start], result);
				start=(start+1)/2;
			}
			else
			{
				start=start/2;
			}
			if(end%2==0)//end가 짝수라면
			{
				result=Math.min(arr[end], result);
				end=(end-1)/2;
			}
			else
			{
				end=end/2;
			}
		}
		return result;
	}
}
