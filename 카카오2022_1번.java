import java.util.*;
import java.io.*;
public class īī��2022_1�� {
	 public static int[] solution(String[] id_list, String[] report, int k) 
	 {
	        HashMap<String,Integer> map=new HashMap<String,Integer>();
	        HashMap<String,Integer> count=new HashMap<String,Integer>();//�Ű� ����Ƚ�� ����
	        ArrayList<String>[] id=new ArrayList[id_list.length];
	        for(int i=0;i<id_list.length;i++)
	        {
	        	id[i]=new ArrayList<String>();
	        }
	        boolean[][] visited=new boolean[id_list.length][id_list.length];
	        int[] answer=new int[id_list.length];
	        for(int i=0;i<id_list.length;i++)
	        {
	        	map.put(id_list[i], i);//�� ���̵� ��ȣ �ο�
	        }
	        for(int i=0;i<report.length;i++)
	        {
	        	String[] s=report[i].split(" ");
	        	int reporter=map.get(s[0]);
	        	int reported=map.get(s[1]);
	        	if(!visited[reporter][reported])//�Ű������� ���ٸ�
	        	{
	        		id[reporter].add(s[1]);
	        		visited[reporter][reported]=true;
	        		count.put(s[1], count.getOrDefault(s[1], 0)+1);
	        	}//�ѻ���� �Ȱ��� ����� �Ű��ϴ°� ����ؼ� �Ű�Ƚ�� ����
	        	//�Ű������� �ִٸ� �ƹ��͵� ���Ѵ�.
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
