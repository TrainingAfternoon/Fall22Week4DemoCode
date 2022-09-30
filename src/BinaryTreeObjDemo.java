import java.util.Scanner;

public class BinaryTreeObjDemo {
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
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

            if(nodes[a].left != null) nodes[a].left = nodes[b];
            else nodes[a].right = nodes[b];
        }

        for(Node node : nodes) {
            System.out.printf("Node: %d\n\t", node.data);
            if(node.left != null) System.out.printf("%d ", node.left.data);
            if(node.right != null) System.out.printf("%d ", node.right.data);
            System.out.println();
        }

        scanner.close();
    }
}
