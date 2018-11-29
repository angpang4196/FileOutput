package com.biz.fileread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader01 {

	/*
	 * 파일을 저장할 때는 몇개(라인)을 저장할 지 알고있다. 하지만 읽을 때는 몇개가 저장되어 있는지 모르는 경우가 대부분이다. 그래서 읽을
	 * 때는 읽는 방법을 연구할 필요가 있다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile = "D:/bizwork/workutf/ExFiles/gradeList.txt";

		// 파일을 읽기 위한 FileReader 객체 선언
		FileReader fr;

		try {
			
			fr = new FileReader(readFile);
			
			// 파일을 읽을 때 몇개(몇라인)이나 읽어야 될지 모르는 상황에서
			// 읽을 라인을 설정하는 좋은 방법이 아니다.
			for(int i = 0; i < 30; i++) {
				
			// 문자열형을 읽을 때에는 ASCII CODE로 읽어들이기 때문에
			// intRead라는 int형 변수에 저장	
			int intRead = fr.read(); // 한 줄을 읽어라
			System.out.print( (char)intRead );
			}
			
			while(true) {
				int intRead = fr.read();
				if(intRead < 0) {
					break;
				}
				System.out.print((char)intRead);
			}
			
			// 파일을 읽을 때는 while() 반복문을 사용해서 읽는 것이
			// 기본 코드 원칙이다.
			
		// read 할 때의 catch 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		// open 할 때의 catch
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
