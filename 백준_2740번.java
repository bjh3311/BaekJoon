import java.io.*;
public class น้มุ_2740น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] arr=new int[N][M];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		s=br.readLine().split(" ");
		M=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		int[][] arr_2=new int[M][K];
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<K;j++)
			{
				arr_2[i][j]=Integer.parseInt(s[j]);
			}
		}
		int[][] result=new int[N][K];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<K;j++)
			{
				for(int l=0;l<M;l++)
				{
					result[i][j]+=arr[i][l]*arr_2[l][j];
				}
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<K;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}

	}

}
