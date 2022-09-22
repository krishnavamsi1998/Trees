//O(n),O(n)
//bottom up
class Solution{   
    
    
    static class BstInfo
    {
        int min;
        int max;
        int size;
        boolean isBST;
        
        BstInfo(int min,int max,int size,boolean isBST)
        {
            this.min=min;
            this.max=max;
            this.size=size;
            this.isBST=isBST;
        }
        
        BstInfo()
        {}
        
    }
    
    static BstInfo findBst(Node root)
    {
        if(root==null)
        return new BstInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,
        0,true);
        
        //follow post order approach
        // recurse left and right
        
        BstInfo left=findBst(root.left);
        BstInfo right=findBst(root.right);
        
        // create new BstInfo to store current nodes data
        BstInfo curr=new BstInfo();
        curr.min=Math.min(left.min,root.data);
        curr.max=Math.max(right.max,root.data);
        
        curr.isBST=left.isBST && right.isBST 
                    && left.max< root.data
                    && right.min > root.data;
        // if bst then +1      
        if(curr.isBST)
            curr.size=left.size + right.size + 1;
        // take max size left or right
        else
            curr.size=Math.max(left.size, right.size);
    
    return curr;   
        
    }
    
    static int largestBst(Node root)
    {
        
        return findBst(root).size;
        
    }
    
}
