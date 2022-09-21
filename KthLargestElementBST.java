//O(n),O(n)
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    int i=0;
    int res=Integer.MIN_VALUE;
    
    public int kthLargest(Node root,int K)
    {
      
        kthLargestHelper(root,K);
        return res;
    }
    
    void kthLargestHelper(Node root,int k)
    {
        
        if(root.right!=null)
        kthLargestHelper(root.right,k);
        
        i++;
        if(i==k)
        res=root.data;
        
        if(root.left!=null)
        kthLargestHelper(root.left,k);
        
        
    }
    
       
}
