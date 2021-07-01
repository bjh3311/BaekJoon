import java.util.*;
import java.io.*;
public class 백준_3020번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int H=Integer.parseInt(s[1]);
		int[] bot=new int[H+1];
		int[] top=new int[H+1];
		for(int i=0;i<N/2;i++)
		{
			int a=Integer.parseInt(br.readLine());
			int b=Integer.parseInt(br.readLine());
			bot[a]++;
			top[H-b+1]++;
		}
		for(int i=H-1;i>=1;i--)//i번째 구간의 석순개수 구하기
		{
			bot[i]=bot[i]+bot[i+1];
		}
		for(int i=1;i<=H;i++)
		{
			top[i]=top[i]+top[i-1];
		}
		int min=N;
		int cnt=0;
		for(int i=1;i<=H;i++)
		{
			int obs=bot[i]+top[i];//i번째 구간에서의 장애물 수
			if(obs<min)
			{
				min=obs;
				cnt=1;
			}
			else if(obs==min)
			{
				cnt++;
			}
		}
		System.out.println(min+" "+cnt);
		
	}
}
