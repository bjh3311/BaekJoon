import java.util.*;
import java.io.*;

public class 백준_2263번 {

	public static int N;
	public static int[] in,post,pre;
	public static int index=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		in=new int[N];
		post=new int[N];
		pre=new int[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			in[i]=Integer.parseInt(s[i]);
		}
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			post[i]=Integer.parseInt(s[i]);
		}
		PreOrder(0,N-1,0,N-1);
		for(int i=0;i<N;i++)
		{
			System.out.print(pre[i]+" ");
		}
	}
	public static void PreOrder(int is,int ie,int ps,int pe)
	{
		//is,ie는 인오더 시작, 끝 인덱스
		//ps,pe는 포스트오더 시작, 끝 인덱스
		if(is<=ie&&ps<=pe)
		{
			pre[index]=post[pe];
			index++;
			int pos = is;
			for(int i=is;i<=ie;i++)
			{
				if(in[i]==post[pe])//인오더에서 해당 루트노드 찾기
				{
					pos=i;
					break;
				}
			}
			PreOrder(is,pos-1,ps,ps+pos-is-1);
			PreOrder(pos+1,ie,ps+pos-is,pe-1);
		}
	}
}