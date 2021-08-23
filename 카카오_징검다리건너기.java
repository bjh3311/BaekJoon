import java.util.*;
import java.io.*;
public class 카카오_징검다리건너기 {

	public static List<Integer> list;
	public static int k;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		k=Integer.parseInt(br.readLine());
		list=new LinkedList<Integer>();
		for(int i=0;i<s.length;i++)
		{
			list.add(Integer.parseInt(s[i]));
		}
		int min=1;
		int max=200000000;
		int ans=0;
		while(min<=max)
		{
			int mid=(min+max)/2;
			if(cross(list,mid,k))
			{
				min=mid+1;
				ans=Math.max(ans, mid);
			}
			else
			{
				max=mid-1;
			}
		}
		System.out.println(ans);
			
	}
	public static boolean cross(List<Integer> list,int mid,int k)
	{
		int skip=0;
		for(int stone: list)
		{
			if(mid<=stone)
			{
				skip=0;
			}
			else if(mid>stone)
			{
				skip++;
			}
			if(skip==k)
			{
				return false;
			}
		}
		return true;
	}

}
