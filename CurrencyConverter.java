import java.util.Scanner;
class CurrencyConverter{
    public static void main(String args[]){
          Scanner s=new Scanner(System.in);

          int choice;
          double amount,convertedAmount;

          while(true){
            System.out.println("***Currency Converter Menu***");
            System.out.println("Press 1: for USD to EUR");
            System.out.println("Press 2: for EUR to USD");
            System.out.println("Press 3: for USD to GBP");
            System.out.println("Press 4: for GBP to USD");
            System.out.println("Press 5: for EUR to GBP");
            System.out.println("Press 6: for GBP to EUR");
            System.out.println("Press 7: for Exit");
            System.out.println("Enter your choice");
            choice=s.nextInt();

            if(choice==7){
              System.out.println("Exiting the program...");
              break;
            }

            System.out.println("Enter your amount");
            amount=s.nextDouble();

            switch(choice){
              case 1:
              convertedAmount=convertUsdToEur(amount);
              System.out.println(amount+"USD="+convertedAmount+"EUR");
              break;
              case 2:
              convertedAmount=convertEurToUsd(amount);
              System.out.println(amount+"EUR="+convertedAmount+"USD");
              break;
              case 3:
              convertedAmount=convertUsdToGbp(amount);
              System.out.println(amount+"USD="+convertedAmount+"GBP");
              break;
              case 4:
              convertedAmount=convertGbpToUsd(amount);
              System.out.println(amount+"GBP="+convertedAmount+"USD");
              break;
              case 5:
              convertedAmount=convertEurToGbp(amount);
              System.out.println(amount+"EUR=" +convertedAmount+"GBP");
              break;
              case 6:
              convertedAmount=convertGbpToEur(amount);
              System.out.println(amount+"GBP="+convertedAmount+"EUR");
              break;
              default:
              System.out.println("Invalid choice,please try again");




            }

          }
          s.close();
        }
        public static double convertUsdToEur(double usd){
          return usd*0.85;
        }
        public static double convertEurToUsd(double eur){
          return eur*1.18;
        }
        public static double convertUsdToGbp(double usd){
          return usd*0.73;
        }
        public static double convertGbpToUsd(double gbp){
          return gbp*1.37;
        }
        public static double convertEurToGbp(double eur){
          return eur*0.86;
        }
        public static double convertGbpToEur(double gbp){
          return gbp*1.16;
        }


    }
