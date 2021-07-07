package 프로그래머스_입국심사;
import java.util.*;
class 프로그래머스_입국심사 {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left=1;
		Arrays.sort(times);
		long right=(long)times[times.length-1]*n;
        answer=right;
		while(left<=right)
		{
			long sum=0;
			long mid=(left+right)/2;
			for(int i=0;i<times.length;i++)
			{
				sum+=mid/times[i];
			}
			if(sum>=n)
			{
				right=mid-1;
				answer=Math.min(answer,mid);
			}
			else
			{
				left=mid+1;
			}
		}
        return answer;
    }
}