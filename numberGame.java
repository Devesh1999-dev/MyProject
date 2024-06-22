import java.util.*;
class numberGame
{
Scanner k =new Scanner(System.in);
void play()
{
int randomNumber;
int number;
int attempts=0;
int score=0;
randomNumber=(int)(Math.random()*100);
while(attempts<10){
System.out.print("Guess the number between 0 to 100: ");
number=k.nextInt();
//System.out.println(Math.abs(number-randomNumber));
if(Math.abs(number-randomNumber)>20)
{
System.out.println("Guess is too High");
System.out.println("Your Current Score is "+score);
}
else if(Math.abs(number-randomNumber)==0)
{
System.out.println("Guess is Correct.");
++score;
System.out.println("Your Current Score is "+score);
}
else
{
System.out.println("Guess is too Low.");
System.out.println("Your Current Score is "+score);
}
attempts++;
}
System.out.println("Your attempt is Over.");
System.out.print("Generated Number.");
System.out.println(randomNumber);
}
public static void main(String args[])
{
numberGame n=new numberGame();
Scanner k =new Scanner(System.in);
int choice;
boolean flag=true;
while(flag)
{
System.out.println("<<<Menu>>>");
System.out.println("Press 1 for Play the Game.");
System.out.println("Press 2 for Exit from Game.");
System.out.println("Enter Your Choice");
choice=k.nextInt();
switch(choice)
{
case 1: 
{
n.play();
break;
}
case 2:
{
flag=false;
break;
}
default :
System.out.println("Please Choose Valid Option.");
}
}
}
}