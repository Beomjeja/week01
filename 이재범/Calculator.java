import java.io.*;

public class Calculator {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        startsetting(bw);

        while (true) {
            bw.write("수행하고 싶은 연산을 선택해주세요>>");
            bw.flush();
            String inputmode = bf.readLine();
            if (inputmode.equals("6")) {
                bw.write("\n프로그램이 종료되었습니다.\n");
                bw.close();
                break;
            }

            try {
                int mode = Integer.parseInt(inputmode);

                int firstnumber = getint("첫", bf, bw);
                int secondnumber = getint("두", bf, bw);

                calculate(mode, firstnumber, secondnumber, bw);
            } catch (NumberFormatException e) {
                bw.write("올바른 숫자를 입력해주세요");
                bw.flush();
            }
        }
    }

    private static void startsetting(BufferedWriter bw) throws IOException {
        bw.write("\n==== 지원하는 연산 ====\n");
        bw.write("1.  +  (더하기)\n");
        bw.write("2.  -  (빼기)\n");
        bw.write("3.  *  (곱하기)\n");
        bw.write("4.  /  (나누기)\n");
        bw.write("5.  %  (나머지)\n");
        bw.write("6.  종료\n");
        bw.write("================\n");
        bw.flush();
    }
    private static int getint(String count, BufferedReader bf, BufferedWriter bw) throws IOException {
        while (true) {
            bw.write(count + "번째 피연산자를 입력해주세요.>>");
            bw.flush();
            String inputnumber = bf.readLine();
            try {
                return Integer.parseInt(inputnumber);
            } catch (NumberFormatException e) {
                bw.write("올바른 숫자를 입력해주세요");
                bw.flush();
            }
        }
    }
    private static void calculate(int mode, int firstnumber, int secondnumber,BufferedWriter bw) throws IOException
    {
        switch (mode) {
            case 1:
                bw.write("\n" + String.valueOf(firstnumber) + " + " + String.valueOf(secondnumber) + " = " + String.valueOf(firstnumber + secondnumber) + "\n");
                break;
            case 2:
                bw.write("\n" + String.valueOf(firstnumber) + " - " + String.valueOf(secondnumber) + " = " + String.valueOf(firstnumber - secondnumber) + "\n");
                break;
            case 3:
                bw.write("\n" + String.valueOf(firstnumber) + " * " + String.valueOf(secondnumber) + " = " + String.valueOf(firstnumber * secondnumber) + "\n");
                break;
            case 4:
                bw.write("\n" + String.valueOf(firstnumber) + " / " + String.valueOf(secondnumber) + " = " + String.valueOf(firstnumber / secondnumber) + "\n");
                break;
            case 5:
                bw.write("\n" + String.valueOf(firstnumber) + " % " + String.valueOf(secondnumber) + " = " + String.valueOf(firstnumber % secondnumber) + "\n");
                break;
        }
        startsetting(bw);
    }
}
