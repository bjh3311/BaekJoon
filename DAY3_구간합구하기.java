import java.util.*;
import java.io.*;
public class DAY3_구간합구하기 {

	public static long[] indexTree;
	public static long N;
	public static long Depth;
	public static long startIndex;
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		long M=Integer.parseInt(s[1]);
		long K=Integer.parseInt(s[2]);       
		Depth=0;
		while(Math.pow(2, Depth)<N)
		{
			Depth++;
		}//리프 노드의 개수를 구해줘야한다
		indexTree=new long[(int)Math.pow(2, Depth+1)];//트리의 크기이다
		startIndex=(long)Math.pow(2, Depth);
		int temp=(int)startIndex;
		for(int i=0;i<N;i++)
		{
			long value=Long.parseLong(br.readLine());
			indexTree[temp]=value;
			temp++;
		}//데이터값 입력
		preorder(1);//1번부터 갱신시켜준다 초기값 설정 완료
		for(int i=0;i<M+K;i++)
		{
			s=br.readLine().split(" ");
			long a=Long.parseLong(s[0]);
			long b=Long.parseLong(s[1]);
			long c=Long.parseLong(s[2]);
			if(a==1)//값 갱신
			{
				Update(b,c);
			}
			else//구간 합 구하기
			{
				query(b,c);
			}
		}	
		System.out.println(sb.toString());
	}
	public static long preorder(int index)
	{
		if(index>=Math.pow(2, Depth)+N)
		{
			return 0;
		}
		if(indexTree[index]==0)
		{
			long temp=0;
			temp=temp+preorder(index*2);
			temp=temp+preorder((index*2)+1);
			indexTree[index]=temp;
			return temp;
		}
		else
		{
			return indexTree[index];
		}
	}
	public static void Update(long b,long c)
	{
		int target=(int)(startIndex+b-1);
		long dif;
		if(indexTree[target]==c)
		{
			return;
		}
		else
		{
			dif=c-indexTree[target];
			indexTree[target]=c;
		}
		target=target/2;
		while(target!=0)//부모노드를 계속 갱신시켜준다
		{
			indexTree[target]=indexTree[target]+dif;
			target=target/2;
		}
	}
	public static void query(long b,long c)
	{
		long start=b+startIndex-1;
		long end=c+startIndex-1;
		long temp=0;
		while(start<=end)
		{
			if(start%2==1)//start가 홀수일경우
			{
				temp=temp+indexTree[(int)start];
				start=(start+1)/2;
			}
			else
			{
				start=start/2;
			}
			if(end%2==0)//end가 짝수일경우
			{
				temp=temp+indexTree[(int)end];
				end=(end-1)/2;
			}
			else
			{
				end=end/2;
			}
		}
		sb.append(temp+"\n");
	}
}
