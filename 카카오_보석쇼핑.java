import java.util.*;
import java.io.*;
class info implements Comparable<info>
{
	int left;
	int right;
	int length;
	public info(int left,int right,int length)
	{
		this.left=left;
		this.right=right;
		this.length=length;
	}
	public int compareTo(info o)
	{
		if(length==o.length)
		{
			return left-o.left;
		}
		else
		{
			return length-o.length;
		}
	}
}
public class 카카오_보석쇼핑 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		System.out.println(solution(s)[0]);
		System.out.println(solution(s)[1]);
		
	}
	public static int[] solution(String[] gems)
	{
		HashSet<String> set=new HashSet<String>();
		for(int i=0;i<gems.length;i++)
		{
			set.add(gems[i]);
		}
		ArrayList<String> arr=new ArrayList<String>();
		for(String temp:set)
		{
			arr.add(temp);
		}
		int left=1;
		int right=gems.length;
		int[] answer=new int[2];
		PriorityQueue<info> q=new PriorityQueue<info>();
		while(left<=right)
		{
			int mid=(left+right)/2;
			boolean ispossible=false;
			int result_left;
			int result_right;
			for(int i=0;i<=gems.length-mid;i++)
			{
				ArrayList<String> temp_arr=(ArrayList<String>)arr.clone();
				for(int j=0;j<mid;j++)
				{
					if(temp_arr.contains(gems[i+j]))
					{
						temp_arr.remove(gems[i+j]);
					}
				}
				if(temp_arr.size()==0)//해당 길이의 mid에서는 다 담았다.
				{
					q.add(new info(i,i+mid-1,mid));
					ispossible=true;
					break;
				}
			}
			if(ispossible)//가능했다는 소리이므로 길이를 더 줄여야 한다.
			{
				right=mid-1;
			}
			else//불가능했다는 소리이므로 길이를 더 늘려야 한다.
			{
				left=mid+1;
			}
		}
		answer[0]=q.peek().left+1;
		answer[1]=q.peek().right+1;
		return answer;
	}

}
