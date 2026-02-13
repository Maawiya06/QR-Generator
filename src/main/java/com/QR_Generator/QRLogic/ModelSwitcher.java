package com.QR_Generator.QRLogic;

import static com.QR_Generator.QRLogic.EncodingMode.*;

public class ModelSwitcher {

    boolean isNumeric = true;
    boolean isAlphaNumeric = true;

    String allowed = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:";

    public EncodingMode DetectionMode(String input){
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            // check for character is digit
            if(!Character.isDigit(ch)){
                isNumeric = false;
            }
            // check characters are in alphanumeric
            if (allowed.indexOf(ch) == -1) {
                isAlphaNumeric = false;
            }
        }

        if(isNumeric) return NumericMode;
        else if(isAlphaNumeric) return AlphaNumericMode;
        else return ByteMode;
    }

    ErrorCorrectionLevel level = ErrorCorrectionLevel.M;
    // here we return fix all bit
    public String getModeIndicator(EncodingMode mode){
        if(mode == NumericMode) return "0001";
        else if(mode == AlphaNumericMode) return "0010";
        else return "0100";
    }

    public String getCharacterCountBinary(String text, EncodingMode mode){

        int length = text.length();
        String binary = Integer.toBinaryString(length);

        int requiredBits = 0;

        if(mode == EncodingMode.NumericMode){
            requiredBits = 10;
        }
        else if(mode == EncodingMode.AlphaNumericMode){
            requiredBits = 9;
        }
        else{
            requiredBits = 8;
        }

        // left padding
        while(binary.length() < requiredBits){
            binary = "0" + binary;
        }

        return binary;
    }
}
