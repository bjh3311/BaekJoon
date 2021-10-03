import java.util.*;
import java.io.*;
public class น้มุ_13164น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		int[] arr=new int[N];
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		int[] dif=new int[N-1];
		for(int i=0;i<N-1;i++)
		{
			dif[i]=arr[i+1]-arr[i];
		}
		Arrays.sort(dif);
		int result=0;
		for(int i=0;i<N-K;i++)
		{
			result+=dif[i];
		}
		System.out.println(result);
	}
}
