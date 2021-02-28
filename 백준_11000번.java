import java.util.*;
import java.io.*;
public class 백준_11000번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		int[][] time=new int[N][2];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			time[i][0]=Integer.parseInt(s[0]);
			time[i][1]=Integer.parseInt(s[1]);
		}
		Arrays.sort(time,new Comparator<>(){
			public int compare(int[] o1,int[] o2)
			{
				if(o1[0]==o2[0])
				{
					return o1[1]-o2[1];
				}
				else
				{
					return o1[0]-o2[0];
				}
			}
		});//끝나는 시간을 기준으로 정렬
		for(int i=0;i<N;i++)
		{
			int end=time[i][1];
			if(!q.isEmpty()&&q.peek()<=time[i][0])
			{
				int a=q.poll();
			}		
			q.add(end);	
		}
		System.out.println(q.size());

	}

}
