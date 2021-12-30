package com.clean.architecture;

public class CPF {
    
    private int firstDigit;
    private int secondDigit;
    private int CPF_LENGTH = 11;

    public CPF(String cpf) throws Exception{
        if(!this.validate(cpf)){
            throw new Exception("CPF Invalid");
        }
    }


    private boolean validate(String cpf){
        if(cpf == null){
            return false;
        }
        cpf = this.cleanCPF(cpf);
        if(!this.isValidLength(cpf)){
            return false;
        }
        if(this.isDigitsEquals(cpf)){
            return false;
        }
        firstDigit = this.calculateDigit(cpf, 10);
        secondDigit = this.calculateDigit(cpf, 11);
        String verifierDigit = this.extractVerifiesDigit(cpf);
        String calculatedVerifiedDigiString = String.valueOf(firstDigit).concat(String.valueOf(secondDigit));
        return verifierDigit.equals(calculatedVerifiedDigiString);
    }

    private String cleanCPF(String cpf){
        return cpf.replaceAll("[^0-9]", "");
    }

    private boolean isValidLength(String cpf){
        return cpf.length() == CPF_LENGTH;
    }

    private boolean isDigitsEquals(String cpf){
        String[] digits = cpf.split("");
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

    private int calculateDigit(String cpf, int factor){
        int total = 0;
        for(String digit : cpf.split("")){
            if(factor > 1) total += Integer.parseInt(digit) * factor --;
        }
        int rest = total % 11;
        return (rest < 2) ? 0 : (11 - rest);
    }

    private String extractVerifiesDigit(String cpf){
        return cpf.substring(9);
    }
}
