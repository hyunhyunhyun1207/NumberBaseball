package numBaseball;

import java.util.Scanner;

public class NumBaseball {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 0 ~ 9, 9회가 끝나면 패배
        // computer -> 숫자 3개 생성 (각 자리 중복 허용 안함) 112 X, 123 O
        // user -> 숫자 3개 입력받고 3자리 숫자가 아닐 시 재 입력 받기

        int user;
        int computer;
        int count = 1;

        while (true) {
            int hundred = (int) (Math.random() * 10);
            int ten = (int) (Math.random() * 10);
            int one = (int) (Math.random() * 10);
            computer = (hundred * 100) + (ten * 10) + one;
            if (hundred == ten || hundred == one || ten == one) {
                continue;
            }
            break;
        }
        while (count < 10) {
            System.out.println(count + "회");
            System.out.print("값 입력 : ");
            user = sc.nextInt();
            boolean result = getStart(computer, user);
            if (user < 100 || user > 999) {
                System.out.println("재입력");
                continue;
            }
            if (result) {
                break;
            } else {
                count++;
            }
        }
    }

    private static boolean getStart(int computer, int user) {
        if (computer == user) {
            System.out.println("홈런");
            return true;
        }

        int strike = 0;
        int ball = 0;

        int comHundred = computer / 100;
        int comTen = computer / 10 % 10;
        int comOne = computer % 10;

        int userHundred = user / 100;
        int userTen = user / 10 % 10;
        int userOne = user % 10;

        if(comHundred == userHundred) strike++;
        if(comHundred == userTen) ball++;
        if(comHundred == userOne) ball++;

        if(comTen == userHundred) ball++;
        if(comTen == userTen) strike++;
        if(comTen == userOne) ball++;

        if(comOne == userHundred) ball++;
        if(comOne == userTen) ball++;
        if(comOne == userOne) strike++;

        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println("스트라이크 : " + strike + "회");
            System.out.println("볼 : " + ball + "회");
        }
        return false;
    }
}
