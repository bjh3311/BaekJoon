import java.util.*;
import java.io.*;
public class น้มุ_11003น๘ {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		int[] arr=new int[N];
		Deque<Integer> q=new ArrayDeque<>();
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
		{
			int num=arr[i];
			while(!q.isEmpty()&&arr[q.getLast()]>num)
			{
				q.removeLast();
			}
			q.offerLast(i);
			if(q.getFirst()<i-L+1)
			{
				q.removeFirst();
			}
			sb.append(arr[q.peekFirst()]+" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
