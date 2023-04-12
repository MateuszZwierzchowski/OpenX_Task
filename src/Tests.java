import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BinaryTreeTest {

    static class treeInfo{
        int expectedNumberOfNodesWithoutChildren = 0;
        int expectedLargestNumberOfEdgesFromRootToLeaf = 0;

        public treeInfo(int expectedNumberOfNodesWithoutChildren, int expectedLargestNumberOfEdgesFromRootToLeaf) {
            this.expectedNumberOfNodesWithoutChildren = expectedNumberOfNodesWithoutChildren;
            this.expectedLargestNumberOfEdgesFromRootToLeaf = expectedLargestNumberOfEdgesFromRootToLeaf;
        }
    }

    static List<BinaryTree> trees = new ArrayList<>();
    static List<treeInfo> treesInfo = new ArrayList<>();


    @BeforeAll
    static void setup(){
        try {
            File testData = new File("src/DataForBinaryTreeTest.txt");
            Scanner scanner = new Scanner(testData);

            while (scanner.hasNextLine()) {

                String[] data = scanner.nextLine().split(";");
                String[] tree = data[2].split(":");

                Integer[][] tempList = new Integer[tree.length][3];

                int k=0;
                for (String nodeValues : tree) {
                    String[] node = nodeValues.split(",");

                    tempList[k][0] = node[0].trim().equals("null") ? null : Integer.parseInt(node[0].trim());
                    tempList[k][1] = node[1].trim().equals("null") ? null : Integer.parseInt(node[1].trim());
                    tempList[k][2] = node[2].trim().equals("null") ? null : Integer.parseInt(node[2].trim());

                    k++;

                }

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
        for(int i=0; i<this.trees.size(); i++){
            assertEquals(treesInfo.get(i).expectedNumberOfNodesWithoutChildren, trees.get(i).NumberOfNodesWithoutChildren());
        }
    }

    @Test
    void largestNumberOfEdgesFromRootToLeaf() {
        for(int i=0; i<this.trees.size(); i++){
            assertEquals(treesInfo.get(i).expectedLargestNumberOfEdgesFromRootToLeaf, trees.get(i).LargestNumberOfEdgesFromRootToLeaf());
        }

    }
}

class BinaryTreesTest {

    static List<BinaryTrees> trees = new ArrayList<BinaryTrees>();
    static List<Boolean> treesInfo = new ArrayList<>();



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

                int k=0;
                for (String nodeValues : tree1) {
                    String[] node = nodeValues.split(",");

                    tempList[k][0] = node[0].trim().equals("null") ? null : Integer.parseInt(node[0].trim());
                    tempList[k][1] = node[1].trim().equals("null") ? null : Integer.parseInt(node[1].trim());
                    tempList[k][2] = node[2].trim().equals("null") ? null : Integer.parseInt(node[2].trim());

                    k++;

                }



                Integer[][] tempList2 = new Integer[tree2.length][3];

                k=0;
                for (String nodeValues : tree2) {
                    String[] node = nodeValues.split(",");

                    tempList2[k][0] = node[0].trim().equals("null") ? null : Integer.parseInt(node[0].trim());
                    tempList2[k][1] = node[1].trim().equals("null") ? null : Integer.parseInt(node[1].trim());
                    tempList2[k][2] = node[2].trim().equals("null") ? null : Integer.parseInt(node[2].trim());

                    k++;

                }

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
        for(int i=0; i<this.trees.size(); i++){
            assertEquals(trees.get(i).CheckIfTreesAreEquivalent(), treesInfo.get(i));
        }
    }
}