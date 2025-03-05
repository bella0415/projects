//Lv.1
import java.util.Scanner;

public class cal_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자 입력 받기
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, / 만 허용 가능): ");
            char operator = sc.next().charAt(0);

            int result = 0;

            // 오류 발생 시 불필요한 출력 방지, validOperation = 연산의 유효성을 나타내는 변수
            boolean validOperation = true;

            // 사칙연산 기호에 따른 case
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;

                // +, -, *, / 외의 문자를 입력 했을 떄 나오는 문구
                default:
                    System.out.println("올바른 연산 기호를 입력하세요.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("결과: " + result);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
                // exit 앞으로
            }
        }

        // 더 이상 입력 받지 않음
        sc.close();
        System.out.println("계산기를 종료합니다.");
    }
}

// 입력 받을 때 숫자만 허용 가능 한 기능 추가
// 객체지향