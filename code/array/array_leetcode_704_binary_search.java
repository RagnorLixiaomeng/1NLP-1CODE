
/*

给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9     
输出: 4       
解释: 9 出现在 nums 中并且下标为 4     


示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2     
输出: -1        
解释: 2 不存在 nums 中因此返回 -1        


提示：

1、你可以假设 nums 中的所有元素是不重复的。
2、n 将在 [1, 10000]之间。
3、nums 的每个元素都将在 [-9999, 9999]之间。
 
*/


package code.array;

/**
 * array_leetcode_704_binary_search
 * 
 * 二分法是非常重要的基础算法，但是一看就会，一写就费
 * 其实主要就是对区间的定义没有理解清楚，在循环中没有始终坚持根据查找区间的定义来做边界处理。
 * 区间的定义就是不变量，在循环中坚持根据查找区间的定义来做边界处理，就是循环不变量规则。
 */
public class array_leetcode_704_binary_search {

    public static int binary_search_left_close_right_close(int[] nums, int target){
        // 当target < nums[0] || target > nums[nums.length - 1]的时候不用算了，没必要
        if (target < nums[0] || target > nums[nums.length -1]){
            return -1;
        }
        
        // 初始化二分法的2小兵
        int left = 0, right = nums.length - 1;
        
        /*
         * 区间的定义这就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
         *   while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
         *   if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1 
        */
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{ // nums[mid] > target
                right = mid - 1;
            }   
        }

        
        // 未找到目标值
        return -1;
    }

    public int binary_search_left_close_right_open(int[] nums, int target){
        // 当target < nums[0] || target > nums[nums.length - 1]的时候不用算了，没必要
        if (target < nums[0] || target > nums[nums.length -1]){
            return -1;
        }
        
        // 初始化二分法的2小兵
        int left = 0, right = nums.length;

        /*
         * 
         * while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
         * if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
        */
        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{  // nums[mid] > target
                right = mid; // 我觉得是 = 就是跳过这个nums[mid]了，你再-1就多跳一个不行
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test_arr = new int[] {1, 2, 3, 4, 7, 9, 10};
        int res = binary_search_left_close_right_close(test_arr, 2);
        System.out.println(res);
    }
}


