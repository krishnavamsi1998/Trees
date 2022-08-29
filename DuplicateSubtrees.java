//https://www.youtube.com/watch?v=RPbLhWp-hwg&t=194s
//O(n),O(n)
class Solution {
    
    List<TreeNode> res;
    Map<String,Integer> map;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        map=new HashMap<>();
        
        res=new ArrayList<>();
        
        sub(root);
        
        return res;
        
    }
    
    
    String sub(TreeNode root)
    {
        if(root==null)
            return "$";
        
        String path=root.val+","+sub(root.left)+","+sub(root.right);
        
        map.put(path,map.getOrDefault(path,0)+1);
        
        if(map.get(path)==2)
            res.add(root);
        
        return path;
        
    }
    
}
