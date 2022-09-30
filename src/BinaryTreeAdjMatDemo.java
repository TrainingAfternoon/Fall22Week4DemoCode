import java.util.Scanner;

public class BinaryTreeAdjMatDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNodes = scanner.nextInt();
        int numEdges = scanner.nextInt();

        int[] nodes = new int[numNodes];
        for(int i = 0; i < numNodes; i++) {
            nodes[i] = i;
        }

        boolean[][] edges = new boolean[numNodes][numNodes];
        for(int i = 0; i < numEdges; i++) {
            scanner.nextLine(); // clear trailing newline
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            edges[a][b] = true;
            // Makes the tree undirected. Connection is not one way.
            // If you want a directed tree, comment out this line.
            edges[b][a] = true;
        }

        for(int node : nodes) {
            System.out.printf("Node: %d\n\t", node);
            for(int i = 0; i < numNodes; i++) {
                if(edges[node][i]) {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
