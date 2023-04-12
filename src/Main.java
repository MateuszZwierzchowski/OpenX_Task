public class Main {
    public static void main(String[] args) {

        Integer[][] input = new Integer[][]{{5, 1, 4},  {3, 2, 3},     {2,null,null},     {5, null, null},    {7,5,6},   {1,null,null},   {0,7,8},  {2,null,null},    {8,null,9},   {5,null,null}};
        Integer[][] input2 = new Integer[][]{{5, 1, 4},  {3, 2, 3},     {2,null,null},     {5, null, null},    {7,5,6},   {1,null,null},   {0,7,8},  {2,null,null},    {8,null,9},   {5,null,null}};

        BinaryTree binaryTree = new BinaryTree(input);
        BinaryTree binaryTree2 = new BinaryTree(input2);

        BinaryTrees binaryTrees = new BinaryTrees(binaryTree, binaryTree2);


        System.out.println(binaryTrees.CheckIfTreesAreEquivalent());
        System.out.println(binaryTree.NumberOfNodesWithoutChildren());
        System.out.println(binaryTree.LargestNumberOfEdgesFromRootToLeaf());

    }
}