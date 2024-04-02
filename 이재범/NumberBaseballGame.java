import java.io.*;

import static java.lang.Math.exp;
import static java.lang.Math.random;

public class NumberBaseballGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] answer = new int[3];
        boolean[] exceptnumber = new boolean[10];
        for (int i =0; i < answer.length;)
        {
            int getnumber= (int)((Math.random())*10%10);
            if (exceptnumber[getnumber] == false)
            {
                if(i==0)
                {
                    if (getnumber != 0) {
                        answer[i] = getnumber;
                        exceptnumber[answer[i]] = true;
                        i++;
                    }
                }
                else {
                    answer[i] = getnumber;
                    exceptnumber[answer[i]] = true;
                    i++;
                }
            }
        }
        checkindex(answer,bf,bw);
    }
    private static int getint(BufferedReader bf, BufferedWriter bw) throws IOException {
        while (true) {
            bw.write("\n3자리 숫자를 입력해주세요>>");
            bw.flush();
            String inputvalue = bf.readLine();
            if (s.length() ==3) {
                try {
                    return Integer.parseInt(inputvalue);
                } catch (NumberFormatException e) {
                    bw.write("숫자를 입력해주세요.\n\n");
                    bw.flush();
                }
            }
            else{
                bw.write("올바른 입력값이 아닙니다.\n\n");
                bw.flush();
            }
        }
    }
    private static void checkindex(int[] answer, BufferedReader bf,BufferedWriter bw) throws IOException {
        int strikeindex = 0;
        int ballindex = 0;
        while (true) {
            strikeindex = 0;
            ballindex = 0;
            int objectint = getint(bf, bw);
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] ==  Character.getNumericValue(String.valueOf(objectint).charAt(i))) {
                    strikeindex++;
                }
            }
            for (int i = 0; i < answer.length; i++) {
                for (int c = 0; c < answer.length; c++) {
                    if (answer[i] ==  Character.getNumericValue(String.valueOf(objectint).charAt(c))) {
                        ballindex++;
                    }
                }
            }
            if (ballindex != 0) {
                bw.write("STRIKE : "+String.valueOf(strikeindex)+"\n");
                bw.write("BALL : "+String.valueOf(ballindex - strikeindex)+"\n");
                bw.flush();
            }
            else {
                bw.write("\nOUT\n");
                bw.flush();
            }
            if (strikeindex == 3)
            {
                bw.write("\n축하드립니다. 정답입니다.\n");
                bw.close();
                break;
            }
        }
    }
}
