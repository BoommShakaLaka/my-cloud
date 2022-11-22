import com.cloud.lambda.IntegerAdd;

public class IntegerAddTest {
    public static void main(String[] args) {
        IntegerAdd<Integer, Integer, String> integerAdd = (a, b) -> a + b + "";
        System.out.println(integerAdd.add(1, 2));
        add(integerAdd);
    }

    public static void add(IntegerAdd<Integer, Integer, String> integerAdd) {
        String result = integerAdd.add(3, 4);
        System.out.println(result);
    }
}
