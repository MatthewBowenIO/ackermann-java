package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        long funcStart = System.currentTimeMillis();
        List<Integer> ackVals = acks();
        long funcEnd = System.currentTimeMillis();

        System.out.println(funcEnd - funcStart);
        ackVals.forEach(ackVal -> System.out.println(ackVal));
    }

    private static int ack(int x, int y) {
        if(x == 0)
            return y + 1;
        else if (y == 0)
            return ack(x - 1, 1);
        else
            return ack(x - 1, ack(x, y - 1));
    }

    private static List<Integer> acks() {
        List<Integer> elems = new ArrayList();
        for (int i = 1; i <= 3; i++) elems.add(i);

        final List<Integer> returnVal = new LinkedList<Integer>();
        Parallel.For(elems,
            new Parallel.Operation<Integer>() {
                public void perform(Integer param) {
                    returnVal.add(ack(param, param + 1));
                };
            });

        return returnVal;
    }
}
