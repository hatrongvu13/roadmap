package org.jax.selenium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;

public class Application {
    public static void main(String[] args) {
        System.out.println("Jax tony");
        try {
            URL url = new URL("https://cafebiz.vn/tai-chinh.rss");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//            System.out.println(in);
            String sourceCode = "";
            String line;
            while((line=in.readLine())!=null){
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
