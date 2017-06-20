package pja.asd.huffman;

import java.util.*;

public class Huffman {

    private Node buildTree(Map<String, Integer> weights) {
        // Tworzymy pusty min-value-heap
        Queue<Node> heap = new PriorityQueue<>();

        // Umieszczamy w heap'ie znaki
        for(Map.Entry<String, Integer> weight : weights.entrySet()) {
            heap.add(new Node(weight.getKey(), weight.getValue()));
        }

        // Bierzemy dwie najmniejsze wartości i łączymy je ze sobą
        while(heap.size() > 1) {
            Node min1 = heap.remove();
            Node min2 = heap.remove();
            Node node = new Node(min1.getText() + min2.getText(), min1.getWeight() + min2.getWeight(), min1, min2);
            heap.add(node);
        }

        // Drzewo Huffman'a - ostatni element z heap'u
        return heap.remove();
    }

    // 0 na lewo, 1 na prawo
    private void buildZeroOneCodes(Map<String, String> prefixCodes, Node node, String code) {
        if (null == prefixCodes || null == node) return;

        if (null != node.getLeft()) {
            buildZeroOneCodes(prefixCodes, node.getLeft(), code + 0);
        }

        if (null != node.getRight()) {
            buildZeroOneCodes(prefixCodes, node.getRight(), code + 1);
        }

        // if (node.getText().length() == 1) {
        if (null == node.getLeft() && null == node.getRight()) {
            prefixCodes.put(node.getText(), code);
        }
    }

    public String compress(String input) {
        int length = input.length();

        // Częstotliwość/Wagi występowań znaków
        Map<String, Integer> weights = new HashMap<>();

        for(int i = 0; i < length; i++) {
            String character = Character.toString(input.charAt(i));
            weights.put(character, weights.getOrDefault(character, 0) + 1);
        }

        // Budowanie min-heap
        Node treeRoot = buildTree(weights);

        // Mapa kodów prefiksu
        Map<String, String> prefixCodes = new HashMap<>();
        buildZeroOneCodes(prefixCodes, treeRoot, "");

        System.out.println(prefixCodes);


        // Kompresja
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++) {
            String character = Character.toString(input.charAt(i));
            sb.append(prefixCodes.get(character));
        }

        return sb.toString();
    }
}
