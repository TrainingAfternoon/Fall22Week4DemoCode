import java.util.LinkedList;
import java.util.Scanner;

public class Grid {
    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate add(Coordinate other, int magnitude) {
            return new Coordinate(
                    this.x + other.x*magnitude,
                    this.y + other.y*magnitude
            );
        }
    }

    private static boolean isValid(Coordinate pos, int xLim, int yLim) {
        return pos.x >= 0 && pos.x < xLim && pos.y >= 0 && pos.y < yLim;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine(); //clear trailing newline

        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for(int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cost[i][j] = -1;
            }
        }
        cost[0][0] = 0;

        Coordinate[] directions = {
                new Coordinate(0, 1),
                new Coordinate(0, -1),
                new Coordinate(1, 0),
                new Coordinate(-1, 0)
        };

        LinkedList<Coordinate> queue = new LinkedList();
        queue.add(new Coordinate(0, 0));

        while(!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int magnitude = grid[current.x][current.y];

            for(Coordinate offset : directions) {
                Coordinate candidateMove = current.add(offset, magnitude);
                if(isValid(candidateMove, n, m)) {
                    if(cost[candidateMove.x][candidateMove.y] == -1) {
                        queue.addLast(candidateMove);
                        cost[candidateMove.x][candidateMove.y] = cost[current.x][current.y] + 1;
                    }
                }
            }
        }

        System.out.println(cost[n-1][m-1]);
        scanner.close();
    }
}
