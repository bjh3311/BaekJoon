import java.util.*;
import java.io.*;
public class 백준_14003번 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer> list=new ArrayList<Integer>();
		int[] arr=new int[N];
		int[] listIndex=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		list.add(Integer.MIN_VALUE);
		for(int i=0;i<N;i++)
		{
			int num=arr[i];
			int left=1;
			int right=list.size()-1;
			if(list.get(right)<num)//맨끝에 있는 수보다 num이 크다면 추가해주면된다
			{
				list.add(num);
				listIndex[i]=right+1;//arr에서 i번째수는 right위치에 들어간다. right를 index로 갖고있다.
			}
			else
			{
				while(left<right)
				{
					int mid=(left+right)/2;
					if(list.get(mid)>=num)
					{
						right=mid;
					}
					else
					{
						left=mid+1;
					}
				}
				list.set(right, num);
				listIndex[i]=right;
			}
		}
		System.out.println(list.size()-1);
		Stack<Integer> result=new Stack<Integer>();
		int index=list.size()-1;
		for(int i=N-1;i>=0;i--)
		{
			if(listIndex[i]==index)
			{
				result.push(arr[i]);
				index--;
			}
		}
		StringBuilder sb=new StringBuilder();
		while(!result.isEmpty())
		{
			sb.append(result.pop()+" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}