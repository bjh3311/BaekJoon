import java.util.*;
import java.io.*;
public class น้มุ_2470น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
	    String[] s=br.readLine().split(" ");
	    for(int i=0;i<N;i++)
	    {
	    	arr[i]=Integer.parseInt(s[i]);
	    }
	    Arrays.sort(arr);
	    int left=0;
	    int right=N-1;
	    long result=Integer.MAX_VALUE;
	    int answer1=0;
	    int answer2=0;
	    while(left<=right)
	    {
	    	if(result>Math.abs(arr[left]+arr[right]))
	    	{
	    		result=Math.abs(arr[left]+arr[right]);
	    		answer1=arr[left];
	    		answer2=arr[right];
	    	}
	    	if(Math.abs(arr[left]+arr[right-1])<Math.abs(arr[left+1]+arr[right]))
	    	{
	    		right--;
	    	}
	    	else
	    	{
	    		left++;
	    	}
	    }
	    System.out.print(answer1+" "+answer2);

	}

}
