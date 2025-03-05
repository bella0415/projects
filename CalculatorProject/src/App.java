//Lv.2
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            int num1 = getValidNumber(sc, "첫 번째 숫자를 입력하세요: ");
            int num2 = getValidNumber(sc, "두 번째 숫자를 입력하세요: ");
            char operator = getValidOperator(sc);

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equalsIgnoreCase("exit")) {
                break;
            }
        }

        // 연산 기록 출력
        System.out.println("연산 기록: " + calculator.getHistory());

        // Scanner 닫아주기
        sc.close();
        System.out.println("계산기를 종료합니다.");
    }

    // 유효한 정수 입력 받기
    private static int getValidNumber(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.next(); // 잘못된 입력 제거
            }
        }
    }

    // 유효한 연산 기호 입력 받기
    private static char getValidOperator(Scanner sc) {
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, / 만 허용 가능): ");
            String input = sc.next();
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            } else {
                System.out.println("올바른 연산 기호를 입력하세요.");
            }
        }
    }
}
