import java.util.*;
class Node implements Comparable<Node>
{
	String name;
	int time;
	Node(String name,int time)
	{
		this.name=name;
		this.time=time;
	}
	public int compareTo(Node o)
	{
		return o.time-time;
	}
}
public class 프로그래머스_방금그곡 {

	 public static void main(String[] args)
	 {
		 String[] musicinfos= {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		 System.out.println(solution("ABC",musicinfos));
	 }
	 public static String solution(String m, String[] musicinfos)  
	 {
	      String[] s;
	      String[] first;
	      String[] second;
	      PriorityQueue<Node> q=new PriorityQueue<Node>();
	      m=m.replace("C#", "c");
	      m=m.replace("D#", "d");
	      m=m.replace("F#", "f");
	      m=m.replace("G#","g");
	      m=m.replace("A#", "a");
	      for(int i=0;i<musicinfos.length;i++)
	      {
	    	  s=musicinfos[i].split(",");
	    	  first=s[0].split(":");
	    	  int a=Integer.parseInt(first[0])*60+Integer.parseInt(first[1]);
	    	  second=s[1].split(":");
	    	  int b=Integer.parseInt(second[0])*60+Integer.parseInt(second[1]);
	    	  int time=b-a;//재생시간
	    	  String temp="";
	    	  s[3]=s[3].replace("C#", "c");
		      s[3]=s[3].replace("D#", "d");
		      s[3]=s[3].replace("F#", "f");
		      s[3]=s[3].replace("G#","g");
		      s[3]=s[3].replace("A#", "a");
	    	  for(int j=0;j<time;j++)
	    	  {
	    		  temp=temp+s[3].charAt(j%s[3].length());
	    	  }
	    	  if(temp.contains(m))
	    	  {
	    		  q.add(new Node(s[2],time));
	    	  }
	      }
	      return q.size()==0? "(None)": q.poll().name;
	 }
}
