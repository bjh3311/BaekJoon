import java.util.*;
import java.io.*;
public class น้มุ_17299น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		Stack<Integer> count=new Stack<Integer>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
		{
			int a=Integer.parseInt(s[i]);
			if(!map.containsKey(a))
			{
				map.put(a, 1);
			}
			else
			{
				map.put(a, map.get(a)+1);
			}
		}
		int[] arr=new int[N];
		Arrays.fill(arr, -1);
		for(int i=0;i<N;i++)
		{
			if(count.isEmpty())
			{
				count.push(i);
			}
			else
			{
				while(!count.isEmpty())
				{
					if(map.get(Integer.parseInt(s[count.peek()]))<map.get(Integer.parseInt(s[i])))
					{
						int temp=count.pop();
						arr[temp]=Integer.parseInt(s[i]);
					}
					else
					{
						break;
					}
				}
				count.push(i);
				
			}
		}
		for(int a:arr )
		{
			sb.append(a+" ");
		}
		System.out.print(sb.toString());
	}

}
