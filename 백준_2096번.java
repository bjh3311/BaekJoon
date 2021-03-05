import java.util.*;
import java.io.*;
public class น้มุ_2096น๘ {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		// TODO Auto-generated method stub
		int[][] arr=new int[N][3];
		int[][] dp_max=new int[N][3];
		int[][] dp_min=new int[N][3];
		for(int i=0;i<N;i++)
		{
			String[] s=br.readLine().split(" ");
			for(int j=0;j<3;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<3;i++)
		{
			dp_max[0][i]=arr[0][i];
			dp_min[0][i]=arr[0][i];
		}
		for(int i=1;i<N;i++)
		{
			dp_max[i][0]=arr[i][0]+Math.max(dp_max[i-1][0], dp_max[i-1][1]);
			dp_max[i][1]=arr[i][1]+Math.max(Math.max(dp_max[i-1][0],dp_max[i-1][1] ), Math.max(dp_max[i-1][1], dp_max[i-1][2]));
			dp_max[i][2]=arr[i][2]+Math.max(dp_max[i-1][2], dp_max[i-1][1]);
			dp_min[i][0]=arr[i][0]+Math.min(dp_min[i-1][0], dp_min[i-1][1]);
			dp_min[i][1]=arr[i][1]+Math.min(Math.min(dp_min[i-1][0],dp_min[i-1][1] ), Math.min(dp_min[i-1][1], dp_min[i-1][2]));
			dp_min[i][2]=arr[i][2]+Math.min(dp_min[i-1][2], dp_min[i-1][1]);			
		}
		System.out.print(Math.max(Math.max(dp_max[N-1][0],dp_max[N-1][1] ), Math.max(dp_max[N-1][1], dp_max[N-1][2]))+" ");
		System.out.println(Math.min(Math.min(dp_min[N-1][0],dp_min[N-1][1] ), Math.min(dp_min[N-1][1], dp_min[N-1][2])));
	

	}

}
