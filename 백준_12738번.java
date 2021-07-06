import java.util.*;
import java.io.*;
public class น้มุ_12738น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(Integer.MIN_VALUE);
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(s[i]);
			int size=arr.size();
			if(a>arr.get(size-1))
			{
				arr.add(a);
			}
			else
			{
				int left=0;
				int right=size-1;
				int index=0;
				while(left<=right)
				{
					int mid=(left+right)/2;
					if(arr.get(mid)>=a)
					{
						right=mid-1;
						index=mid;
					}
					else
					{
						left=mid+1;
					}
				}
				arr.set(index, a);
			}
		}
		System.out.println(arr.size()-1);

	}

}
