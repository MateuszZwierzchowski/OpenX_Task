import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BinaryTreeTest {

    static class treeInfo{
        int expectedNumberOfNodesWithoutChildren ;
        int expectedLargestNumberOfEdgesFromRootToLeaf;

        public treeInfo(int expectedNumberOfNodesWithoutChildren, int expectedLargestNumberOfEdgesFromRootToLeaf) {
            this.expectedNumberOfNodesWithoutChildren = expectedNumberOfNodesWithoutChildren;
            this.expectedLargestNumberOfEdgesFromRootToLeaf = expectedLargestNumberOfEdgesFromRootToLeaf;
        }
    }

    static List<BinaryTree> trees = new ArrayList<>();
    static List<treeInfo> treesInfo = new ArrayList<>();


    static void ParseTree(String[] tree, Integer[][] tempList1) {

        int k=0;

        for (String nodeValues : tree) {
            String[] node = nodeValues.split(",");

            tempList1[k][0] = node[0].trim().equals("null") ? null : Integer.parseInt(node[0].trim());
            tempList1[k][1] = node[1].trim().equals("null") ? null : Integer.parseInt(node[1].trim());
            tempList1[k][2] = node[2].trim().equals("null") ? null : Integer.parseInt(node[2].trim());

            k++;

        }
    }

    @BeforeAll
    static void setup(){
        try {
            File testData = new File("src/DataForBinaryTreeTest.txt");
            Scanner scanner = new Scanner(testData);

            while (scanner.hasNextLine()) {

                String[] data = scanner.nextLine().split(";");
                String[] tree = data[2].split(":");

                Integer[][] tempList = new Integer[tree.length][3];

                BinaryTreeTest.ParseTree(tree, tempList);

                treesInfo.add(new treeInfo(Integer.parseInt(data[0].trim()), Integer.parseInt(data[1].trim())));
                trees.add(new BinaryTree(tempList));

            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            e.printStackTrace();
        }
    }


    @Test
    void numberOfNodesWithoutChildren() {
        for(int i = 0; i< trees.size(); i++){
            assertEquals(treesInfo.get(i).expectedNumberOfNodesWithoutChildren, trees.get(i).NumberOfNodesWithoutChildren());
        }
    }

    @Test
    void largestNumberOfEdgesFromRootToLeaf() {
        for(int i = 0; i< trees.size(); i++){
            assertEquals(treesInfo.get(i).expectedLargestNumberOfEdgesFromRootToLeaf, trees.get(i).LargestNumberOfEdgesFromRootToLeaf());
        }

    }
}

class BinaryTreesTest {

    static List<BinaryTrees> trees = new ArrayList<>();
    static List<Boolean> treesInfo = new ArrayList<>();


    static void ParseTree(String[] tree, Integer[][] tempList1) {

        int k=0;

        for (String nodeValues : tree) {
            String[] node = nodeValues.split(",");

            tempList1[k][0] = node[0].trim().equals("null") ? null : Integer.parseInt(node[0].trim());
            tempList1[k][1] = node[1].trim().equals("null") ? null : Integer.parseInt(node[1].trim());
            tempList1[k][2] = node[2].trim().equals("null") ? null : Integer.parseInt(node[2].trim());

            k++;

        }
    }


    @BeforeAll
    static void setup(){
        try {
            File testData = new File("src/DataForBinaryTreesTest.txt");
            Scanner scanner = new Scanner(testData);

            while (scanner.hasNextLine()) {

                String[] data = scanner.nextLine().split(";");
                String[] tree1 = data[1].split(":");
                String[] tree2 = data[2].split(":");



                Integer[][] tempList = new Integer[tree1.length][3];

                ParseTree(tree1, tempList);


                Integer[][] tempList2 = new Integer[tree2.length][3];

                ParseTree(tree2, tempList2);

                treesInfo.add(Boolean.parseBoolean(data[0].trim()));
                trees.add(new BinaryTrees(new BinaryTree(tempList), new BinaryTree(tempList2)));




            }
        } catch (Exception e) {
            System.out.println("ERROR!");
            e.printStackTrace();
        }
    }


    @org.junit.jupiter.api.Test
    void checkIfTreesAreEquivalent() {
        for(int i = 0; i< trees.size(); i++){
            assertEquals(trees.get(i).CheckIfTreesAreEquivalent(), treesInfo.get(i));
        }
    }
}