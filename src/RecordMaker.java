import java.util.Random;

public class RecordMaker {

	private final static int maxEmployee = 99999; // nextInt의 param으로 사용 할 때는 0부터 세므로 + 1 해야함.
	private final static byte maxScore = 100; // nextInt의 param으로 사용 할 때는 0부터 세므로 + 1 해야함.
	private final static String NT = "NT"; // 사원번호 고정 String NT

	public static void main(String[] args) {

		Random random = new Random();
		int[] employeeArray = new int[Integer.parseInt(args[0])];
		
		for (int i = 0; i < employeeArray.length; i++) { //사원번호 중복확인 반복문
			employeeArray[i] = random.nextInt(maxEmployee + 1); // 0 ~ 99999
			for (int j = 0; j < i; j++) {
				if (employeeArray[i] == employeeArray[j]) {
					// 중복값이 있는 경우 다시 랜덤숫자를 받아와야 하므로 i값을 감소시킴
					// for문에 의해 다시 i++되므로, i값은 다시 제자리가 된다.
					i--;
					break;
				}
			}
		}
		
		for(int i=0 ; i< employeeArray.length; i++) { // 출력 반복분
			String employeeNumberSet = String.format("%05d", employeeArray[i]);
			byte employeeScore = (byte) random.nextInt(maxScore + 1); // 0 ~ 100
			System.out.println(NT + employeeNumberSet + " " + employeeScore);
		}
	}
}
