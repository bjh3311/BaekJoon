import java.util.*;

public class 프로그래머스_혼자놀기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cards= {8,6,3,7,2,5,1,4};
		System.out.println(solution(cards));
	}
	public static boolean[] visited;
	public static int group_num=1;
	public static int group[];
	public static int solution(int[] cards) {
        visited=new boolean[cards.length];
        group=new int[cards.length];
        for(int i=0;i<cards.length;i++)
        {
        	if(visited[i])
        	{
        		continue;
        	}
        	DFS(i,cards);
        	group_num++;
        }
        int[] result=new int[cards.length+1];
        for(int i=0;i<cards.length;i++)
        {
        	result[group[i]]++;
        }
        Arrays.sort(result);
        return result[cards.length]*result[cards.length-1];
    }
	public static void DFS(int index,int[] cards)
	{
		if(visited[index])
		{
			return;
		}
		visited[index]=true;
		group[index]=group_num;
		if(cards[index]-1==index)
		{
			return;
		}
		DFS(cards[index]-1,cards);
		return;
	}
}
