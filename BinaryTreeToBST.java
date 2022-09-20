
class Solution
{
    int i=0;
    
    Node binaryTreeToBST(Node root)
    {
       List<Integer> list=new ArrayList<>();
       storeInOrder(list,root);
       
       Collections.sort(list);
     
       generateBST(list,root);
       
       return root;
       
       
    }
    
    
    void storeInOrder(List<Integer> list,Node root)
    {
        
        if(root==null)
        return;
        storeInOrder(list,root.left);
        list.add(root.data);
        storeInOrder(list,root.right);
    
        
    }
    
    void generateBST(List<Integer> list,Node root)
    {
        
        if(root==null || i>=list.size())
        return;
        
        generateBST(list,root.left);
        root.data=list.get(i);
        i++;
        
        generateBST(list,root.right);

        
        
    }

    
}
