package Backtracking;

import java.util.Arrays;

/**
 * Created by ajothomas on 4/11/17.
 */
public class MColoringProblem {

    public static boolean isSafe(int graph[][], int colors[], int index, int c) {
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == 1 && colors[i] == c)
                return false;
        }
        return true;
    }

    public static boolean doColoringUtil(int graph[][], int m, int colors[], int index) {
        if (index == colors.length)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, colors, index, c)) {
                colors[index] = c;
                if (doColoringUtil(graph, m, colors, index + 1))
                    return true;
                colors[index] = 0;
            }
        }
        return false;
    }

    public static void doColoring(int graph[][], int m) {
        int colors[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            colors[i] = 0;
        if (doColoringUtil(graph, m, colors, 0)) {
            System.out.println("Graph can be colored : ");
            System.out.println(Arrays.toString(colors));
        } else {
            System.out.println("Graph cannot be colored");
        }
    }

    public static void main(String args[]) {
        MColoringProblem Coloring = new MColoringProblem();
        /* Create following graph and test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        // number of colors
        int m = 3;
        Coloring.doColoring(graph, m);
    }
}
