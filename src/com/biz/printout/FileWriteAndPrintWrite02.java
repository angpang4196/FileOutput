package com.biz.printout;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteAndPrintWrite02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String printFile = "D:/bizwork/workutf/ExFiles/grade01.txt";
		
		FileWriter fw;
		PrintWriter pw;
		
		try {
			
			fw = new FileWriter(printFile, true);
			pw = new PrintWriter(fw);
			
			pw.println("=================================================");
			pw.println("학번\t국어\t영어\t수학\t총점\t평균");
			pw.println("-------------------------------------------------");
			
			for(int i = 0 ; i < 100 ; i ++) {
				int intNum = i + 1;
				int intKor = (int)(Math.random() * (100 - 50 +1))+ 50;
				int intEng = (int)(Math.random() * (100 - 50 +1))+ 50;
				int intMath = (int)(Math.random() * (100 - 50 +1))+ 50;
				
				// %3d => 전체 자릿수를 3개로 하고 오른쪽 정렬
				// %05d => 전체 자릿수를 5개로 하고, 빈칸 개수만큼 0으로 채우기
				pw.printf("%05d\t%3d\t%3d\t%3d\r\n", intNum, intKor, intEng, intMath);
				
			}
			
			pw.close();
			fw.close();
			System.out.println("Save Complete");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
