package assignment01;

public class Matrix {
  int numRows;
  int numColumns;
  int data[][];

  // Constructor with data for new matrix (automatically determines dimensions)
  public Matrix(int data[][]) {
    numRows = data.length; // d.length is the number of 1D arrays in the 2D array
    if (numRows == 0) {
      numColumns = 0;
    } else {
      numColumns = data[0].length; // d[0] is the first 1D array
    }
    this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
    // copy the data over
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        this.data[i][j] = data[i][j];
      }
    }
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
            // the superclass' (Object) version
  public boolean equals(Object other) {
    if (!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
      return false;
    }
    Matrix matrix = (Matrix) other; // if the above was not true, we know it's safe to treat 'o' as a Matrix

    /*
     * TODO: replace the below return statement with the correct code, you must
     * return the correct value after determining if this matrix is equal to the
     * input matrix
     */
    if ( this.numColumns!= matrix.numColumns || this.numRows != matrix.numRows){
      return false;
    }// compare two matrix has same dimensions.if not strength go to false.
    int[][] M1 = this.data;// create the matrix 1
    int[][] M2 = matrix.data;// create the matrix 2
    for (int i = 0; i< M1.length;i++){
      for (int j = 0; j <M1[i].length;j++){
        if (M1[i][j] != M2[i][j]){return false;
        }
        }
      }// compare each elments in the two matrix
    return true; // placeholder
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
            // the superclass' (Object) version
  public String toString() {
    /*
     * TODO: replace the below return statement with the correct code, you must
     * return a String that represents this matrix, as specified on the assignment
     * page
     */
    String result = "";//transfer int to string
    for (int i = 0; i< data.length;i++){
      for (int j = 0; j <data[i].length;j++){
         if (j==data[i].length-1){//make j is correct.close loop
           result += data[i][j] + " \n";// print out each array element.with back alash

         }else {
           result+= data[i][j] +" ";//print out each array element
         }
      }
    }
    return result; // placeholder
  }

  public Matrix times(Matrix matrix) {
    /*
     * TODO: replace the below return statement with the correct code, This function
     * must check if the two matrices are compatible for multiplication, if not,
     * return null. If they are compatible, determine the dimensions of the
     * resulting matrix, and fill it in with the correct values for matrix
     * multiplication
     */
    if (numColumns != matrix.numRows) {
      return null;
    }// determing the two matrix can has with blance.
    int[][] result1 = new int[numRows][matrix.numColumns];// set up the final sum matrix has correct rows and columns.
    Matrix sum1 = new Matrix(result1); // set up the sum1 is a matrix
    for (int i = 0; i< data.length;i++) {
      for (int j = 0; j < matrix.data[0].length; j++) {
        for (int x = 0; x < matrix.data.length; x++) {
          sum1.data[i][j] += data[i][x] * matrix.data[x][j];// take out each element from matrix and time eachother
        }
      }
    }
    return sum1; // placeholder
  }

  public Matrix plus(Matrix matrix) {
    /*
     * TODO: replace the below return statement with the correct code, This function
     * must check if the two matrices are compatible for addition, if not, return
     * null. If they are compatible, create a new matrix and fill it in with the
     * correct values for matrix addition
     */
    if (numColumns != matrix.numColumns||numRows !=matrix.numRows) {// compare two matrix has same dimensions.
      return null;
    }
    int[][] result = new int[matrix.numRows][matrix.numColumns];// set up the final sum matrix has correct rows and columns.
    Matrix sum = new Matrix(result);//set up the sum is a matrix
    for (int i = 0; i< data.length;i++) {
      for (int j = 0; j < data[i].length; j++) {
              sum.data[i][j] = data[i][j] + matrix.data[i][j];//take out each element from matrix and time eachother
      }
    }
    return sum; // placeholder
  }
}
