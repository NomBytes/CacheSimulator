import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * 
 *
 */
public class PossibleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String file  = "./trace-2k.csv";
		BufferedReader br = null;
		String line = "";
		int i = 0;
		//String[] addr = new String[];
		int[] cacheEnt = new int[5];
		//ArrayList<Integer> addr = new ArrayList<Integer>();
		ArrayList<Address> addr = new ArrayList<Address>();
	
		
		try {

			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				
				//addr.add(hexDeci(line));
				//addr.add(line);
				cacheEnt = parseStr(line);
				//System.out.println(addr.get(i));
				Address a = new Address(cacheEnt[0], cacheEnt[1]);
				addr.add(a);
				System.out.printf("inst :%d write: %d\n",addr.get(i).tag,addr.get(i).state);
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	
	}
	public static int[] parseStr(String s){
		int[] cacheEnt = new  int[3];
		String[] str = s.split("\\,", -1);
		int inst = 0;
		int i  = 0;
		Arrays.fill(cacheEnt, 0);
		for(String el: str){
			cacheEnt[i] = !el.isEmpty()? Integer.parseInt(el):0;
			//System.out.println(cacheEnt[i]);
			
			i++;
		}
		//System.out.println("exit parseStr");
		return cacheEnt;
		
	}
//	public static int hexDeci(String s) {
//	    int val = 0;
//	    for (int i = 0; i < s.length(); i++) {
//	        char c = s.charAt(i);
//	        int num = (int) c;
//	        val = 256*val + num;
//	    }
//	    return val;
//	}
	static class Address {
		public int tag;
		public int state;
		
		public Address(int tag, int state){
			this.tag = tag;
			this.state = state;
		}
	}

}


