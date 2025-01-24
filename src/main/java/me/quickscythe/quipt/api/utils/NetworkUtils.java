/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.quickscythe.quipt.api.utils;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Base64;
import java.util.logging.Logger;


/**
 * A utility class for network operations
 */
public class NetworkUtils {

    /**
     * Private constructor to prevent instantiation
     */
    private NetworkUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Downloads a file from a URL
     *
     * @param url  The URL to download from
     * @param auth The authentication to use
     * @return The InputStream of the file
     */
    public static InputStream downloadFile(String url, String... auth) {
        try {
            URL myUrl = new URI(url).toURL();
            HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
            conn.setDoOutput(true);
            conn.setReadTimeout(30000);
            conn.setConnectTimeout(30000);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestMethod("GET");

            if (auth != null && auth.length >= 2) {
                String userCredentials = auth[0].trim() + ":" + auth[1].trim();
                String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
                conn.setRequestProperty("Authorization", basicAuth);
            }
            return conn.getInputStream();
        } catch (Exception ex) {
            Logger.getLogger("Core").info("An error occurred while downloading file");
        }
        return InputStream.nullInputStream();
    }

    /**
     * Saves an InputStream to a FileOutputStream
     *
     * @param in  The InputStream to save
     * @param out The FileOutputStream to save to
     */
    public static void saveStream(InputStream in, FileOutputStream out) {
        try {
            int c;
            byte[] b = new byte[1024];
            while ((c = in.read(b)) != -1) out.write(b, 0, c);

            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger("Core").info("An error occurred while saving file");
        }
    }
}
