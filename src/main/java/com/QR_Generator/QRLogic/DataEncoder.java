package com.QR_Generator.QRLogic;

import java.awt.*;

import static java.awt.SystemColor.text;

public class DataEncoder {
    public String encodeData(String text, EncodingMode mode){
        int len = text.length();
        StringBuilder result = new StringBuilder();

        if(mode == EncodingMode.ByteMode){
            for(int i = 0; i < len; i++){
                char ch = text.charAt(i);
                // get ASII
                int val = (int) ch;
                // Convert to binary
                String ans = Integer.toBinaryString(val);
                // make it 8 bit
                while(ans.length() < 8){
                    ans = "0" + ans;
                }
                result.append(ans);
            }
        }
        return result.toString();
    }


    public String bitStreamBuilder(String text){
        ModelSwitcher detector = new ModelSwitcher();
        EncodingMode mode = detector.DetectionMode(text);

        String modebits =detector.getModeIndicator(mode);
        String chartobinary = detector.getCharacterCountBinary(text, mode);

        DataEncoder dataEncoder = new DataEncoder();
        String encode = dataEncoder.encodeData(text, mode);

        String finalbits = modebits + chartobinary + encode;

        StringBuilder bits = new StringBuilder(finalbits);
        bits.append("0000");

        if(Integer.parseInt(String.valueOf(bits)) % 8 == 0){
            return String.valueOf(bits);
        }
        else{
            bits.append("0000");
        }
        return String.valueOf(bits);
    }

    public static void main(String[] args){
        DataEncoder data = new DataEncoder();
        String str = data.bitStreamBuilder("Hello World");
        System.out.println(str.length());
    }
}
