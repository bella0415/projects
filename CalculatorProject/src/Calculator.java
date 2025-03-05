//Lv.2
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드 (캡슐화 적용)
    private List<Integer> history;

    // 생성자: history 리스트 초기화
    public Calculator() {
        this.history = new ArrayList<>();
    }

    // 연산을 수행하고 결과 반환
    public int calculate(int num1, int num2, char operator) {
        int result;
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
                    throw new ArithmeticException("나눗셈 연산에서 0으로 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산 기호를 입력하세요.");
        }
        addToHistory(result); // 연산 결과 저장
        return result;
    }

    // 연산 결과를 history 리스트에 저장
    private void addToHistory(int result) {
        history.add(result);
    }

    // 연산 기록을 반환 (Getter 메서드)
    public List<Integer> getHistory() {
        return new ArrayList<>(history); // 외부에서 변경할 수 없도록 새 리스트 반환
    }
}
