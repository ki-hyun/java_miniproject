package test04.java63.command;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import test04.java63.Board;
import test04.java63.BoardDao;
import test04.java63.annotation.Command;
import test04.java63.annotation.Component;

@Component
public class AllCommand {
  BoardDao boardDao;
  Scanner scanner; 
  String date;


  public void setBoardDao(BoardDao bDo){
    boardDao = bDo;
  }

  public void setScanner(Scanner sCn){
    scanner = sCn;

  }


  @Command("add")
  public void addProcess(Map<String, Object> params){


    Date d = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);

    date = cal.get(Calendar.YEAR) + "-" + 
        (cal.get(Calendar.MONTH)+ 1) + "-" + 
        cal.get(Calendar.DATE);


    ArrayList<String> content = (ArrayList<String>)params.get("options");
    Board board = new Board(
        content.get(0), 
        content.get(1), 
        Integer.parseInt(content.get(2)), 
        date);

    boardDao.add(board);

  }



  @Command("list")
  public void doList(Map<String, Object> params) {
    int index = 0;
    for(Board board : boardDao.getList()){
      System.out.println(index + board.getDate() + board.getTitle());
      index++;
    }
  }


  @Command("update")
  public void upUpUp(Map<String, Object> params) {

  }

  @Command("exit")
  public void getOutOfHere(Map<String, Object> params) throws Exception{
    boardDao.save();
    
    
    
  }


}
