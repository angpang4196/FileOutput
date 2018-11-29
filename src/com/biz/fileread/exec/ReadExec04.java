package com.biz.fileread.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.fileread.vo.WordVO;

public class ReadExec04 {

	public static void main(String[] args) {
		// TODO 메인 시작 부분

		// TODO 전역 변수 선언부
		String readFile = "D:/bizwork/workutf/ExFiles/영단어.txt";

		List<WordVO> wordList = new ArrayList();

		// Text파일을 읽기위한 객체
		FileReader fr;

		// Text파일을 문자열 단위로 변환해서 읽기위한 객체
		BufferedReader buffer;

		try {
			// TODO 파일 읽기 객체 초기화, 생성
			fr = new FileReader(readFile);
			buffer = new BufferedReader(fr);

			// TODO 문자열을 읽어서 wordList에 담기
			while (true) {
				// 한라인씩 문자열로 읽기
				String strWord = buffer.readLine();

				// strWord가 null 이면
				// buffer에 더이상 읽을 내용이 없으면
				if (strWord == null) {
					break;
				}
				// strWord가 null 아닌경우 계속...

				// strWord에 담긴 문자열을 : 을 기준으로
				// 분해해서 영단어와 한글 풀이를 분해해서
				// 문자열 배열에 담아라.
				String[] strWords = strWord.split(":");

				// WordVO를 선언 및 생성해서
				// WordVO는 단어 한 개의 영단어와 한글 풀이를
				// 담을 바구니 Class다.
				WordVO vo = new WordVO();

				// 영단어와 한글 풀이를 변수에 setting
				vo.setStrEng(strWords[0]);
				vo.setStrKor(strWords[1]);

				// 단어 바구니를 단어리스트에 추가
				wordList.add(vo);

			}

			buffer.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try end

		// ?? 여기에서 사용(접근)할 수 있는 변수는? ( 변수의 Scope )
		// readFile , wordList 를 사용할 수 있다.

		// 단어장이 wordList에 만들어진 상태
		// wordList를 사용해서
		// 단어게임을 만들어 본다.

		// TODO 단어 게임 시작
		Scanner scanner = new Scanner(System.in);
		int intPass = 0;
		int intFail = 0;
		while (true) {
			// TODO 단어 게임용 데이터 만들기

			// 같은 단어가 나오지 않도록 wordList를 뒤 섞기
			Collections.shuffle(wordList);

			// 이 중에서 0번위치의 단어 1개를 추출
			WordVO vo = wordList.get(0);

			// 임의 위치에서 한 개의 단어를 추출
			// 1. wordList가 몇개인가?
			int wordCount = wordList.size();

			// 2. 0부터 wordCount - 1 까지중 임의의 숫자 1개를 생성
			int intIndex = (int) (Math.random() * wordCount);

			// 3. 생성된 intIndex 위치의 단어 1개를 추출
			vo = wordList.get(intIndex);

			// TODO 단어 게임 입력부
			System.out.println("다음 풀이에 맞는 영단어를 입력하세요");
			System.out.println(vo.getStrKor());
			System.out.print("단어(종료하려면 --END)>> ");

			// scanner 처럼 장치와 관련된 클래스는 한 코드에서
			// 여러번 다시 생성하는 것이 좋지 않다.
			// Scanner scanner = new Scanner(System.in);
			// >> while 문이 시작되기 전으로 이동한다.
			// while문 안에서는 scanner를 계속 재활용한다.
			String inputEng = scanner.nextLine();
			if (inputEng.equals("--END")) {
				break;
			}

			// TODO 정오 판별
			if (inputEng.equalsIgnoreCase(vo.getStrEng())) {
				System.out.println("참 잘 했어요.");
				intPass++;
			} else {
				System.out.println("좀 더 생각해 보시지.");
				System.out.println(vo.getStrEng());
				intFail++;

			}
			// TODO 결과 표시
			System.out.println("--------------------------------");
			System.out.println("맞은 개수 : " + intPass);
			System.out.println("틀린 개수 : " + intFail);
			System.out.println("================================");
			if (intFail >= 5)
				break;

		}

		System.out.println("Game Over");

	}

}
