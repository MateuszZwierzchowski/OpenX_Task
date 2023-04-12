import java.util.Objects;

public class BinaryTrees {

    BinaryTree tree1;
    BinaryTree tree2;

    public BinaryTrees(BinaryTree tree1, BinaryTree tree2){

        this.tree1 = tree1;
        this.tree2 = tree2;

    }

    public boolean CheckIfTreesAreEquivalent(){

        if(tree1.nodes.length != tree2.nodes.length) return false;

        return CheckingIfTreesAreEquivalent(tree1.nodes[0], tree2.nodes[0]);

    }

    private boolean CheckingIfTreesAreEquivalent(Node node1, Node node2){

        if(!Objects.equals(node1.value, node2.value)) return false;
        if(node1.leftNode != node2.leftNode && (node1.leftNode == null || node2.leftNode == null)) return false;
        if(node1.rightNode != node2.rightNode && (node1.rightNode == null || node2.rightNode == null)) return false;


        if(node1.leftNode==null){

            if(node1.rightNode==null) return true;
            else return CheckingIfTreesAreEquivalent(node1.rightNode, node2.rightNode);


        }
        else {

            if(node1.rightNode==null) return CheckingIfTreesAreEquivalent(node1.leftNode, node2.leftNode);
            else return (CheckingIfTreesAreEquivalent(node1.leftNode, node2.leftNode) && CheckingIfTreesAreEquivalent(node1.rightNode, node2.rightNode));

        }

    }


}
