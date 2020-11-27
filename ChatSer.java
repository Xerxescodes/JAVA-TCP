import java.io.*;
import java.net.*;
import java.util.*;

public class ChatSer{

ArrayList clientOutputStreams;

public class ClientHandler implements Runnable{
BufferedReader reader;
Socket sock;


public ClientHandler(Socket clientSocket){
try{
sock=clientSocket;
InputStreamReader read = new InputStreamReader(sock.getInputStream());
reader=new BufferedReader(read);
}catch(Exception ex){ex.printStackTrace();}}

public void run(){
String message;
try{
while((message=reader.readLine())!=null){
System.out.println("read: "+message);
tellEveryone(message);
}
}catch(Exception ex){ex.printStackTrace();}
}
}
public static void main(String[]args){
System.out.println("SERVER XERXES ONLINE");
new ChatSer().go();
}

public void go(){
clientOutputStreams=new ArrayList();
try{
ServerSocket serverSock = new ServerSocket(8000);


while(true){
Socket clientSocket=serverSock.accept();
PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
clientOutputStreams.add(writer);

Thread t = new Thread(new ClientHandler(clientSocket));
t.start();
System.out.println("got a connection");}
}catch(Exception ex){
ex.printStackTrace();}}

public void tellEveryone(String message){
Iterator itr = clientOutputStreams.iterator();
while(itr.hasNext()){
try
{
PrintWriter writer = (PrintWriter)itr.next();
writer.println(message);
writer.flush();
}catch(Exception ex){
ex.printStackTrace();
}
}
}}

