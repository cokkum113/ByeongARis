@FunctionalInterface
interface PlusNums {
    public int Calc(int x, int y);
}
public class PracticeForLambda {
    public static void main(String[] args) {
        PlusNums plusNums = (x, y) -> x + y;
        System.out.println(plusNums.Calc(4,2));
    }
}
