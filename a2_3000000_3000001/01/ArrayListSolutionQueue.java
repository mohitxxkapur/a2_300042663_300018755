import java.util.ArrayList;

/**
 * The class <b>ArrayListSolutionQueue</b> 
 * is an implementation of the interface
 * <b>SolutionQueue</b> which relies on
 * an instance of <b>ArrayList&lt;Solution&gt;</b>
 * to store the elements of the queue.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class ArrayListSolutionQueue implements SolutionQueue {

    /**
     * <b>queue</b> stores the references of the elements
     * currently in the queue
     */
    private ArrayList<Solution> queue;

    /**
     * Constructor, initializes  <b>queue</b>
     */
    public ArrayListSolutionQueue() {

        queue = new ArrayList<>();
        
    }

    /**
     * implementation of the method <b>enqueue</b> 
     * from the interface <b>SolutionQueue</b>.
     * @param value
     *      The reference to the new element
     */
    public void enqueue(Solution value) {
        
        queue.add(value);
    }

    /**
     * implementation of the method <b>dequeue</b> 
     * from the interface <b>SolutionQueue</b>.
     * @return 
     *      The reference to removed Solution
     */
    public Solution dequeue() {

        Solution sol;
        if(queue.isEmpty() == false){
            sol =(queue.remove(0));
        }
        else{
            System.out.println("This queue is empty/n");
            sol = null; 
        }
        return sol;
    }

    /**
     * implementation of the method <b>isEmpty</b> 
     * from the interface <b>SolutionQueue</b>.
     * @return 
     *      true if the queue is empty 
     */
    public boolean isEmpty() {

        return(queue.size() == 0);     
    }

}
