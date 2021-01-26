package 백준_11650번;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class 백준_11650번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner scan=new Scanner(System.in);
         int N=scan.nextInt();
         int[][] arr=new int[N][2];
         for(int i=0;i<N;i++)
         {
        	 for(int j=0;j<2;j++)
        	 {
        		 arr[i][j]=scan.nextInt();
        	 }
         }
         Arrays.sort(arr,new Comparator<int[]>(){
        	 @Override
        	 public int compare(int[] o1,int[] o2)
        	 {
        		 return o1[1]-o2[1];
        	 }
         });
         for(int i=0;i<N;i++)
         {
        	 System.out.println(arr[i][0]+" "+arr[i][1]);
         }
	}

}
