package iut.paci.noelcommunity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class DistrictTask extends AsyncTask<String, Void, String> {
    private MapActivity activity;
    private ProgressDialog pDialog;

    DistrictTask(MapActivity activity){
        this.activity = activity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Attempting to get district information...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String[] args) {
        String result = "";
        InputStream stream = null;
        HttpURLConnection con = null;

        try {
            URL url = new URL(args[0]);
            con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(10000);
            con.setConnectTimeout(10000);
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.connect();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK)
                throw new IOException("HTTP error code: " + con.getResponseCode());
            stream = con.getInputStream();
            BufferedReader buffer =
                    new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String line;
            while ((line = buffer.readLine()) != null)
                result += line + "\n";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
                con.disconnect();
            } catch (IOException|NullPointerException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        pDialog.dismiss();
        Log.d("MapActivity", result);

        District district = District.fromJson(result);
        this.activity.drawDistrict(district);

    }
}