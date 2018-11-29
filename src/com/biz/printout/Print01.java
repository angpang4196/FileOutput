package com.biz.printout;

public class Print01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int intNum = 30;
		System.out.println(intNum); // 30이라는 값을 console에 보여라.

		// 100개의 임의의 숫자를 생성해서 콘솔에 보여주는 매우 단순한 코드를 작성

		for (int i = 0; i < 100; i++) {
			int intNum1 = (int) (Math.random() * (100) + 1);
			System.out.println(intNum1);
		}

	}

}
