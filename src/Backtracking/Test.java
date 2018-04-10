package Backtracking;

/**
 * Created by ajothomas on 8/28/17.
 */
public class Test {

    public static void printColor(int color[])
    {
        for (int i = 0; i < color.length; i++)
        {

        }
    }
    public static boolean isValid( int graph[][], int m, int color[], int v, int c )
    {
        int numVertices = graph.length;
        for (int i = 0; i < numVertices; i++)
        {
            if (graph[v][i] == 1 && color[i] == c)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean mColorUtil( int graph[][], int m, int color[], int v)
    {
        int numVertices = graph.length;
        if ( v == numVertices-1 )
        {
            return true;
        }

        for (int c = 1; c <= m; c++)
        {
            color[v] = c;
            if (isValid(graph, m, color, v, c)) {
                if( mColorUtil(graph, m, color, v+1))
                {
                    return true;
                }
                return false;
            }
            color[v] = 0;
        }
        return false;
    }

    public static void main(String args[]){

        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int m = 3; // Number of colors
        int color[] = new int[m];
        for (int i = 0; i <= m; i++ )
        {
            color[i] = 0;
        }

        if (mColorUtil(graph, m, color, 0))
        {

        }
    }
}
