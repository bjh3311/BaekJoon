import java.util.*;
import java.io.*;

public class 백준_7983번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] time=new int[n][2];
		for(int i=0;i<n;i++)
		{
			String[] s=br.readLine().split(" ");
			time[i][0]=Integer.parseInt(s[0]);
			time[i][1]=Integer.parseInt(s[1]);
		}
		int max=0;
		Arrays.sort(time,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2)
			{
				return o1[1]-o2[1];
			}
		});//두번째 인덱스를 기준으로 정렬
		max=0;

		for(int i=n-1;i>0;i--)
		{
			int a=time[i][1]-time[i][0];
			if(a>time[i-1][1])
			{
				
			}
			else
			{
				time[i-1][1]=a;
			}
		}
		max=Math.max(max, time[0][1]-time[0][0]);
		System.out.println(max);
		
	}

}