
/*
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

#
*/


// 双for哈哈暴力

// 这里用哈希法来解答，一定先看卡尔哥的图

package code.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * HashTableTwoSumOfNumbers
 */
public class HashTableTwoSumOfNumbers {

    public static int[] twoSum(int[] nums, int target){
        /*
        1. **`int`**：基本类型，效率高，用于数学计算、循环等简单场景。
        2. **`Integer`**：包装类，是对象，可以为 `null`，适合集合（如 `List<Integer>`）和需要对象的场合。
        3. **集合和泛型**：只能用 `Integer`，因为它们不支持基本类型。
        4. **自动装箱/拆箱**：`int` 和 `Integer` 可以自动互转，但会有性能损耗，尽量减少不必要的转换。

        **什么时候用：**
        - 用 `int`：高效，简单运算。
        - 用 `Integer`：需要对象，比如集合或可能为 `null` 的值。 
         * 
        */
        // 创建一个hashmap存储已经遍历过的元素及其索引
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        // 用余数法去遍历
        for (int i = 0; i < nums.length; i++){
            int need = target - nums[i]; // 求目标值的余数

            if (indexMap.containsKey(need)){
                return new int[]{i, indexMap.get(need)}; // 包含就返回目标值
            }else{
                indexMap.put(nums[i], i); // 不包含就把访问过的元素和下标加到map中
            }
        }

        // 找不到就返回为空
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + "\n" +  res[1]);
    }
}


