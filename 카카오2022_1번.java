import java.util.*;
import java.io.*;
public class 카카오2022_1번 {
	 public static int[] solution(String[] id_list, String[] report, int k) 
	 {
	        HashMap<String,Integer> map=new HashMap<String,Integer>();
	        HashMap<String,Integer> count=new HashMap<String,Integer>();//신고 당한횟수 담음
	        ArrayList<String>[] id=new ArrayList[id_list.length];
	        for(int i=0;i<id_list.length;i++)
	        {
	        	id[i]=new ArrayList<String>();
	        }
	        boolean[][] visited=new boolean[id_list.length][id_list.length];
	        int[] answer=new int[id_list.length];
	        for(int i=0;i<id_list.length;i++)
	        {
	        	map.put(id_list[i], i);//각 아이디에 번호 부여
	        }
	        for(int i=0;i<report.length;i++)
	        {
	        	String[] s=report[i].split(" ");
	        	int reporter=map.get(s[0]);
	        	int reported=map.get(s[1]);
	        	if(!visited[reporter][reported])//신고한적이 없다면
	        	{
	        		id[reporter].add(s[1]);
	        		visited[reporter][reported]=true;
	        		count.put(s[1], count.getOrDefault(s[1], 0)+1);
	        	}//한사람이 똑같은 사람을 신고하는걸 고려해서 신고횟수 증가
	        	//신고한적이 있다면 아무것도 안한다.
	        }
	        for(int i=0;i<id_list.length;i++)
	        {
	        	int mail=0;
	        	for(String temp: id[i] )
	        	{
	        		if(count.get(temp)>=k)
	        		{
	        			mail++;
	        		}
	        	}
	        	answer[i]=mail;
	        }
	        return answer;
	  }
}
