import java.util.*;
class ip{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("Enter IP address:");
String s=sc.nextLine();
String[] split_array=s.split("[.]");
int c=0;

//1st check
if(split_array.length>4||split_array.length<4){
c=1;
System.out.println("Invalid Ip Address since IP address is of 32 bit therefore four octets");
if(c==1){
return;
}
}

for(String a:split_array){
if(a.length()>1 && a.length()!=8){
int num=Integer.parseInt(a);
//2nd check
if(num<0||num>255){
System.out.println("Invalid Ip Address since "+num+" is not in range between 0-255");
c=2;
break;
}
else{
//3rd check
String substr=a.substring(0,2);
if(substr.charAt(0)=='0' && substr.charAt(1)!=0 && a.length()!=8){
System.out.println("Invalid Ip address since no preceding zero allowed");
c=3;
break;
}}}
else if(a.length()==8){
if(a=="0"||a=="1"){
c=4;
}
else{
//4th check ...to check if number is binary or not
int b=Integer.parseInt(a);
while(b!=0){
if(b%10>1){
c=4;
break;
}
b=b/10;
}
c=5;
}
}}

if(c==5){
System.out.println("Invalid IP address since mixed notations not allowed");
return;
}
else if(c==2||c==3){
return;
}

//to determine class
int first=Integer.parseInt(split_array[0]);
int second=Integer.parseInt(split_array[1]);
int third=Integer.parseInt(split_array[2]);
int fourth=Integer.parseInt(split_array[3]);

if(first>=0 && first<=127){
System.out.println("Given IP address is of CLASS A");
int power_A=(int)Math.pow(2,24);
System.out.println("Netmask:255.0.0.0=8");
System.out.println("Network id:"+first+".0.0.0");
System.out.println("Host id:0:"+second+":"+third+":"+fourth);
System.out.println("First host of network:"+first+".0.0.1");
System.out.println("Last host of network:"+first+".255.255.254");
System.out.println("No of host per network: "+(power_A-2));
System.out.println("Broadcast Address:"+first+".255.255.255");
}
else if(first>=128 && first<=191){
System.out.println("Given IP address is of CLASS B");
int power_B=(int)Math.pow(2,16);
System.out.println("Netmask:255.255.0.0=16");
System.out.println("Network id:"+first+"."+second+".0.0");
System.out.println("Host id:0.0."+third+"."+fourth);
System.out.println("First host of network:"+first+"."+second+".0.1");
System.out.println("Last host of network:"+first+"."+second+".255.254");
System.out.println("No of host per network: "+(power_B-2));
System.out.println("Broadcast Address:"+first+"."+second+".255.255");
}
else if(first>=192 && first<=223){
System.out.println("Given IP address is of CLASS C");
int power_C=(int)Math.pow(2,8);
System.out.println("Netmask:255.255.255.0=24");
System.out.println("Network id:"+first+"."+second+"."+third+".0");
System.out.println("Host id:0.0.0."+fourth);
System.out.println("First host of network:"+first+"."+second+"."+third+".1");
System.out.println("Last host of network:"+first+"."+second+"."+third+".254");
System.out.println("No of host per network: "+(power_C-2));
System.out.println("Broadcast Address:"+first+"."+second+"."+third+".255");
}
else if(first>=224 && first<=239){
System.out.println("Given IP address is of CLASS D");
}
else if(first>=240 && first<=255){
System.out.println("Given IP address is of CLASS E");
}
}}

