import java.util.*;
import java.io.*;
public class 프로그래머스_양과늑대 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[] info= {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges= {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution(info,edges));
	}
	public static int answer;
	public static ArrayList<Integer>[] child;
	public static int solution(int[] info,int[][] edges)
	{
		answer=0;
		child=new ArrayList[info.length];
		for(int i=0;i<edges.length;i++)
		{
			int parent=edges[i][0];
			int ch=edges[i][1];
			if(child[parent]==null)
			{
				child[parent]=new ArrayList<Integer>();
			}
			child[parent].add(ch);
		}
		List<Integer> list=new LinkedList<Integer>();
		list.add(0);
		DFS(0,1,0,info,list);//0번에서 양 1개들고 시작
		return answer;
	}
	public static void DFS(int v,int sheep,int wolf,int[] info,List<Integer> list)
	{
		if(sheep<=wolf)//늑대가 양보다 많으면 종료
		{
			return ;
		}
		answer=Math.max(answer, sheep);
		List<Integer> nowList=new LinkedList<Integer>();
		nowList.addAll(list);
		nowList.remove(list.indexOf(v));
		if(child[v]!=null)//말단 노드가 아니라면
		{
			for(int temp : child[v])
			{
				nowList.add(temp);
			}
		}
		for(int temp : nowList)
		{
			if(info[temp]==0)
			{
				DFS(temp,sheep+1,wolf,info,nowList);
			}
			else
			{
				DFS(temp,sheep,wolf+1,info,nowList);
			}
		}
		
	}
}
