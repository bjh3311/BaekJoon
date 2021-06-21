import java.util.*;
import java.io.*;
class box implements Comparable<box>
{
	int start;
	int end;
	int size;
	public box(int start,int end,int size)
	{
		this.start=start;
		this.end=end;
		this.size=size;
	}
	public int compareTo(box o)
	{
		if(end==o.end)
		{
			return start-o.start;
		}
		else
		{
			return end-o.end;
		}
	}
}
public class 백준_8980번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int C=Integer.parseInt(s[1]);
		int M=Integer.parseInt(br.readLine());
		ArrayList<box> arr=new ArrayList<box>();
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			int size=Integer.parseInt(s[2]);
			arr.add(new box(start,end,size));
		}
		int[] boxs=new int[N+1];
		Collections.sort(arr);//end를 기준으로 오름차순 정렬
		int boxcount=0;
		for(int i=0;i<M;i++)
		{
			int start=arr.get(i).start;
			int end=arr.get(i).end;
			int size=arr.get(i).size;
			int max=0;
			boolean isLoad=true;
			for(int j=start;j<end;j++)
			{
				if(boxs[j]>=C)
				{
					isLoad=false;
					break;
				}
				max=Math.max(max, boxs[j]);
			}
			if(isLoad)
			{
				int unloads=C-max;
				if(unloads>size)
				{
					unloads=size;
				}
				boxcount+=unloads;//내린거
				for(int j=start;j<end;j++)
				{
					boxs[j]+=unloads;
				}
				
			}
		}
		System.out.println(boxcount);

	}

}
