package javaapplication2;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseTicketInformation {
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getInfo(){
        return this.email+" | "+this.ticketType+" | "+this.amount+" | "+this.date+" | "+this.Method;
    }
    public String toString(){
        return "\""+this.email+"\""+", "+"\""+this.ticketType+"\""+", "+"\""+this.amount+"\""+", "+"\""+this.date+"\""+", "+"\""+this.Method+"\"";
    }

    private String email;
    private String ticketType;
    private double amount;
    private String date;
private String Method;
    public static File purchaseTicketDBFile = new File(constant.purchaseTicketDBFile);

    public PurchaseTicketInformation(String email, String TicketType, double amount, String date,String Method) {
        this.email = email;
        this.ticketType = TicketType;
        this.amount = amount;
        this.date = date;
        this.Method=Method;
    }

    public PurchaseTicketInformation(String email, String TicketType, double amount,String Method) {
        this.email = email;
        this.ticketType = TicketType;
        this.amount = amount;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
        this.Method=Method;

    }

    public static PurchaseTicketInformation getPurchaseTicketInformation(String purchaseTicketInformation){
        String purchaseTicketInformationArray[] = null;
        purchaseTicketInformationArray = purchaseTicketInformation.split(constant.REGEX, -1);
        String emailTmp = purchaseTicketInformationArray[0].trim().substring(1); emailTmp = emailTmp.substring(0,emailTmp.length()-1);
        String ticketTypeTmp = purchaseTicketInformationArray[1].trim().substring(1); ticketTypeTmp = ticketTypeTmp.substring(0,ticketTypeTmp.length()-1);
        String amountTmp1 = purchaseTicketInformationArray[2].trim().substring(1); amountTmp1 = amountTmp1.substring(0,amountTmp1.length()-1);
        double amountTmp = Double.parseDouble(amountTmp1);
        String dateTmp = purchaseTicketInformationArray[3].trim().substring(1); dateTmp = dateTmp.substring(0,dateTmp.length()-1);
        String MethodTmp = purchaseTicketInformationArray[4].trim().substring(1); MethodTmp = MethodTmp.substring(0,MethodTmp.length()-1);
        return new PurchaseTicketInformation(emailTmp,ticketTypeTmp,amountTmp,dateTmp,MethodTmp);
    }

    public static boolean writeIntoPurchaseTicketDB(PurchaseTicketInformation purchaseTicketInfo){
        try {
            if(!purchaseTicketDBFile.exists()) {
                purchaseTicketDBFile.createNewFile();
            }

            FileWriter purchaseTicketDBfileWriter = new FileWriter(purchaseTicketDBFile.getName(),true);
            BufferedWriter bw = new BufferedWriter(purchaseTicketDBfileWriter);
            bw.write(purchaseTicketInfo.toString()+"\n");
            bw.close();
            return true;
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<PurchaseTicketInformation> retrieveInformationFromPurchaseTicketDB(String enteredEmail){
        String userEmail;
        String purchaseTicketInformationArray[] = null;
        ArrayList<PurchaseTicketInformation> purchaseTicketHistory = new ArrayList<PurchaseTicketInformation>();
        PurchaseTicketInformation purchaseTicketInformation;
        try {
            BufferedReader purchaseTicketDBBufferedReader = new BufferedReader(new FileReader(purchaseTicketDBFile));
            String purchaseInformation;
            while ((purchaseInformation = purchaseTicketDBBufferedReader.readLine()) != null){
                purchaseTicketInformationArray = purchaseInformation.split(constant.REGEX, -1);
                userEmail = purchaseTicketInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
                if(userEmail.equals(enteredEmail)){
                    purchaseTicketInformation = PurchaseTicketInformation.getPurchaseTicketInformation(purchaseInformation);
                    purchaseTicketHistory.add(purchaseTicketInformation);
                }
            }
            purchaseTicketDBBufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return purchaseTicketHistory;
    }

    public static void main(String []args){
        System.out.println("Enter Email, ticketType, amount");
        Scanner scanner = new Scanner(System.in);
        String emailTmp = scanner.nextLine();
        String ticketTypeTmp = scanner.nextLine();
        double amountTmp = scanner.nextDouble();
        String Method="Cash";
        scanner.nextLine();

        PurchaseTicketInformation purchaseTicketInformation = new PurchaseTicketInformation(emailTmp,ticketTypeTmp,amountTmp,Method);

        System.out.println(purchaseTicketInformation);
        System.out.println(writeIntoPurchaseTicketDB(purchaseTicketInformation));

        ArrayList<PurchaseTicketInformation> purchaseTicketInformationList = retrieveInformationFromPurchaseTicketDB(emailTmp);
        purchaseTicketInformationList.stream().forEach(System.out::println);
        System.out.println(purchaseTicketInformationList.size());
    }
}
