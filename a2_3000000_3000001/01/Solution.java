
/**
 * The class <b>Solution</b> is used
 * to store a (partial) solution to the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class Solution {


    private int width;
    private int height;

    private int row = 0;
    private int col = 0;

    private boolean board [][];

    private int nextCtr = 0;
    private int trueCtr = 0;


    /**
     * Constructor. Creates an instance of Solution 
     * for a board of size <b>widthxheight</b>. That 
     * solution does not have any board position
     * value explicitly specified yet.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     */
    public Solution(int width, int height) {
            
        this.width = width;
        this.height = height;
        board = new boolean[height][width]; 
        
    }

   /**
     * Constructor. Creates an instance of Solution 
     * wich is a deep copy of the instance received
     * as parameter. 
     *
     * @param other
     *  Instance of solution to deep-copy
     */
     public Solution(Solution other) {

        this.width = other.width;
        this.height = other.height;
        this.board = other.board;
        Solution copyBoard = new Solution(width,height);
        
    }


    /**
     * returns <b>true</b> if and only the parameter 
     * <b>other</b> is referencing an instance of a 
     * Solution which is the ``same'' as  this 
     * instance of Solution (its board as the same
     * values and it is completed to the same degree)
     *
     * @param other
     *  referenced object to compare
     */

    public boolean equals(Object other){

        boolean result = false;
        //boolean result = false;
        //Your code here
        // check if null
        // check instanceof solution (this != other getclass)
        // then check length
        // this.width & this.height w other.width & other.height
        // do a for loop
        if (other == null){
            result = false;
        }
        else if (this.getClass() != other.getClass()){
            result  = false;
        }

        else {
            Solution o = (Solution)other;

            if (this.height != o.height && this.width != o.height){
                result = false;
            }
            else if (this.height == o.height && this.width == o.height){
                for (int i = 0; i<this.height; i++){
                    for (int j = 0; j<this.width; j++){
                        if (this.board[i][j] == o.board[i][j]){
                            result  = true;
                        }
                    }
                }
            }
        }



        return result;
        
    }


    /** 
    * returns <b>true</b> if the solution 
    * has been entirely specified
    *
    * @return
    * true if the solution is fully specified
    */
    public boolean isReady(){

        // check that youve gone through every index
        // return true if counter from setNext = (width*height)
        return nextCtr == this.width*this.height;
        
    }

    /** 
    * specifies the ``next'' value of the 
    * solution. 
    * The first call to setNext specifies 
    * the value of the board location (1,1), 
    * the second call specifies the value
    *  of the board location (1,2) etc. 
    *
    * If <b>setNext</b> is called more times 
    * than there are positions on the board, 
    * an error message is printed out and the 
    * call is ignored.
    *
    * @param nextValue
    *  the boolean value of the next position
    *  of the solution
    */
    public void setNext(boolean nextValue) {

        // add counter - for isReady
        // set value of first row first column
        // column increase
        // set value first row second colum
        // column increase
        // keep this going until max number column reached
        // move onto next row
        // repeat with column
        // when max reached, send error message
        // *board[currentheight][currentwidth] = nextvalue*
        if (col < this.width){
            board[row][col] = nextValue;
            if (nextValue == true){
                trueCtr++;
                System.out.println(trueCtr);
            }
            col++;
            nextCtr++;
        }

        if (col == this.width){
            row++;
            col = 0;
        }      
    }
    
    /**
    * returns <b>true</b> if the solution is completely 
    * specified and is indeed working, that is, if it 
    * will bring a board of the specified dimensions 
    * from being  entirely ``off'' to being  entirely 
    * ``on''.
    *
    * @return
    *  true if the solution is completely specified
    * and works
    */
    public boolean isSuccessful(){

        return (trueCtr%2 != 0);
    }


    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {
 
        //Your code here
        return "";
        
    }



    public static void main (String[] args){
      
     //Solution testBoard = new Solution(3,2);
     //Solution testBoardCopy = new Solution(testBoard);
        Solution testBoard = new Solution(3,3);
        testBoard.setNext(true);
        testBoard.setNext(false);
        testBoard.setNext(true);
        testBoard.setNext(false);
        testBoard.setNext(true);
        testBoard.setNext(false);
        testBoard.setNext(true);
        testBoard.setNext(false);
        testBoard.setNext(true);
        System.out.println(testBoard.isReady());
        System.out.println(testBoard.isSuccessful());
  }

}
