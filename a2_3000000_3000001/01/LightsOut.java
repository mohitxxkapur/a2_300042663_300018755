import java.util.ArrayList;


/**
 * The class <b>LightsOut</b> is the
 * class that implements the method to
 * compute solutions of the Lights Out game.
 * It contains the main of our application.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class LightsOut {

    private ArrayListSolutionQueue partialSolutions;
    private ArrayList<Solution> solutions;
    private Solution sol;

    /**
     * The method <b>solve</b> finds all the 
     * solutions to the <b>Lights Out</b> game 
     * for an initially completely ``off'' board 
     * of size <b>widthxheight</b>, using a  
     * Breadth-First Search algorithm. 
     *
     * It returns an <b>ArrayList&lt;Solution&gt;</b> 
     * containing all the valid solutions to the 
     * problem.
     *
     * During the computation of the solution, the 
     * method prints out a message each time a new 
     * solution  is found, along with the total time 
     * it took (in milliseconds) to find that solution.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     * @return
     *  an instance of <b>ArrayList&lt;Solution&gt;</b>
     * containing all the solutions
     */
    public static ArrayList<Solution> solve(int width, int height){

        ArrayListSolutionQueue partialSolutions = new ArrayListSolutionQueue();
        ArrayList<Solution> solutions  = new ArrayList<>();

        Solution start = new Solution(width, height);
        long startTime = System.currentTimeMillis();

        partialSolutions.enqueue(start);

        System.out.println("first solution added");

        while (!partialSolutions.isEmpty()){

            Solution current = partialSolutions.dequeue();
            if (current.isReady() && current.isSuccessful()){
                long endTime = System.currentTimeMillis()-startTime;
                System.out.println("Solution found in "+endTime+" milliseconds");
                solutions.add(current);
            }

            else if (!current.isReady()){ 

                Solution a = new Solution(current);
                Solution b = new Solution(current);

                if (a.isReady() == false){
                    a.setNext(true);
                    partialSolutions.enqueue(a);
                    // System.out.println("found for a");
                    // System.out.println("a = " + a.toString());
                }

                 if (b.isReady() == false){
                    b.setNext(false);
                    partialSolutions.enqueue(b);
                    // System.out.println("found for b");
                    // System.out.println("a = " + a.toString());
                }

            }
        } 

        return solutions;
    }

    /**
     * <b>main</b> method  calls the method <b>solve</b> 
     * and then prints out the number of solutions found,
     * as well as the details of each solution.
     *
     * The <b>width</b> and <b>height</b> used by the 
     * main are passed as runtime parameters to
     * the program. If no runtime parameters are passed 
     * to the program, or if the parameters are incorrect,
     * then the default values are used.
     *
     * @param args
     *  Strings array of runtime parameters
     */
    public static void main(String[] args) {

        StudentInfo.display();
        int width;
        int height;

        if (args.length >= 2){
            width = Integer.parseInt(args[0]); // parseint converts from string to int
            height = Integer.parseInt(args[1]);
        }
        else{
            width = 3;
            height = 3;
        }   
        
        ArrayList<Solution> solutions = solve(width, height);


        System.out.println("********");

        for (int i = 0; i<solutions.size(); i++){
            Solution s = solutions.get(i);
            System.out.println(s + "\n********");
        }

        System.out.println("In a board of "+width+" x "+height+", there are "+solutions.size()+" solutions. "); 
    }
}   