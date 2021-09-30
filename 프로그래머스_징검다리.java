import java.util.*;
import java.io.*;
public class ���α׷��ӽ�_¡�˴ٸ� {
	public int solution(int distance, int[] rocks, int n) {
        long answer = 0;
        long left=1;
        long right=distance;
        Arrays.sort(rocks);
        while(left<=right)
        {
        	int removeRockcnt=0;
        	int prev=0;
        	long minDistance=(left+right)/2;
        	for(int rock:rocks)
        	{
        		if(rock-prev<minDistance)
        		{
        			removeRockcnt++;
        		}
        		else
        		{
        			prev=rock;
        		}
        	}
        	if(distance-prev<minDistance)
        	{
        		removeRockcnt++;
        	}
        	if(removeRockcnt<=n)
        	{
        		answer=Math.max(answer, minDistance);
        		left=minDistance+1;
        	}
        	else
        	{
        		right=minDistance-1;
        	}
        }
        return (int)answer;
    }

}
