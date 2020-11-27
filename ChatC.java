import java.io.*;
import java.net.*;
import java.util.*;

public class ChatC{
BufferedReader reader;
PrintWriter writer;
Socket sock;

public static void main(String[]args){
ChatC client = new ChatC();
client.go();
}

public void go(){
try{
Scanner w = new Scanner(System.in);
sock=new Socket("localhost",8000);

System.out.println("connection success");

InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
reader=new BufferedReader(streamReader);
writer=new PrintWriter(sock.getOutputStream());


System.out.println("Input message: ");
String meso;
meso=w.next();

writer.println(meso);
writer.flush();
}catch(IOException ex){
ex.printStackTrace();}

Thread reader = new Thread(new Incoming());
reader.start();
}

public class Incoming implements Runnable{
public void run(){
String message;
try{
while((message=reader.readLine())!=null){
System.out.println("read "+message);}
}catch(Exception ex){ex.printStackTrace();}
}
}}