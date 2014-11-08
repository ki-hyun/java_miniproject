package test04.java63;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardDao {//Clear
  String filename;
  ArrayList<Board> list = new ArrayList<Board>();

  public BoardDao(){
    filename = "board.dat";
  }

  public void load() throws Exception{
    Scanner scanner = new Scanner(new FileReader(filename));
    while(true){
      try{
        String[] token = scanner.nextLine().split(",");
        list.add(new Board(token[0], token[1], Integer.parseInt(token[2]), token[3]));
      }catch(Exception e){
        break;
      }
    }


  }

  public void save() throws Exception{
    BufferedWriter out = new BufferedWriter(new FileWriter("board.dat"));
    try{
      for (Board board : list){
        out.write(board.getTitle() + "," + 
            board.getContent() + "," + 
            board.getPassword() + "\n");
      }
    } catch(Exception e){
      
    }





  }



  public void add(Board board){
    list.add(board);
    

  }
  public void change(Board board, int index){
    list.set(index, board);
  }




  public boolean isValid(int index){
    if(index < 0 || index >= list.size()){
      return false;
    } else return true;
    

  }
  public Board getData(int index){
    if (isValid(index)) return list.get(index);
     return null;
    
  }


  public List<Board> getList(){
    return list;
  }

}
