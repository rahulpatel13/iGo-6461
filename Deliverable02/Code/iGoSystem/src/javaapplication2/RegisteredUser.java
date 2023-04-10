package javaapplication2;
import java.io.*;
import java.util.Scanner;


public class RegisteredUser {

    public static File userDBFile = new File(constant.userDBFile);

    public RegisteredUser(String email, String password, String name, String address, String photoId, String userType, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.photoId = photoId;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getphotoId() {
        return this.photoId;
    }

    public void setphotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return "\""+this.email+"\""+", "+"\""+this.password+"\""+", "+"\""+this.name+"\""+", "+"\""+this.address+"\""+", "+"\""+this.photoId+"\""+", "+"\""+this.userType+"\""+", "+"\""+this.phoneNumber+"\"";
    }

    public static RegisteredUser getRegisteredUser(String userInformation){
        String userInformationArray[] = null;
        userInformationArray = userInformation.split(constant.REGEX, -1);
        String emailTmp = userInformationArray[0].trim().substring(1); emailTmp = emailTmp.substring(0,emailTmp.length()-1);
        String passwordTmp = userInformationArray[1].trim().substring(1); passwordTmp = passwordTmp.substring(0,passwordTmp.length()-1);
        String nameTmp = userInformationArray[2].trim().substring(1); nameTmp = nameTmp.substring(0,nameTmp.length()-1);
        String addressTmp = userInformationArray[3].trim().substring(1); addressTmp = addressTmp.substring(0,addressTmp.length()-1);
        String photoIdTmp = userInformationArray[4].trim().substring(1); photoIdTmp = photoIdTmp.substring(0,photoIdTmp.length()-1);
        String userTypeTmp = userInformationArray[5].trim().substring(1); userTypeTmp = userTypeTmp.substring(0,userTypeTmp.length()-1);
        String phoneNumberTmp = userInformationArray[6].trim().substring(1); phoneNumberTmp = phoneNumberTmp.substring(0,phoneNumberTmp.length()-1);
        //System.out.println("-->"+emailTmp+":"+passwordTmp+":"+":"+nameTmp+":"+":"+addressTmp+":"+":"+photoIdTmp+":"+":"+userTypeTmp+":"+":"+phoneNumberTmp);
        return new RegisteredUser(emailTmp,passwordTmp,nameTmp,addressTmp,photoIdTmp,userTypeTmp, phoneNumberTmp);
    }

    public static RegisteredUser retrieveInformationFromUserDB(String enteredEmail, String enteredPassword){
        String userEmail, userPassword;
        String userInformationArray[] = null;
        try {
            BufferedReader userDBBufferedReader = new BufferedReader(new FileReader(userDBFile));
            String userInformation;
            while ((userInformation = userDBBufferedReader.readLine()) != null){
                userInformationArray = userInformation.split(constant.REGEX, -1);
                userEmail = userInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
                userPassword = userInformationArray[1].trim().substring(1); userPassword = userPassword.substring(0,userPassword.length()-1);
               
                if(userEmail.equals(enteredEmail) && userPassword.equals(enteredPassword)){
                   //System.out.println("Here"+userInformation);
                    userDBBufferedReader.close();
                    return RegisteredUser.getRegisteredUser(userInformation);
                }
            }
            userDBBufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateUserInformationInUserDB(String enteredEmail, RegisteredUser updatedUser){
        if(updatedUser == null)
            return false;
        String updatedUserDBFileData="";
        String userEmail;
        String userInformationArray[] = null;

        try {
            BufferedReader userDBBufferedReader = new BufferedReader(new FileReader(userDBFile));
            String userInformation;
            boolean isUpdated = false;
            while ((userInformation = userDBBufferedReader.readLine()) != null){
                userInformationArray = userInformation.split(constant.REGEX, -1);
                userEmail = userInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
                if(userEmail.equals(enteredEmail) == false){
                    updatedUserDBFileData = updatedUserDBFileData+ userInformation + "\n";
                }
                else{
                    //System.out.println("Updated");
                    isUpdated = true;
                    updatedUserDBFileData = updatedUserDBFileData + updatedUser.toString() + "\n";
                }
            }

            userDBBufferedReader.close();
            if(isUpdated == true){
                FileWriter userDBBfileWriter = new FileWriter(userDBFile.getName(),false);
                BufferedWriter bw = new BufferedWriter(userDBBfileWriter);
                bw.write(updatedUserDBFileData);
                bw.close();
            }
            return isUpdated;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean writeInToUserDB(RegisteredUser registeredUser){
        try {
            if(!userDBFile.exists()) {
                userDBFile.createNewFile();
            }
            String userEmail, userPassword;
            String userInformationArray[] = null;

            try {
                BufferedReader userDBBufferedReader = new BufferedReader(new FileReader(userDBFile));
                String userInformation;
                while ((userInformation = userDBBufferedReader.readLine()) != null){
                    userInformationArray = userInformation.split(constant.REGEX, -1);
                    userEmail = userInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
                    userPassword = userInformationArray[1].trim().substring(1); userPassword = userPassword.substring(0,userPassword.length()-1);
                    //System.out.println(userEmail+" : "+userPassword);
                    if(userEmail.equals(registeredUser.getEmail()) && userPassword.equals(registeredUser.getPassword())){
                        System.out.println("User Already Present!");
                        userDBBufferedReader.close();
                        return false;
                    }
                }
                userDBBufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            FileWriter userDBBfileWriter = new FileWriter(userDBFile.getName(),true);
            BufferedWriter bw = new BufferedWriter(userDBBfileWriter);
            bw.write(registeredUser.toString()+"\n");
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private String email;
    private String password;
    private String name;
    private String address;
    private String photoId;
    private String userType;
    private String phoneNumber;

    public static void main(String []args){
        System.out.println("Enter Email, password, name, address, iGoCardNumber, userType, phone number");
        Scanner scanner = new Scanner(System.in);
        String emailTmp = scanner.nextLine();
        String passwordTmp = scanner.nextLine();
        String nameTmp = scanner.nextLine();
        String addressTmp = scanner.nextLine();
        String iGoCardNumberTmp = scanner.nextLine();
        String userTypeTmp = scanner.nextLine();
        String phoneNumberTmp = scanner.nextLine();
        RegisteredUser registeredUser = new RegisteredUser(emailTmp,passwordTmp,nameTmp,addressTmp,iGoCardNumberTmp,userTypeTmp, phoneNumberTmp);

        System.out.println(writeInToUserDB(registeredUser));

        RegisteredUser retrievedRegisteredUser = retrieveInformationFromUserDB(emailTmp,passwordTmp);
        System.out.println(retrievedRegisteredUser);

        RegisteredUser userTmp = getRegisteredUser("\"shubham.patel\", \"abc@123\", \"Shubham Patel\", \"1645 Bould.\", \"s_1235\", \"Student\", \"1233444\"");

        System.out.println(updateUserInformationInUserDB("shubh.patel", userTmp));
    }

}
