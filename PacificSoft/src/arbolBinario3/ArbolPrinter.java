
package arbolBinario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArbolPrinter {

    public static <T extends Comparable<T>> void printNode(NodoAB<T> root) {
        int maxLevel = ArbolPrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<NodoAB<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || ArbolPrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        ArbolPrinter.printWhitespaces(firstSpaces);

        List<NodoAB<T>> newNodes = new ArrayList<NodoAB<T>>();
        for (NodoAB<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getContenido());
                newNodes.add(node.getIzq());
                newNodes.add(node.getDer());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            ArbolPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                ArbolPrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    ArbolPrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getIzq() != null)
                    System.out.print("/");
                else
                    ArbolPrinter.printWhitespaces(1);

                ArbolPrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getDer() != null)
                    System.out.print("\\");
                else
                    ArbolPrinter.printWhitespaces(1);

                ArbolPrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(NodoAB<T> node) {
        if (node == null)
            return 0;

        return Math.max(ArbolPrinter.maxLevel(node.getIzq()), ArbolPrinter.maxLevel(node.getDer())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}