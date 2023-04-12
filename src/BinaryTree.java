public class BinaryTree {
    Node[] nodes;

    public BinaryTree(Integer[][] input){

        nodes = new Node[input.length];

        for(int i=0; i<nodes.length; i++){

            nodes[i] = new Node();
        }

        for(int i=0; i<nodes.length; i++){

            nodes[i].value = input[i][0];
            nodes[i].leftNode =input[i][1]!= null ? nodes[input[i][1]] : null;
            nodes[i].rightNode = input[i][2] != null ? nodes[input[i][2]] : null;

        }
    }

    private int NodeNumberOfChildren(Node node){

        if(node.leftNode == null) {

            if(node.rightNode == null) return 0;
            else return 1;

        }
        else{

            if(node.rightNode == null) return 1;
            else return 2;
        }

    }


    public int NumberOfNodesWithoutChildren(){

        int numberOfNodesWithoutChildren = 0;

        for(Node node: nodes){

            if(NodeNumberOfChildren(node) == 0) numberOfNodesWithoutChildren++;

        }

        return numberOfNodesWithoutChildren;

    }

    public int LargestNumberOfEdgesFromRootToLeaf()
    {
        return CountLargestNumberOfEdgesFromRootToLeaf(0, nodes[0]);
    }

    private int CountLargestNumberOfEdgesFromRootToLeaf(int NumberOfEdgesFromRootToLeaf, Node node){

        if(NodeNumberOfChildren(node) == 0) return NumberOfEdgesFromRootToLeaf;

        NumberOfEdgesFromRootToLeaf++;

        if(NodeNumberOfChildren(node) == 2) return Math.max(CountLargestNumberOfEdgesFromRootToLeaf(NumberOfEdgesFromRootToLeaf, node.leftNode), CountLargestNumberOfEdgesFromRootToLeaf(NumberOfEdgesFromRootToLeaf, node.rightNode));

        if(node.leftNode != null) return CountLargestNumberOfEdgesFromRootToLeaf(NumberOfEdgesFromRootToLeaf, node.leftNode);

        if(node.rightNode != null) return CountLargestNumberOfEdgesFromRootToLeaf(NumberOfEdgesFromRootToLeaf, node.rightNode);

        return -1;

    }

}
