import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int x;
	int y;
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int compareTo(Node o)
	{
		return x-o.x;
	}//x좌표 기준으로 정렬
}
public class 백준_2261번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s;
		ArrayList<Node> arr=new ArrayList<Node>();
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			arr.add(new Node(x,y));
		}
		Collections.sort(arr);//x좌표 오름차순으로 정렬
	}
	public static int dis(Node o1,Node o2)//두 노드간의 거리
	{
		int x=o1.x-o2.x;
		int y=o1.y-o2.y;
		return (x*x)+(y*y);
	}

}
