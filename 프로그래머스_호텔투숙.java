import java.util.*;
public class 프로그래머스_호텔투숙 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] temp= {1,3,4,1,3,1};
		long[] answer=solution(10,temp);
		for(long t : answer)
		{
			System.out.print(t+" ");
		}
	}
	private static HashMap<Long,Long> map=new HashMap<Long,Long>();
	public static long[] solution(long k,long[] room_number)
	{
		long[] answer= new long[room_number.length];
		for(int i=0;i<room_number.length;i++)
		{
			answer[i]=findEmpty(room_number[i]);
		}
		return answer;
	}
	public static long findEmpty(long room_number)
	{
		if(!map.containsKey(room_number))
		{
			map.put(room_number, room_number+1);
			return room_number;
		}
		long empty=findEmpty(map.get(room_number));
		map.put(room_number, empty);
		return empty;
	}
}
