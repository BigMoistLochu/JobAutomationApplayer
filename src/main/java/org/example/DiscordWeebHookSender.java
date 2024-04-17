package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.JobOffertDto;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class DiscordWeebHookSender{

    private DiscordWeebHookSender(){}
    public static void sendOfferToDiscordChannel(JobOffertDto jobOffertDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL obj = new URL("https://discord.com/api/webhooks/1108811425553600593/WVNI2SCM9oORhVU5FaiAOozpNTQkahsetmwOreJDsO7-81W-2AraP7vbdNxoyeGT8Wx7");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        os.write(mapper.writeValueAsBytes(jobOffertDto));
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();

        if(responseCode==204)
        {
            System.out.println("pomyslnie wyslano nowa oferte na discord");
        }
        else{
            System.out.println("cos poszlo nie tak kod:"+ responseCode);
        }

    }








}
