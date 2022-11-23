import java.util.*;

public class 프로그래머스_표편집 {
	public static void main(String[] args) {
		
		String[] cmd= {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		System.out.println(solution(8,2,cmd));
		
	}
	public static String solution(int n,int k,String[] cmd)
	{
		int index=k;//현재 선택되어있는 행
		int table_size=n;
		Stack<Integer> remove_order=new Stack<Integer>();
		for(String temp : cmd)
		{
			String[] s=temp.split(" ");
			if(s[0].equals("U"))
			{
				index=index-Integer.parseInt(s[1]);
			}
			else if(s[0].equals("D"))
			{
				index=index+Integer.parseInt(s[1]);
			}
			else if(s[0].equals("C"))//삭제 명령어
			{
				remove_order.add(index);
				table_size--;
				if(index==table_size)
				{
					index--;
				}
			}
			else//복구명령어
			{
				if(remove_order.pop()<=index)
				{
					index++;
				}
				table_size++;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<table_size;i++)
		{
			sb.append("O");
		}
		while(!remove_order.isEmpty())
		{
			sb.insert(remove_order.pop().intValue(),"X");
		}
		return sb.toString();
	}

}
