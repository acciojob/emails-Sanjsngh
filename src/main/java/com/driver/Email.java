package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        boolean change = false;
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        if(!this.password.equals(oldPassword)) {
            return;
        }

        boolean isUpper = false;
        boolean isLower = false;
        boolean isDigit = false;
        boolean isSpecial = true;

        int n = newPassword.length();
        if(n < 8) {
            change = false;
            return;
        }
        for(int i = 0 ; i < n; i++) {
            char ch = newPassword.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                isSpecial = false;
                isUpper = true;
            }
            if(ch >= 'a' && ch <= 'z'){
                isSpecial = false;
                isLower = true;
            }
            if(ch >= '0' && ch <= '9'){
                isSpecial = false;
                isDigit = true;
            }
            if(isUpper && isLower && isDigit && isSpecial) {
                change = true;
                break;
            }
        }

        if(change) {
            this.password = newPassword;
        }
        return;

        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
