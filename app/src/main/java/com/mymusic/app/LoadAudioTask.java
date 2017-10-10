package com.mymusic.app;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Konstantin on 18/09/2017.
 */

public class LoadAudioTask extends AsyncTask<String, Void, ArrayList> {

    protected ArrayList doInBackground(String... urls) {

        ArrayList audioList = new ArrayList<>();

        try {

            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();

            String result = InputStreamOperations.InputStreamToString(inputStream);
            connection.disconnect();
            inputStream.close();

            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = new JSONObject(array.getString(i));
                String data = obj.getString("url");
                String title = obj.getString("title");
                String album = obj.getString("title");
                String artist = obj.getString("artist");
                String image = "http://mymusic.konstantin-sidorenko.fr/img/no-media.gif";
                try {
                    image = obj.getString("image");
                } catch (JSONException e) {}

                /*final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;

                Bitmap imgBitmap imgBitmap = BitmapFactory.decodeStream(new java.net.URL(image).openStream(), null, options);
                imgBitmap = Bitmap.createScaledBitmap(imgBitmap, 120, 120, false);*/

                audioList.add(new Audio(data, title, album, artist, image, null));

            }
            return audioList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    protected void onPostExecute(ArrayList audioList) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}