class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> res=new ArrayList<>();
        
        inorder(root1,list1);
        inorder(root2,list2);
        
        int n1=list1.size();
        int n2=list2.size();
        
        int i=0;
        int j=0;
        
        //merge function
        while(i<n1 && j<n2)
        {
            if(list1.get(i)<=list2.get(j))
            {
                res.add(list1.get(i));
                i++;
            }
            else
            {
                res.add(list2.get(j));
                j++;
            }
            
        }
        
        //if any 
        while(i<n1){
        res.add(list1.get(i));
        i++;
        }
        
        //if any
        while(j<n2)
        {
        res.add(list2.get(j));
        j++;
        }
        
        return res;
        
    }
    
    void inorder(Node root,List<Integer> list)
    {
        if(root==null)
        return;
        
        inorder(root.left,list);
        
        list.add(root.data);
        
        inorder(root.right,list);
        
    }
}
