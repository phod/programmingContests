import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BFS {
   
   private static class Graph {

      private ArrayList<Graph> neighbours;
      private int colour;
      private Graph previous;
      private int distance;
      
      public Graph() {
         this.neighbours = new ArrayList<Graph>();
         this.previous = null;
      }

      public void addNeighbour(Graph neighbour) {
         this.neighbours.add(neighbour);
      }

      /*
       * Colours:
       * White = -1
       * Grey = 0
       * Black = 1
       *
       */
      public void setColour(int value) {
         this.colour = value;
      }

      public void setPrevious(Graph vertex) {
         this.previous = vertex;
      }

      public void setDistance(int distance) {
         this.distance = distance;
      }
      
   }



   public static void doBFS(Graph[] vertices, int source) {
      int white = -1;
      int grey = 0;
      int black = 1;
      for (int i = 0; i < vertices.length; i++) {
         vertices[i].setColour(white);
         vertices[i].setPrevious(null);
      }
      Graph curr = vertices[source];
      curr.setColour(grey);
      curr.setDistance(0);
      curr.setPrevious(null);
      PriorityQueue<Graph> queue = new PriorityQueue<Graph>(); 
   }
   
   /*
    * Expected input:
    * int: Number of vertices
    * source: Where to start BFS
    * a b: a and b are adjacent
    * c d: c and d are adjacent
    * And so on, until end of input
    */
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int numVertices = scan.nextInt();
      int source = scan.nextInt() - 1;
      int first;
      int second;
      Graph[] vertices = new Graph[numVertices];
      
      //Initialise vertices
      for (int i = 0; i < numVertices; i++) {
         vertices[i] = new Graph();
      }
     
      while (scan.hasNextLine()){
         first = scan.nextInt() - 1;
         second = scan.nextInt() - 1;
         Graph firstVertex = vertices[first];
         Graph secondVertex = vertices[second];
         firstVertex.addNeighbour(secondVertex);
         secondVertex.addNeighbour(firstVertex);
         scan.nextLine();
      }

      doBFS(vertices, source);
   }
   
}
