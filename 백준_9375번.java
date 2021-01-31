import java.util.Scanner;
import java.util.HashMap;
public class น้มุ_9375น๘ {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		// TODO Auto-generated method stub
	   int T_case=scan.nextInt();
	   StringBuilder print=new StringBuilder();
	   for(int i=0;i<T_case;i++)
	   {
		   HashMap<String,Integer> map1=new HashMap<String,Integer>();
		   
		   int n=scan.nextInt();
		   for(int j=0;j<n;j++)
		   {
			   String a=scan.next();
			   String b=scan.next();
			   if(map1.containsKey(b))
			   {
				   map1.put(b, map1.get(b)+1);
			   }
			   else
		      {
				   map1.put(b, 1);
	     	   }
		   }
		   int result=1;
		   for(String qwe:map1.keySet())
		   {
			   result*=map1.get(qwe)+1;
		   }
		   print.append(result-1);
		   print.append("\n");
		   
	   }
	   System.out.println(print.toString());
	   
	  
	 

	}

}
