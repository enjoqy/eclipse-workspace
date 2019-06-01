package cn.kgc.utlis;

import java.io.File;

/**
 * 清理空文件夹
 * 
 * @author zhuhao
 * @date 2019年3月15日
 */
public class ClearEmptyDirs{
	
	static int i = 0;

	public static void main( String[] args )  {
		
		// 文件夹清理的开始位置，默认为d:\pictures
		String dir_str = "H:\\";  //文件路径
		File dir = new File( dir_str );  //构建文件路径
		
		clear( dir );                    //调用clear方法
		
		System.out.println( "清理完毕。" );
		System.out.println( "共删除了" + i + "个空文件夹" );
	}

	public static void clear( File dir ) {  //传入路径
		
		File[] dir2 = dir.listFiles();  //listFiles() 返回一个抽象路径名数组
		
		for( int i = 0; i < dir2.length-1; i++ ){  //遍历输出
			if( dir2[i].isDirectory() ){         //判断是否是目录，递归调用
				clear( dir2[i] );
			}
		}
		if( dir.isDirectory() && dir.delete() ) {  //判断文件是否是目录，并且能够被删除，delete（）方法能够删除空目录，含有目录和文件的不能被删除
			i++;  //计数器加一
		}
		System.out.println( dir + "删除成功" );

	}

}
