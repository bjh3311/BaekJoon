import java.util.*;
import java.io.*;
public class 백준_17619번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int Q=Integer.parseInt(s[1]);
		StringBuilder sb=new StringBuilder();
		int[] result=new int[100001];
		int[][] index=new int[N][3];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			index[i][0]=Integer.parseInt(s[0]);
			index[i][1]=Integer.parseInt(s[1]);
			index[i][2]=i+1;//몇번통나무인지 표시
		}
		Arrays.sort(index,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2)
			{
				return o1[0]-o2[0];
			}
		});//x1기준으로 오름차순 정렬
		int cur=1;
		int left=index[0][0];
		int right=index[0][1];
		result[index[0][2]]=1;//첫번째 통나무
		for(int i=1;i<N;i++)
		{
			if(index[i][0]>right)
			{
				cur++;
				left=index[i][0];
				right=index[i][1];
				result[index[i][2]]=cur;
			}
			else if(index[i][0]<=right&&index[i][1]<=right)
			{
				result[index[i][2]]=cur;
			}
			else if(index[i][0]<=right&&index[i][1]>right)
			{
				result[index[i][2]]=cur;
				right=index[i][1];
			}
		}
		for(int i=0;i<Q;i++)
		{
			s=br.readLine().split(" ");
			if(result[Integer.parseInt(s[0])]==result[Integer.parseInt(s[1])])
			{
				sb.append("1\n");
			}
			else
			{
				sb.append("0\n");
			}
		}//질문의 대답을 sb에 저장
		System.out.print(sb.toString());
	}
}
