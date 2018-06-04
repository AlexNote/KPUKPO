package graph;

import java.util.*;

public class Graph {

    private Map<Integer, Boolean> used = new HashMap<>();
    private Boolean success = false;
    private StringBuffer strWay = new StringBuffer();
    private Integer startVertex;
    private Integer finishVertex;

    private void dfs(Boolean[][] graph, Integer node)
    {
        used.put(node, true);
        if (node == finishVertex)
        {
            strWay.insert(0, " " + node.toString());
            success = true;
            return;
        }

        for (Integer i = 0, size = graph[node].length; i < size; i++)
        {
            if(!used.containsKey(i) && graph[node][i])
                dfs(graph, i);
            if (success)
            {
                strWay.insert(0, " " + node.toString());
                break;
            }
        }
    }

    public String findWay(Boolean[][] graph, Integer startVertex, Integer finishVertex)
    {
        if (strWay.length() > 0)
            strWay.delete(0, strWay.length());
        success = false;
        used.clear();
        if (graph.length == 0)
            return "Graph not exist!";
        if (startVertex < 0 || finishVertex < 0)
            return "Incorrect vertex!";
        if (startVertex == finishVertex)
            return startVertex.toString();

        this.startVertex = startVertex;
        this.finishVertex = finishVertex;

        dfs(graph, startVertex);

        if (success) {
            strWay.deleteCharAt(0);
            return strWay.toString();
        } else
            return "No way out.";
    }

    public void clear() {
        if (strWay.length() > 0)
            strWay.delete(0, strWay.length());
        success = false;
        used.clear();
    }
}
