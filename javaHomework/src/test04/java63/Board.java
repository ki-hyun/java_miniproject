package test04.java63;

public class Board {
 private String title;
 private String content;
 private int password;
 private String date;
 
 public Board() {}
 
 public Board(String title, String content, int password, String date ) {
   this.title = title;
   this.content = content;
   this.password = password;
   this.date = date;
 }
 public Board(String csv){
   csv.split("");
 }
 
 
 
 public String getTitle(){
   return title;
 }
 
 public String getContent(){
   return content;
   
 }
 
 public int getPassword(){
   return password;
   
 }
 
 public String getDate(){
   return date;
 }
 
 public void setDate(String date) {
   this.date = date;
 }
 
 public void setTtile(String title){
   this.title = title;
 }
 
 public void setContent(String content){
   this.content = content;
 }
 
 public void setPassword(int password){
   this.password = password;
   
 }
 
 
}
