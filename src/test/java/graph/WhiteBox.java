package graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhiteBox {

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

    private Boolean graphMatrix3[][] = {
            {true}
    };

    private Boolean graphMatrix4[][] = {};

    @Test
    public void graph1() {
        Integer start = 0, finish = 4;
        String res = "0 1 3 4";
        assertEquals(res, graph.findWay(graphMatrix1, start, finish));

        start = 4; finish = 8;
        res = "No way out.";
        assertEquals(res, graph.findWay(graphMatrix1, start, finish));
    }

    @Test
    public void graph2() {
        Integer start = -1, finish = -1;
        String res = "Incorrect vertex!";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));

        start = 2; finish = -3;
        res = "Incorrect vertex!";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));

        start = -3; finish = 2;
        res = "Incorrect vertex!";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));

        start = 4; finish = 4;
        res = "4";
        assertEquals(res, graph.findWay(graphMatrix2, start, finish));
    }

    @Test
    public void graph3() {
        Integer start = 0, finish = 3;
        String res = "No way out.";
        assertEquals(res, graph.findWay(graphMatrix3, start, finish));
    }

    @Test
    public void graph4() {
        Integer start = 1, finish = 3;
        String res = "Graph not exist!";
        assertEquals(res, graph.findWay(graphMatrix4, start, finish));
    }
}
