package test04.java63;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//import org.reflections.ReflectionUtils.*;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import test04.java63.annotation.Command;
import test04.java63.annotation.Component;

public class BoardApp {

  static class CommandInfo {
    Object instance;
    Method method;
  }


  Scanner scanner = new Scanner(System.in);
  BoardDao boardDao = new BoardDao();



  public void init() throws Exception{
    try {

      boardDao.load();


      HashMap<String, Object> commandMap = new HashMap(); 
      Reflections ref = new Reflections("test04.java63");
      Set<Class<?>> clazzList = ref.getTypesAnnotatedWith(Component.class);

      Object classIns = null; 
      Method method = null;
      Command anno = null;
      for(Class clazz : clazzList){
        classIns = clazz.newInstance();
        anno = (Command)clazz.getAnnotation(Command.class);

        Set<Method> methods = ReflectionUtils.getMethods(clazz, ReflectionUtils.withAnnotation(Command.class));

        for(Method m : methods){
          CommandInfo commandInfo = new CommandInfo();

          commandInfo.instance = classIns;
          commandInfo.method = m;
          commandMap.put(anno.value(), commandInfo);
        }


        try{
          method = clazz.getMethod(name, parameterTypes)
          
           method.invoke(classIns, boardDao);
        }catch(Exception e){

        }

        try{

        }catch(Exception e){

        }


      }


    }catch (Exception e){

    }
  }//init


  public void service() {

  }//service


  public void destroy() {

    scanner.close();
  }//destroy

  public static void main(String[] args) throws Exception{
    // TODO Auto-generated method stub
    BoardApp boardApp = new BoardApp();

    boardApp.init();
    boardApp.service();
    boardApp.destroy();





  }




}
