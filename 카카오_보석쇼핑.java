import java.util.*;
import java.io.*;
public class 카카오_보석쇼핑 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		System.out.println(solution(s)[0]+" "+solution(s)[1]);
	}
	public static int[] solution(String[] gems)
	{
		Queue<String> q = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int startPoint = 0;
        int length = Integer.MAX_VALUE;
        int start = 0;

        int[] answer = {};

        for (String gem : gems) {
            hs.add(gem);
        }

        for (String gem : gems) {
            q.add(gem);
            hm.put(gem, hm.getOrDefault(gem, 0) + 1);

            while (true) {
                String temp = q.peek();
                if (hm.get(temp) > 1) {
                    q.poll();
                    hm.put(temp, hm.get(temp) - 1);
                    startPoint++;
                } else {
                    break;
                }
            }

            if (hm.size() == hs.size() && length > q.size()) {
                length = q.size();
                start = startPoint;
            }
        }


        return new int[]{start + 1, start + length};
	}

}
