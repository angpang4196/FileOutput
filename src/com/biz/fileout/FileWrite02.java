package com.biz.fileout;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String printFile = "D:/bizwork/workutf/ExFiles/fileW02.txt";

		FileWriter fw;

		try {
			fw = new FileWriter(printFile);

			for (int i = 0; i < 10; i++) {
				int rndNum = (int) (Math.random() * 100) + 1;
				fw.write("우리나라만세");
				fw.write(rndNum + "\r\n");
			}

			fw.close();
			System.out.println("파일 작성 완료");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
