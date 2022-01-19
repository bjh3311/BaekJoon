import java.util.*;
import java.io.*;
class jewerly implements Comparable<jewerly>
{
	int M;//무게
	int V;//가치
	public jewerly(int M,int V)
	{
		this.M=M;
		this.V=V;
	}
	public int compareTo(jewerly o)
	{	
		return M-o.M;
	}
}
public class DAY3_보석도둑 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		jewerly[] jewelries=new jewerly[N];
		int[] bags=new int[K];
		for(int i=0;i<N;i++)//보석 정보
		{
			s=br.readLine().split(" ");
			jewelries[i]=new jewerly(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		for(int i=0;i<K;i++)//가방 정보
		{
			s=br.readLine().split(" ");
			bags[i]=Integer.parseInt(s[0]);
		}
		Arrays.sort(bags);//가방 무게 오름차순으로 정렬
		Arrays.sort(jewelries);//보석 무게 오름차순으로 정렬
		int jIndex=0;
		long result=0;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<bags.length;i++)
		{
			int bag=bags[i];//가방 무게
			while(jIndex<N&&jewelries[jIndex].M<=bag)
			{
				q.add(jewelries[jIndex].V);
				jIndex++;
			}
			if(!q.isEmpty())
			{
				result+=q.poll();
			}
		}
		System.out.println(result);
	}
}
