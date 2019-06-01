package cn.kgc.arithmetic;

/**
 * 每天一道剑指offer-二维数组中的查找
 * 
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 
 * @author zhuhao
 * @date 2019年3月22日
 */
public class FindNumber {
	
	public boolean Find(int target, int [][] array) {
		
		if(array.length == 0 || array[0].length == 0  ) {
			return false;
		}
		
		int rows = array.length-1;
		int cols = array[0].length-1;
		int i = 0;
		int j = cols;
		
		while(i <= rows && j >= 0){
			if(array[i][j] < target){  //右上角比target小，只能i++进入下一行
				i++;
			}else if(array[i][j] > target){  //右上角比target大，只能j--进入到左边的这些列
				j--;
			}else{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		FindNumber d = new FindNumber();
		int[][] a = {{1,1,1},{3,3,3},{4,4,4}};
		boolean find = d.Find(2, a);
		System.out.println(find);
	}
	
}
/**
 * 剑指offer的思路.就是比较矩阵的右上角的数与target的大小，如果target比这个矩阵右上角的数大，
 * 由于矩阵的右上角元素A是A所在行的最大的值，所以target肯定不在A所在的行了，
 * 所以这时候就应该就在除去第一行的剩下的行中去找这个target
 * 如果target比矩阵右上角的数A小，那么由于A所在的列中A是最小的，那么target就在除去最右边的列的其它的列；
 * 如果相等，返回true;
 */