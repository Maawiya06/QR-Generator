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
}
