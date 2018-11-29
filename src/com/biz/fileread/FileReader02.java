package com.biz.fileread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader02 {

	/*
	 * 파일을 저장할 때는 몇개(라인)을 저장할 지 알고있다. 하지만 읽을 때는 몇개가 저장되어 있는지 모르는 경우가 대부분이다. 그래서 읽을
	 * 때는 읽는 방법을 연구할 필요가 있다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile = "D:/bizwork/workutf/ExFiles/gradeList.txt";

		// 파일을 읽기 위한 FileReader 객체 선언
		FileReader fr;

		// TextFile을 읽을 때는 FileReader를 다른 Reader에 연결해서
		// 읽는 것이 편리하다.
		// 파일을 읽어서 buffer에 담는다.
		BufferedReader buffer;
		
		try {
			
			// FileReader로 읽을 파일을 open하고 
			// 그 정보를 Buffered에게 전달하면
			// BufferedReader는 모든 파일을 읽어서
			// 메모리 buffer에 저장 해 둔다.
			fr = new FileReader(readFile);
			buffer = new BufferedReader(fr);
			
			// 버퍼에서 파일 내용을 읽기
            while(true) {
            	
            	// 한 라인을 읽어서 문자열로 return해 달라.
            	String strLine = buffer.readLine();
            	
            	// 만약 buffer가 return한 문자열이 null이면
            	// 더 이상 읽을 내용이 없다는 것이다.
            	if(strLine == null) {
            		// 읽기 종료
            		break;
            	}
            	// null이 아니면 console에 내용을 보여라.
            	System.out.println(strLine);
            	
            }
			
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
