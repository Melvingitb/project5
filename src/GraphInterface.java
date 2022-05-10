//A graph interface that contains all the methods listed in the notes as well as the two travesal methods
public interface GraphInterface<T> {
    //boolean methods
    public boolean isEdge(int source, int target); //test whether an edge exists
    //Methods
    public void addEdge(int source, int target); //add an edge
    public T getLabel(int vertex); //Accessor method to get the label of a vertex of this graph
    public int[] neighbors(int vertex); // Obtain a list of neighbors of a specified vertex of this graph
    public void removeEdge(int source, int target); //Remove an edge
    public void setLabel(int vertex, T newLabel); //Change the label of a vertex of this graph
    public int size(); //Accessor method to determine the number of vertices in this graph

    //traversal methods
    public QueueInterface<T> getBreadthFirstTraversal(T origin); //returns a queue with the breadth first traversal
    public void getDepthFirstTraversal(T origin); //returns a stack with the depth first traversal

}
