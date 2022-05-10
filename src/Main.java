public class Main {
    public static void main(String args[]){
        Graph<Character> example = new Graph<Character>(9); // the graph provided in the project description
        
        //setting up all the labels
        example.setLabel(0, 'A');
        example.setLabel(1, 'B');
        example.setLabel(2, 'C');
        example.setLabel(3, 'D');
        example.setLabel(4, 'E');
        example.setLabel(5, 'F');
        example.setLabel(6, 'G');
        example.setLabel(7, 'H');
        example.setLabel(8, 'I');

        example.addEdge(0, 1);
        example.addEdge(0, 3);
        example.addEdge(0, 4);
        example.addEdge(1, 4);
        example.addEdge(2, 1);
        example.addEdge(3, 6);
        example.addEdge(4, 5);
        example.addEdge(4, 7);
        example.addEdge(5, 7);
        example.addEdge(6, 7);
        example.addEdge(7, 8);
        example.addEdge(8, 5);

        int[] testneigh = example.neighbors(0);

        for (int i = 0; i < testneigh.length;i++){
            System.out.println(testneigh[i]);
        }
    }
}
