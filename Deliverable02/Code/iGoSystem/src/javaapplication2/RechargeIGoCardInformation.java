package javaapplication2;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class RechargeIGoCardInformation {

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRechargeType() {
        return this.rechargeType;
    }

    public void setRechargeType(String rechargeType) {
        this.rechargeType = rechargeType;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  

    public RechargeIGoCardInformation(String email, String rechargeType, double amount, String date,String Method) {
        this.email = email;
        this.rechargeType = rechargeType;
        this.amount = amount;
        this.date = date;
        this.Method=Method;
    }

    public RechargeIGoCardInformation(String email, String rechargeType, double amount,String Method) {
        this.email = email;
        this.rechargeType = rechargeType;
        this.amount = amount;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
        this.Method=Method;

      }

    public String getInfo(){
        return this.email+" | "+this.rechargeType+" | "+this.amount+" | "+this.date+" | "+this.Method;
    }
        
    public String toString(){
        return "\""+this.email+"\""+", "+"\""+this.rechargeType+"\""+", "+"\""+this.amount+"\""+", "+"\""+this.date+"\""+", "+"\""+this.Method+"\"";
    }

    public static RechargeIGoCardInformation getRechargeIGoCardInformation(String rechargeIGoCardInformation){
        String rechargeIGoCardInformationArray[] = null;
        rechargeIGoCardInformationArray = rechargeIGoCardInformation.split(constant.REGEX, -1);
        String emailTmp = rechargeIGoCardInformationArray[0].trim().substring(1); emailTmp = emailTmp.substring(0,emailTmp.length()-1);
        String rechargeTypeTmp = rechargeIGoCardInformationArray[1].trim().substring(1); rechargeTypeTmp = rechargeTypeTmp.substring(0,rechargeTypeTmp.length()-1);
        String amountTmp1 = rechargeIGoCardInformationArray[2].trim().substring(1); amountTmp1 = amountTmp1.substring(0,amountTmp1.length()-1);
        double amountTmp = Double.parseDouble(amountTmp1);
        String dateTmp = rechargeIGoCardInformationArray[3].trim().substring(1); dateTmp = dateTmp.substring(0,dateTmp.length()-1);
        String MethodTmp = rechargeIGoCardInformationArray[4].trim().substring(1); MethodTmp = MethodTmp.substring(0,MethodTmp.length()-1);
        return new RechargeIGoCardInformation(emailTmp,rechargeTypeTmp,amountTmp,dateTmp,MethodTmp);
    }

    public static boolean writeIntoRechargeIGoCardDB(RechargeIGoCardInformation rechargeIGoCardInfo){
        try {
            if(!rechargeIGoCardDBFile.exists()) {
                rechargeIGoCardDBFile.createNewFile();
            }

            FileWriter rechargeIGoCardDBfileWriter = new FileWriter(rechargeIGoCardDBFile.getName(),true);
            BufferedWriter bw = new BufferedWriter(rechargeIGoCardDBfileWriter);
            bw.write(rechargeIGoCardInfo.toString()+"\n");
            bw.close();
            return true;
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList<RechargeIGoCardInformation> retrieveInformationFromRechargeIGoCardDB(String enteredEmail){
        String userEmail;
        String rechargeInformationArray[] = null;
        ArrayList<RechargeIGoCardInformation> rechargeHistory = new ArrayList<RechargeIGoCardInformation>();
        RechargeIGoCardInformation rechargeIGoCard;
        try {
            BufferedReader rechargeDBBufferedReader = new BufferedReader(new FileReader(rechargeIGoCardDBFile));
            String rechargeInformation;
            while ((rechargeInformation = rechargeDBBufferedReader.readLine()) != null){
                rechargeInformationArray = rechargeInformation.split(constant.REGEX, -1);
                userEmail = rechargeInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
               
                if(userEmail.equals(enteredEmail)){
                    rechargeIGoCard = RechargeIGoCardInformation.getRechargeIGoCardInformation(rechargeInformation);
                    rechargeHistory.add(rechargeIGoCard);
                }
            }
            rechargeDBBufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rechargeHistory;
    }

    private String email;
    private String rechargeType;
    private double amount;
    private String date;
    private String Method;
    public static File rechargeIGoCardDBFile = new File(constant.rechargeIGoCardDBFile);


    public static void main(String []args){
        System.out.println("Enter Email, rechargeType, amount");
        Scanner scanner = new Scanner(System.in);
        String emailTmp = scanner.nextLine();
        String rechargeTypeTmp = scanner.nextLine();
        double amountTmp = scanner.nextDouble();
        scanner.nextLine();
       
        RechargeIGoCardInformation rechargeIGoCard = new RechargeIGoCardInformation(emailTmp,rechargeTypeTmp,amountTmp,"  sss");

        System.out.println(rechargeIGoCard);
        System.out.println(writeIntoRechargeIGoCardDB(rechargeIGoCard));

        ArrayList<RechargeIGoCardInformation> rechargeIGGoCardInformationList = retrieveInformationFromRechargeIGoCardDB(emailTmp);
        rechargeIGGoCardInformationList.stream().forEach(System.out::println);
        //System.out.println(rechargeIGGoCardInformationList.size());
    }
}
