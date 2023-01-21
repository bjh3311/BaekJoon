import java.util.*;
import java.io.*;


public class 백준_16975번 {

	public static long[] tree;
	public static long temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		temp=0;
		while(Math.pow(2, temp)<N+1)
		{
			temp++;
		}
		tree=new long[(int)Math.pow(2, temp+1)];//트리는 초기에 전부 0으로 설정되어 있다.
		String[] s=br.readLine().split(" ");
		for(int i=1;i<=N;i++)//수열
		{
			arr[i]=Integer.parseInt(s[i-1]);
		}	
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		while(M>0)
		{
			s=br.readLine().split(" ");
			if(Integer.parseInt(s[0])==1)//업데이트
			{
				int i=Integer.parseInt(s[1]);
				int j=Integer.parseInt(s[2]);
				int k=Integer.parseInt(s[3]);
				Update(i,j,k);
			}
			else
			{
				int i=Integer.parseInt(s[1]);
				sb.append(sum(i)+arr[i]+"\n");
			}
			M--;
		}
		System.out.println(sb.toString());
	}
	public static void Update(int i,int j,int k)
	{
		  i=i+(int)Math.pow(2, temp)-1;
		  j=j+(int)Math.pow(2, temp);
		  tree[i]=tree[i]+k;//해당 인덱스 바꿔준다
		  while(i!=0)//부모 노드 갱신
		  {
			  i=i/2;
			  tree[i]=tree[i]+k;  
		  }
		  tree[j]=tree[j]-k;
		  while(j!=0)
		  {
			  j=j/2;
			  tree[j]=tree[j]-k;
		  }
	}
	public static long sum(int i)
	{
		int end=i+(int)Math.pow(2, temp)-1;//끝 인덱스
		int start=(int)Math.pow(2, temp);//시작 인덱스
		if(start==end)
		{
			return tree[start];
		}
		long result=0;
		while(true)
		{
			if(start%2==0)
			{
				start=start/2;
			}
			else
			{
				result=result+tree[start];
				start=start+1;
				start=start/2;
			}
			if(end%2==1)
			{
				end=end/2;
			}
			else
			{
				result=result+tree[end];
				end=end-1;
				end=end/2;
			}
			if(start==end)
			{
				return result+tree[start];
			}
		}
	}

}
