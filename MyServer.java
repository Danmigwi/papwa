import java.io.*;
import java.net.*;
public class MyServer {
public static void main(String[] args){
try{
ServerSocket ss=new ServerSocket(6666);
Socket s=ss.accept();//establishes connection
DataInputStream dis=new DataInputStream(s.getInputStream());

String str;
str=dis.readUTF();
System.out.println("message from client= "+str);
ss.close();

}catch(Exception e)
{System.out.println(e);
}
} 
}