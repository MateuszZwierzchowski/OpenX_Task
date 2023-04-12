import com.sun.source.tree.Tree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



class BinaryTreeTest {

    static class treeInfo {
        Integer numberOfNodesWithoutChild = null;
        Integer treeDepth = null;

        public treeInfo(Integer numberOfNodesWithoutChild, Integer treeDepth) {
            this.numberOfNodesWithoutChild = numberOfNodesWithoutChild;
            this.treeDepth = treeDepth;
        }
    }

    static List<BinaryTree> trees = new ArrayList<BinaryTree>();
    static List<treeInfo> info = new ArrayList<treeInfo>();

    @BeforeAll
    void setup(){
        try {
            File testData = new File("src/DataForBinaryTreeTest.txt");
            Scanner scanner = new Scanner(testData);

            while (scanner.hasNextLine()) {

                String[] data = scanner.nextLine().split(";");
                String[] nodes = data[2].split(":");

                for (String nodeValues : nodes) {
                    String[] node = nodeValues.split(",");
                }
                Integer expectedNumberOfNodesWithoutChild = Integer.parseInt(data[0]);
                Integer expectedTreeDepth = Integer.parseInt((data[1]));

            }
        } catch (Exception e) {
            System.out.println("ERROR!");
            e.printStackTrace();
        }
    }


    @Test
    void numberOfNodesWithoutChildren() {
    }

    @Test
    void largestNumberOfEdgesFromRootToLeaf() {
    }
}

class BinaryTreesTest {


    @BeforeAll



    @org.junit.jupiter.api.Test
    void checkIfTreesAreEquivalent() {
    }
}