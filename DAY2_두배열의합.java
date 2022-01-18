import java.util.*;
import java.io.*;
public class DAY2_두배열의합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		int[] arr_A=new int[n];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<n;i++)
		{
			arr_A[i]=Integer.parseInt(s[i]);
		}
		int m=Integer.parseInt(br.readLine());
		int[] arr_B=new int[m];
		s=br.readLine().split(" ");
		for(int i=0;i<m;i++)
		{
			arr_B[i]=Integer.parseInt(s[i]);
		}
		ArrayList<Integer> sub_A=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			int sum=arr_A[i];
			sub_A.add(sum);
			for(int j=i+1;j<n;j++)
			{
				sum=sum+arr_A[j];
				sub_A.add(sum);
			}
		}
		ArrayList<Integer> sub_B=new ArrayList<Integer>();
		for(int i=0;i<m;i++)
		{
			int sum=arr_B[i];
			sub_B.add(sum);
			for(int j=i+1;j<m;j++)
			{
				sum=sum+arr_B[j];
				sub_B.add(sum);
			}
		}
		Collections.sort(sub_A);
		Collections.sort(sub_B);
		int low=0;
		int high=sub_B.size()-1;
		long result=0;
		while(true)
		{
			long currentA=sub_A.get(low);
			long currentB=sub_B.get(high);
			long sum=currentA+currentB;
			if(sum==T)
			{
				long countA=0;
				long countB=0;
				while(low<sub_A.size()&&sub_A.get(low)==currentA)
				{
					countA++;
					low++;
				}
				while(high>=0&&sub_B.get(high)==currentB)
				{
					countB++;
					high--;
				}
				result+=countA*countB;
			}
			else if(sum<T)
			{
				low++;
			}
			else if(sum>T)
			{
				high--;
			}
			if(high<0||low>=sub_A.size())
			{
				break;
			}
		}
		System.out.println(result);
	}
}
