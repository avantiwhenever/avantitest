package graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class FeatureDependency {

    static class Node {
        public String featureName;
        public List<Node> dependentFeatures;

        public Node(String featureName){
            this.featureName = featureName;
            this.dependentFeatures = new LinkedList<>();
        }
    }
    private static Deque<String> result = new LinkedBlockingDeque<String>();

    public static void main(String args[]) {
        Node feature1 = new Node("1");
        Node feature2 = new Node("2");
        Node feature3 = new Node("3");
        Node feature4 = new Node("4");
        Node feature5 = new Node("5");
        feature1.dependentFeatures.add(feature2);
        feature1.dependentFeatures.add(feature3);
        feature2.dependentFeatures.add(feature4);
        feature2.dependentFeatures.add(feature5);
        Set<Node> visited = new HashSet<>();

        printFeatureTree(feature1, visited);
        printResult();
    }

    private static void printResult() {
        Iterator<String> stringIterator = result.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    public static void printFeatureTree(Node feature, Set<Node> visited) {
        if (feature == null || visited.contains(feature)) {
            return;
        }
        visited.add(feature);
        result.addFirst(feature.featureName);
        for (Node node : feature.dependentFeatures) {
            printFeatureTree(node, visited);
        }
    }
}