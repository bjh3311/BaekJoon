import java.util.*;
import java.io.*;
public class น้มุ_2212น๘ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		if(K>=N)
		{
			System.out.println(0);
			System.exit(0);
		}
		int[] arr=new int[N];
		Integer[] dif=new Integer[N-1];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(s[i]);
			arr[i]=a;
		}
		Arrays.sort(arr);
		for(int i=0;i<N-1;i++)
		{
			dif[i]=arr[i+1]-arr[i];
		}
		Arrays.sort(dif,Collections.reverseOrder());
		int sum=0;
		for(int i=K-1;i<N-1;i++)
		{
			sum+=dif[i];
		}
		System.out.println(sum);
	}

}
