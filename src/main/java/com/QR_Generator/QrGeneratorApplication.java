package com.QR_Generator;

import com.QR_Generator.QRLogic.DataEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

import static java.awt.SystemColor.text;

@SpringBootApplication
public class QrGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrGeneratorApplication.class, args);

//		DataEncoder data = new DataEncoder();
//		String str = data.bitStreamBuilder(String.valueOf(SystemColor.text));
 	}

}
