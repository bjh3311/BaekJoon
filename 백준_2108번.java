import java.io.*;
import java.util.*;

public class ����_2108�� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> hashmap = new HashMap<>();

		int loop = Integer.parseInt(br.readLine());
		double sum = 0;
		for(int i=0; i<loop; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum += (double) temp;
			list.add(temp);
		}

		// �߾Ӱ��� ã�� ���� �̸� ����
		Collections.sort(list);

		int max = Collections.max(list);
		int min = Collections.min(list);

		// �Ѵ� ���� �� ���
		if(max < 0 && min < 0) {
			min = Math.abs(min);
		}
		// �Ѵ� ��� �� ���
		else if(max > 0 && min > 0) {
			min = min*-1;
		}
		// min, max���� ��ȣ�� �ٸ� ��, ���߿� �ϳ��� 0�� ��
		else {
			max = Math.abs(max);
			min = Math.abs(min);
		}

		double dle = sum / loop;
		int Average = (int) Math.round(dle);
		int Median = list.get(loop/2);
		int Mode = 0;
		int Range = max + min;

		for(int num : list) {
			// ���ڰ� �ѹ� ���� ������ 1�� �߰���.
			hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
		}

		int numbers = 0;
		for(int key : hashmap.values()) {
			numbers = Math.max(numbers, key);
		}

		// ������ ����ߴ� list�� �ٽ� ����ϱ� ���� clear ó��
		// �ֺ���� ���ϱ� �ֺ���� ���� ���� ���� list�� ����
		list.clear();
		for(int key : hashmap.keySet()) {
			if(hashmap.get(key) == numbers) {
				list.add(key);
			}
		}

		// �ֺ���� 2�� �̻��� ��� 2��°�� ���� ���� �̾Ƴ��� �ϱ� ������ list�� ����
		Collections.sort(list);

		// �ֺ���� �󵵼��� ���� ���� 2�� �̻��ΰ�� index 1�� ���� �ֺ���� ����
		// 1���� ���� �״�� index 0�� �ֺ���� ����
		if(list.size() >= 2) {
			Mode = list.get(1);
		}
		else {
			Mode = list.get(0);
		}

		System.out.println(Average);
		System.out.println(Median);
		System.out.println(Mode);
		System.out.println(Range);
	}
}