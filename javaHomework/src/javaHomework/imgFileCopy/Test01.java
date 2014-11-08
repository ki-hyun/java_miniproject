package javaHomework.imgFileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) {
		FileInputStream in = null;
		try {

			// 현재 파일의 위치는 프로젝트 디렉토리이다.
			in = new FileInputStream("img1.jpg");
			int b = -1;
			int count = 0;
			// 2. read()를 통해 1바이트 읽기
			// 리턴 타입이 int라 해서 4바이트를 읽는 것은 아니다.
			while ((b = in.read()) != -1) {
				count++;
			}
			// 3. File이나 Detabase, Socket 등의 자원은 사용한 다음
			// 명시적으로 해제 해야 한다.
			//

			System.out.println("파일크기: " + count + " 바이트입니다.");

		} catch (FileNotFoundException ex) {
			System.out.println("img.jpg 파일을 찾을 수 없습니다.");

		} catch (IOException ex) {
			System.out.println("읽기 오류!");

		} finally {
			try {
				in.close();
			} catch (IOException ex) {
			}
		}

	}
}
