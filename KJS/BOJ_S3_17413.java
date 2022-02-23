package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-23,45분
 * @title 단어 뒤집기 2
 *
 */
public class BOJ_S3_17413 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<Character>();
        // <> 안에 있는지 체크, 있으면 true
        boolean check = false;

        for(int i=0; i<str.length(); i++){
           if(str.charAt(i) == '<'){
               // 안에 있다고 상태 바꿔주기
               check = true;

               // 스택에 저장되어 있는거 다 pop하면서 출력
               while(!stack.isEmpty()){
                   sb.append(stack.pop());
               }

               // '<' 나타내기
               sb.append(str.charAt(i));
           }
           else if(str.charAt(i) == '>'){
               // 밖에 있다고 상태 바꿔주기
               check = false;
               // '>' 출력
               sb.append(str.charAt(i));
           }
           // ' < > ' 안에 있는 것들
           else if(check){
               sb.append(str.charAt(i));
           }
           // 밖에 있는 것들
           else if(!check){
               // 만약 공백이라면
               if(str.charAt(i) == ' '){
                   // stack에 있는 것들 다 출력
                   while(!stack.isEmpty()) {
                       sb.append(stack.pop());
                   }
                   // 공백 출력
                   sb.append(" ");
               }
               // 공백이 아니라면 스택에 입력
               else{
                   stack.add(str.charAt(i));
               }
           }
        }
        // 나머지 것들 다 출력
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
