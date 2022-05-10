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

        //adding all the edges
        example.addEdge(0, 1);
        example.addEdge(0, 3);
        example.addEdge(0, 4);
        example.addEdge(1, 4);
        example.addEdge(2, 1);
        example.addEdge(3, 6);
        example.addEdge(4, 5);
        example.addEdge(4, 7);
        example.addEdge(5, 2);
        example.addEdge(5, 7);
        example.addEdge(6, 7);
        example.addEdge(7, 8);
        example.addEdge(8, 5);

        example.getBreadthFirstTraversal('A');
        System.out.println("");
        example.getDepthFirstTraversal('A');
        System.out.println("");

        Graph<Character> example2 = new Graph<>(4);

        example2.setLabel(0, '0');
        example2.setLabel(1, '1');
        example2.setLabel(2, '2');
        example2.setLabel(3, '3');

        example2.addEdge(0, 1);
        example2.addEdge(1, 2);
        example2.addEdge(2, 0);
        example2.addEdge(0, 2);
        example2.addEdge(2, 3);
        example2.addEdge(3, 3);

        example2.getBreadthFirstTraversal('2');
        System.out.println("");
        example2.getDepthFirstTraversal('2');
    }
}
