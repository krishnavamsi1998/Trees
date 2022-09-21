//O(n),O(n)

class Solution {
    int i=0;
    int res=-1;
    
    
    public int KthSmallestElement(Node root, int K) {
      
      KthSmallestHelper(root,K);
      return res;
    }
    
    void KthSmallestHelper(Node root,int k)
    {
        if(root.left!=null)
            KthSmallestHelper(root.left,k);
        
        i++;
        if(i==k)
        res=root.data;
        
        if(root.right!=null)
            KthSmallestHelper(root.right,k);
        
                
    }
}
