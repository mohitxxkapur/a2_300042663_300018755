public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution(3, 2);
        solution.setNext(true);
        solution.setNext(false);
        solution.setNext(true);
        solution.setNext(false);
        solution.setNext(true);
        solution.setNext(false);

        Solution s = new Solution(solution);
        System.out.println( "Solution is ready: " + solution.isReady());
        System.out.println( "The solution is:" );
        System.out.println(solution);
        System.out.println("Solution is successful: " + solution.isSuccessful());

        System.out.println( "Solution is ready: " + s.isReady());
        System.out.println( "The solution is:" );
        System.out.println(s);
        System.out.println("Solution is successful: " + s.isSuccessful());
    }
}