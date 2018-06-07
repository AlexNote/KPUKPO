package graph;

import org.junit.Test;
import static org.junit.Assert.*;

public class BlackBox {

    private Graph graph = new Graph();

    private Boolean graphMatrix1[][] = {
            {false, true, true, true, false},
            {true, false, false, true, false},
            {true, false, false, false, false},
            {true, true, false, false, true},
            {false, false, false, true, false}
    };

    private Boolean graphMatrix2[][] = {
            {false, true, true, true, false, false},
            {true, false, false, false, false, false},
            {true, false, false, false, true, false},
            {true, false, false, false, false, true},
            {false, false, true, false, false, false},
            {false, false, false, true, false, false}
    };

    @Test
    public void graph1() {
        Integer start = 0, finish = 4;
        String res = "0 1 3 4";
        assertEquals(res, graph.findWay(graphMatrix1, start, finish));

        start = 4; finish = 2;
        res = "4 3 0 2";
        assertEquals(res, graph.findWay(graphMatrix1, start, finish));
    }

    @Test
    public void graph2() {
        Integer start = 0, finish = 1;
        String res = "0 1";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));

        start = 0; finish = 5;
        res = "0 3 5";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));

        start = 4; finish = 5;
        res = "4 2 0 3 5";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));

        start = 4; finish = 4;
        res = "4";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));
    }
}
