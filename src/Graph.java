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

    //returns a queue with the breadth first traversal and also prints it out. follows pseudocode given in the notes without using a vertex class
    @SuppressWarnings("unchecked")
    public QueueInterface<T> getBreadthFirstTraversal(T origin){
        ArrayQueue<T> traversalOrder = new ArrayQueue<>();
        ArrayQueue<T> vertexQueue = new ArrayQueue<>();
        T[] container = (T[])new Object[labels.length]; //contains the visited entries
        int count1 = 0;//various counter variables to stop the while loops
        int count = 0;
        int count2 = 0;
        T frontVertex;
        T nextNeighbor;

        //Mark originVertex as visited
        container[count1++] = origin;
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(origin);
        System.out.print(origin);

        while (!vertexQueue.isEmpty()){ //stops once the queue is empty
           frontVertex = vertexQueue.dequeue();
           int[] theneighbors = this.neighbors(this.getIndex(frontVertex));
           count = 0;
           count2 = 0;

            while (count2 < theneighbors.length){ //essentially keeps going for how many neighbors there are.
                nextNeighbor = this.getLabel(theneighbors[count]);
                count++;
                if (!contains(container, nextNeighbor)){ //if the neighbor has not been visited yet it prints it.
                    System.out.print(nextNeighbor);
                    container[count1++] = nextNeighbor;
                    traversalOrder.enqueue(nextNeighbor);
                    vertexQueue.enqueue(nextNeighbor);
                }
                count2++;
            }
        }
        return traversalOrder;
    }
    //Prints the depth first traversal and returns a queue with it. loosely follows pseudocode in notes without using vertex class
    public QueueInterface<T> getDepthFirstTraversal(T origin){
        boolean visited[] = new boolean[labels.length];//holds boolean values for if a neighbor had already been visited
        ResizableArrayStack<T> vertexStack = new ResizableArrayStack<>();
        ArrayQueue<T> traversalOrder = new ArrayQueue<>();
        
        vertexStack.push(origin);
        T neighbor;

        while (!vertexStack.isEmpty()){
            origin = vertexStack.peek();

            if (visited[this.getIndex(origin)] == false){ //if the vertex had not been visited yet then it adds it to the traversal order
                System.out.print(origin);
                traversalOrder.enqueue(origin);
                visited[this.getIndex(origin)] = true;

            }

            int[] theneighbors = this.neighbors(this.getIndex(origin)); //array of neighbors of the current point

            for (int i = 0; i < theneighbors.length; i++){
                neighbor = this.getLabel(theneighbors[i]);

                if (!visited[getIndex(neighbor)]){
                    vertexStack.push(neighbor);
                    break;
                }//checks to see if any of the neighbors have not been visited and pushes when it finds one
                else if (i == theneighbors.length - 1){
                    vertexStack.pop();
                }//pops once it knows that all the neighbors have been visited
            }
        }
        return traversalOrder;
    }

    private boolean hasNeighbors(int vertex){
        boolean ithas = false;
        for (int i = 0; i < labels.length; i++){
            if (edges[vertex][i]){
                ithas = true;
            }
        }

        return ithas;
    }

    private int getIndex(T origin){
        int number = 0;

        for (int i = 0; i < labels.length; i++){
            if (labels[i] == origin){
                number = i;
            }
        }

        return number;
    } //assumes all labels in graph are different and that the graph does indeed have the given label

    private boolean contains(T[] x, T y){
        boolean itcontains = false;
        for (int i = 0; i < x.length; i++){
            if (x[i] == y){
                itcontains = true;
            }
        }

        return itcontains;
    }
    //checks to see if a value in an array was already visited, never ended up using it though
    private boolean checkvisits(T[] x, int[] y){
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < y.length;j++){
                if (x[i] == this.getLabel(y[j])){
                    return true;
                }
            }
        }
        return false;
    }
//dft first draft. could not get it working, so started from scratch
/*
        @SuppressWarnings("unchecked")
        public QueueInterface<T> getDepthFirstTraversal(T origin){
            ArrayQueue<T> traversalOrder = new ArrayQueue<>();
            ResizableArrayStack<T> vertexStack = new ResizableArrayStack<>();
            T[] container = (T[])new Object[labels.length];
            int count1 = 0;
            int count = 0;
            int count2 = 0;
            T topVertex;
            T nextNeighbor;
    
            container[count1++] = origin;
            traversalOrder.enqueue(origin);
            vertexStack.push(origin);
            System.out.print(origin);
    
            while (!vertexStack.isEmpty()){
                topVertex = vertexStack.peek();
                int[] theneighbors = this.neighbors(this.getIndex(topVertex));
                //count = 0;
                //count2 = 0;
    
                if (!this.contains(container, this.getLabel(theneighbors[count]))){
                    
                    nextNeighbor = this.getLabel(theneighbors[this.checkvisits(container, theneighbors)]);
                    count++;
    
                    System.out.print(nextNeighbor);
                    container[count1++] = nextNeighbor;
                    traversalOrder.enqueue(nextNeighbor);
                    vertexStack.push(nextNeighbor);
                }
                else{
                    vertexStack.pop();
                    //count2 = 0;
                    System.out.println(1);
                }
            }
    
            return traversalOrder;
        }
        */
}
