import java.util.*;
import java.io.*;
public class 백준_15922번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
	    int[][] arr=new int[N][2];
		for(int i=0;i<N;i++)
		{
			String[] s=br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(s[0]);
			arr[i][1]=Integer.parseInt(s[1]);
		}
		int result=0;//정답
		int left=arr[0][0];
		int right=arr[0][1];
		for(int i=1;i<N;i++)
		{
			if(arr[i][1]<=right)
			{
				
			}
			else if(arr[i][0]<=right)
			{
				right=arr[i][1];
			}
			else
			{
				result+=Math.abs(right-left);
				left=arr[i][0];
				right=arr[i][1];

			}		
		}
		result+=Math.abs(right-left);
		System.out.println(result);
	}
}
