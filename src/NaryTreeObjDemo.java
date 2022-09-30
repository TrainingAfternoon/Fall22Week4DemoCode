import java.util.ArrayList;
import java.util.Scanner;

public class NaryTreeObjDemo {
    public static class Node {
        public int data;
        public ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<Node>();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNodes = scanner.nextInt();
        int numEdges = scanner.nextInt();

        Node[] nodes = new Node[numNodes];
        for(int i = 0; i < numNodes; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < numEdges; i++) {
            scanner.nextLine(); // clear trailing newline
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            nodes[a].children.add(nodes[b]);
            // Makes the tree undirected. Connection is not one way.
            // If you want a directed tree, comment out this line.
            nodes[b].children.add(nodes[a]);
        }

        for(Node node : nodes) {
            System.out.printf("Node: %d\n\t", node.data);
            for(Node child : node.children) System.out.printf("%d ", child.data);
            System.out.println();
        }

        scanner.close();
    }
}
