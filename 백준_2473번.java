import java.util.*;
import java.io.*;
public class น้มุ_2473น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long[] arr=new long[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Long.parseLong(s[i]);
		}
		Arrays.sort(arr);
		int left=0;
		int right=N-1;
		long answer1=0;
		long answer2=0;
		long answer3=0;
		long result=Long.MAX_VALUE;
		for(int i=0;i<N-2;i++)
		{
			left=i+1;
			right=N-1;
			long sum;
			while(left<right)
			{			
				if(result>Math.abs(arr[left]+arr[right]+arr[i]))
		    	{
		    		result=Math.abs(arr[left]+arr[right]+arr[i]);
		    		answer1=arr[left];
		    		answer2=arr[right];
		    		answer3=arr[i];
		    	}
		    	if(Math.abs(arr[left]+arr[right-1]+arr[i])<Math.abs(arr[i]+arr[left+1]+arr[right]))
		    	{
		    		right--;
		    	}
		    	else
		    	{
		    		left++;
		    	}
			}
		}
		long[] temp=new long[3];
		temp[0]=answer1;
		temp[1]=answer2;
		temp[2]=answer3;
		Arrays.sort(temp);
		for(long a:temp)
		{
			System.out.print(a+" ");
		}

	}

}
