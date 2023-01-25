package assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidObjectException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class PathFinder {
    private static class Vertex{

            private String data;
            private  int row,col;
            private boolean visited = false;
            private Vertex camefrom = null;

          Vertex(String data,int row,int col){
              this.data = data;
              this.row = row;
              this.col = col;
        }
        public Vertex[]getNeighbors(Vertex[][] maze, int rows,int cols) {
            Vertex[] neighbors = new Vertex[4];
            int index = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0 || j == 0) && i != j) {
                        Vertex neighbor;
                        if (this.row + i > rows || this.row + i < 0 || this.col + j >= cols || this.col + j < 0) {
                            neighbor = null;
                        } else {
                            neighbor = maze[this.row + i][this.col + j];
                        }
                        if (neighbor == null || neighbor.data.equals("X")) {
                            neighbors[index] = null;
                        } else {
                            neighbors[index] = neighbor;
                        }
                        index++;
                    }
                }
            }
            return neighbors;
        }
    }
    private static class Graph{
        private Vertex[][] maze;
        private int rows,cols;
        private  Vertex start,goal;

        Graph(String filename) throws FileNotFoundException{
            this.start = null;
            this.goal = null;
            try {
                Scanner sc = new Scanner(new File(filename));
                String dimension = sc.nextLine();
                String[] dimensions = dimension.split(" ");
                try {
                    this.rows = Integer.parseInt(dimensions[0]);
                    this.cols = Integer.parseInt(dimensions[1]);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    throw new NumberFormatException("Invalid # of rows/cols");

                }
                this.maze = new Vertex[this.rows][this.cols];
                for(int i = 0; i < this.rows; i++){
                    String [] rowI = sc.nextLine().split("");
                    for(int j=0;j<this.cols;j++) {
                        this.maze[i][j]=new Vertex(rowI[j], i, j);
                        if(rowI[j].equals("S")){
                            if(this.start !=null) throw new InvalidObjectException("Start point already exists");
                            this.start = this.maze[i][j];
                        }
                        if(rowI[j].equals("G")){
                            if(this.goal !=null) throw new InvalidObjectException("Goal point already exists");
                            this.goal = this.maze[i][j];
                        }
                }
            }
                if (this.goal == null || this.start == null )throw new InvalidObjectException("No start or goal pint");

        }catch (FileNotFoundException | InvalidObjectException e){
                e.printStackTrace();
                throw new FileNotFoundException("File not exist");
            }
    }

    public void findPath( Vertex start,Vertex goal){
       start.visited = true;
        LinkedList<Vertex>vertices = new LinkedList<>();
        vertices.add(start);
        while (!vertices.isEmpty()){
            Vertex current = vertices.remove();
            if(current.equals(goal)){
                while (!current.camefrom.equals(start)){
                    current.camefrom.data=".";
                    current = current.camefrom;
                }
                return;
            }


        Vertex[] currentNeighbors = current.getNeighbors(this.maze,this.rows,this.cols);
        for(int i= 0; i < currentNeighbors.length;i++){
            if(currentNeighbors[i] !=null&& !currentNeighbors[i].visited){
                Vertex nextVertex = currentNeighbors[i];
                nextVertex.visited= true;
                nextVertex.camefrom = current;
                vertices.add(nextVertex);
            }
        }
        }
    }
    public void writeFile(String filename) throws FileNotFoundException{
        PrintWriter pw  = new PrintWriter(filename);
        pw.println( this.rows + " "+this.cols);
        for ( int i = 0; i < this.rows;i++){
            StringBuilder sb = new StringBuilder();
            for (int j =0 ; j < this.cols; j++){
                sb.append(this.maze[i][j].data);
            }
            pw.println(sb);
        }
        pw.flush();
        pw.close();
    }
}
public static void solveMaze(String inputFile,String outputFile) throws FileNotFoundException{
    Graph mazeGraph = new Graph(inputFile);
    mazeGraph.findPath(mazeGraph.start,mazeGraph.goal);
    mazeGraph.writeFile(outputFile);
}
}