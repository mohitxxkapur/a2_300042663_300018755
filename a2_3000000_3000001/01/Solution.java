
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
    private boolean successfulBoard [][];

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
        successfulBoard = new boolean [height][width];
        
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
         this.col = other.col;
         this.row = other.row;
         this.height = other.height;
         this.nextCtr = other.nextCtr;

        this.board = new boolean[other.height][other.width];
        this.successfulBoard = new boolean[other.height][other.width];
        for (int i = 0; i<height; i++){
            for (int j = 0; j<height; j++){
                this.board[i][j] = other.board[i][j];
            }
        }
        
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
    * specifies the ''next'' value of the 
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
        if (col < this.width && row < this.height){
            board[row][col] = nextValue;
            col++;
            nextCtr++;
        }

        if (row<this.height && col >= this.width){
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

        for (int i = 0; i<this.height; i++){
            for (int j = 0; j<this.width; j++){

                boolean step = this.board[i][j];

                if (step == true){
                    this.successfulBoard[i][j] = !this.successfulBoard[i][j];

                    if (isValid(i+1,j)){
                        this.successfulBoard[i+1][j] = !this.successfulBoard[i+1][j];
                    }
                    if (isValid(i-1,j)){
                        this.successfulBoard[i-1][j] = !this.successfulBoard[i-1][j];
                    }
                    if (isValid(i,j+1)){
                        this.successfulBoard[i][j+1] = !this.successfulBoard[i][j+1];
                    }
                    if (isValid(i,j-1)){
                        this.successfulBoard[i][j-1] = !this.successfulBoard[i][j-1];
                    }

                }

            }
        }

        for (int i = 0; i<this.height; i++){
            for (int j = 0; j<this.width; j++){
                if(this.successfulBoard[i][j] == false){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int i,int j){

        if (i<0 || i>=this.height || j<0 || j>=this.width){
            return false;
        }

        return true;
    }


    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {
 
        //Your code here
        String boardStr = "";
        for (int i = 0; i<this.height; i++){
            boardStr = boardStr + "[";
            for (int j = 0; j<this.width; j++){
                boardStr = boardStr + this.board[i][j];

                if (j != (this.width - 1)){
                    boardStr = boardStr + ",";
                }
            }

            boardStr = boardStr + "]\n";
        }

        return boardStr;
        
    }



  //   public static void main (String[] args){
      
  //    //Solution testBoard = new Solution(3,2);
  //    //Solution testBoardCopy = new Solution(testBoard);
  //       Solution testBoard = new Solution(3,3);
  //       testBoard.setNext(true);
  //       testBoard.setNext(false);
  //       testBoard.setNext(true);
  //       testBoard.setNext(false);
  //       testBoard.setNext(true);
  //       testBoard.setNext(false);
  //       testBoard.setNext(true);
  //       testBoard.setNext(false);
  //       testBoard.setNext(true);
  //       System.out.println(testBoard.isReady());
  //       System.out.println(testBoard.isSuccessful());
  //       System.out.println(testBoard.toString());
  // }

}
