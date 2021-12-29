package com.clean.architecture;

public class CPFValidator {
    
    private String cpf;
    private int firstDigit;
    private int secondDigit;
    private int CPF_LENGTH = 11;

    public CPFValidator(String cpf){
        this.cpf = cpf;
    }

    private void cleanCPF(){
        this.cpf = this.cpf.replaceAll("[^0-9]", "");
    }

    private boolean isValidLength(){
        return this.cpf.length() == CPF_LENGTH;
    }

    private boolean isDigitsEquals(){
        String[] digits = this.cpf.split("");
        String firstDigit = null;
        for(int indexDigi = 0; indexDigi < digits.length; indexDigi ++){
            if(indexDigi == 0){
                firstDigit = digits[indexDigi];
            }
            if(!digits[indexDigi].equals(firstDigit)){
                return false;
            }
        }
        return true;
    }

    private int calculateDigit(int factor){
        int total = 0;
        for(String digit : this.cpf.split("")){
            if(factor > 1) total += Integer.parseInt(digit) * factor --;
        }
        int rest = total % 11;
        return (rest < 11) ? 0 : (11 - rest);
    }

    private String extractVerifiesDigit(){
        return  cpf.substring(9);
    }

    public boolean validate(){
        if(this.cpf == null){
            return false;
        }
        this.cleanCPF();
        if(!this.isValidLength()){
            return false;
        }
        if(this.isDigitsEquals()){
            return false;
        }
        firstDigit = this.calculateDigit(10);
        secondDigit = this.calculateDigit(11);
        String verifierDigit = this.extractVerifiesDigit();
        String calculatedVerifiedDigiString = String.valueOf(firstDigit).concat(String.valueOf(secondDigit));
        return verifierDigit.equals(calculatedVerifiedDigiString);
    }
}
