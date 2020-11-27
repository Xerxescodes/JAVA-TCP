import java.io.*;
import java.net.*;

class server{
public static void main(String[]args){
try
{
ServerSocket sv = new ServerSocket(4000);
Socket c = sv.accept();
DataOutputStream out = new DataOutputStream (c.getOutputStream());
DataInputStream in = new DataInputStream  (c.getInputStream());
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

String str ="",str2="";
while(!str.equals("end"))
{
str = in.readUTF();
System.out.println("client says:"+str);
str2 = read.readLine();
out.writeUTF(str2);
out.flush();
}

in.close();
sv.close();
c.close();
}catch(Exception ex)
{
ex.printStackTrace();
}
}}