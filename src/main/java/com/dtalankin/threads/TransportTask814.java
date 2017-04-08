/**
 *  26.03.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TransportTask814 {

    public void sendToFile(MessageTask814 message) {
        String outPutText = "From: " + message.getSender() + "\n";
        outPutText += "To: " + message.getEmailAddress() + "\n";
        outPutText += "Subj: " + message.getSubject() + "\n";
        outPutText += "Body: " + message.getBody() + "\n";
        String file = "src/test/resources/com/dtalankin/Lesson8/output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file),true))) {
            bw.write(outPutText);
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("I'm in the transport");
    }
}
