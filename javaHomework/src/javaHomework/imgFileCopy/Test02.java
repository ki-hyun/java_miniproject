/*Quiz 
 * 파일을 복제한는 기능을 구현하시오.
 * $ Test02 / home/bit/img1.jpg(엔터)
 * => img1.jpg 파일을 복제하여 im1-01.jpg
 * 
 * 
 * 힌트 출력은  FileOutputStream 클래스를 사용하라.
 */

package javaHomework.imgFileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

  public static void main(String[] args) {
    FileInputStream in = null;
    FileOutputStream out = null;
    try {


      // 현재 파일의 위치는 프로젝트 디렉토리이다.
      in = new FileInputStream(args[0]);
      String source = args[0];
      //String newFileName = 
        String target = (source.substring(0, source.lastIndexOf('.')));
      out = new FileOutputStream(target + "-01.jpg");
      int b = -1;
      
      //2. read()를 통해 1바이트 읽기
      //리턴 타입이 int라 해서 4바이트를 읽는 것은 아니다.
      while ((b = in.read()) != -1) {
      
        out.write(b);
      }
      //3. File이나 Detabase, Socket 등의 자원은 사용한 다음 
      // 명시적으로 해제 해야 한다.
      // 

     

    }catch (FileNotFoundException ex) {
      System.out.println("img.jpg 파일을 찾을 수 없습니다.");

    } catch (IOException ex) {
      System.out.println("읽기 오류!");


    }finally {
      try{ in.close(); } catch(IOException ex) {}
      try{ out.close(); } catch(IOException ex) {}
    }

  }
}
