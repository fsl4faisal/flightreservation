package tryout.builder;

public class Test {

    public static void main(String[] args) {
        solution(5);
    }

    static void solution(int n) {
        var stepCounter = 1;
        while (stepCounter < n - 1) {
            var currentStep = 0;
            var str = new StringBuffer();
            while (currentStep <= n - 1) {
                currentStep += stepCounter;
                str.append(stepCounter).append(" ");
            }
            if (currentStep == n) {
                System.out.println(str.toString());
            }
            stepCounter++;
        }
    }
}




