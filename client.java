import java.io.*;
import java.net.*;

class client{
public static void main(String[]args){
try
{
Socket sock = new Socket("localhost",4000);
DataOutputStream out = new DataOutputStream (sock.getOutputStream());
DataInputStream in = new DataInputStream  (sock.getInputStream());
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

String str ="",str2="";
while(!str.equals("end"))
{
str = read.readLine();
out.writeUTF(str);
out.flush();

str2 = in.readUTF();
System.out.println("Server says:"+str2);
}
out.close();
sock.close();
}catch(Exception ex)
{
ex.printStackTrace();
}
}}