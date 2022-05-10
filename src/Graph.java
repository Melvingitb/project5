public class Graph<T> implements GraphInterface<T> {
    //fields
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private T[] labels; //labels [i] contains the label for vertex i

    //constructors
    @SuppressWarnings("unchecked")
    public Graph(int n){
        edges = new boolean[n][n]; //All values initially false
        //@SuppressWarnings("unchecked")
        labels = (T[]) new Object[n]; //All values initially null
    }

    //boolean methods
    public boolean isEdge(int source, int target){
        return edges[source][target];
    } //test whether an edge exists
    //Methods

    //add an edge
    public void addEdge(int source, int target){
        edges[source][target] = true;
    } 
    //Accessor method to get the label of a vertex of this graph
    public T getLabel(int vertex){
        return labels[vertex];
    }
    //Obtain a list of neighbors of a specified vertex of this graph
    public int[] neighbors(int vertex){
        int i;
        int count = 0;
        int[] answer;

        for (i = 0; i < labels.length; i++){
            if (edges[vertex][i]){
                count++;
            }
        }

        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length;i++){
            if (edges[vertex][i]){
                answer[count++] = i;
            }
        }
        return answer;
    }
    //Remove an edge
    public void removeEdge(int source, int target){
        edges[source][target] = false;
    } 
    //Change the label of a vertex of this graph
    public void setLabel(int vertex, T newLabel){
        labels[vertex] = newLabel;
    } 
    //Accessor method to determine the number of vertices in this graph
    public int size(){
        return labels.length;
    }
    
    //traversal methods

    //returns a queue with the breadth first traversal
    public QueueInterface<T> getBreadthFirstTraversal(T origin){
        ArrayQueue<T> test = new ArrayQueue<>();
        return test;
    }
    //returns a stack with the depth first traversal
    public StackInterface<T> getDepthFirstTraversal(T origin){
        ResizableArrayStack<T> testing = new ResizableArrayStack<>();
        return testing;
    }
}
