import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	StringBuilder main = new StringBuilder();
	StringBuilder sub = new StringBuilder();
	String sentence = sc.nextLine()+" ";
	boolean reverse = true;
	
	for(int i=0; i<sentence.length();i++) {
		if(sentence.charAt(i)==' ') {
			if(reverse) { //꺽쇠 바깥이라면
				main.append(sub.reverse().toString()+" ");
				sub.setLength(0);
			}else {
				sub.append(sentence.charAt(i));
			}
		}else if(sentence.charAt(i)=='<') {
			reverse = false;
			main.append(sub.reverse().toString());
			sub.setLength(0);
			sub.append('<');
		}else if(sentence.charAt(i)=='>') {
			reverse = true;
			main.append(sub.toString()+">");
			sub.setLength(0);
		}else {
			sub.append(sentence.charAt(i));
		}
	}
	System.out.println(main.toString());
}
}