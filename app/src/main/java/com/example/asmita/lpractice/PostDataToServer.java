package com.example.asmita.lpractice;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.asmita.lpractice.PostDataToServer.RequestMethod.GET;
import static com.example.asmita.lpractice.PostDataToServer.RequestMethod.POST;

/**
 * Created by Asmita on 02-10-2016.
 */
class PostDataToServer extends AsyncTask<String,String,String> {
    private static final String TAG = PostDataToServer.class.getSimpleName();

    public enum RequestMethod {
        POST,
        GET
    }

    private final RequestMethod mRequestMethod;
    private final String mServerUrl;
    private final CommunicationResultListener mListener;

    PostDataToServer(final String protocol,
                     final String baseUrl,
                     final String remoteMethod,
                     final CommunicationResultListener listener) {
        this(protocol, baseUrl, remoteMethod, POST, listener);
    }

    PostDataToServer(final String protocol,
                     final String baseUrl,
                     final String remoteMethod,
                     final RequestMethod requestMethod,
                     final CommunicationResultListener listener) {
        mServerUrl = protocol + baseUrl + remoteMethod;
        mListener = listener;
        mRequestMethod = requestMethod;
    }

    @Override
    protected String doInBackground(String... params) {
        String inputJsonData = params[0];

        Log.i(TAG, "inputJsonData = " + inputJsonData);
        String serverResponse = null;
        try {
            serverResponse = executeHttpRequest(inputJsonData);
            mListener.onSuccess(serverResponse);
        } catch (IOException e) {
            mListener.onFailure(e);
            e.printStackTrace();
        }
        return null;
    }

    @NonNull
    private String executeHttpRequest(final String inputJsonData) throws IOException {
        HttpURLConnection urlConnection = null;
        try {
            switch (mRequestMethod) {
                case POST:
                    urlConnection = setupHttpURLConnection(mServerUrl);
                    connectUsingHttpPost(inputJsonData, urlConnection);
                    break;
                case GET:
                    String serverUrl = mServerUrl + "/" + inputJsonData;
                    urlConnection = setupHttpURLConnection(serverUrl);
                    connectUsingHttpGet(urlConnection);
                    break;
                default:
                    throw new IOException("Unknown HTTP method");
            }

            return getServerResponse(urlConnection);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    @NonNull
    private String getServerResponse(HttpURLConnection urlConnection) throws IOException {
        InputStream inputStream;

//input stream
        inputStream = urlConnection.getInputStream();
        if (inputStream == null) {
            // Nothing to do.
            throw new IOException("no response received from server");
        }

        String serverResponse = streamToString(inputStream);
//response data
        Log.i(TAG, "serverResponse = " + serverResponse);
//send to post execute
        return serverResponse;
    }

    private void connectUsingHttpPost(String inputJsonData, HttpURLConnection urlConnection) throws IOException {
        urlConnection.setDoOutput(true);
        // is output buffer writter
        urlConnection.setRequestMethod(mRequestMethod.name());

        //set headers and method
        Writer writer = new BufferedWriter(
                new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
        writer.write(inputJsonData);
// json data
        writer.close();
        urlConnection.connect();
    }

    private void connectUsingHttpGet(HttpURLConnection urlConnection) throws IOException {
        urlConnection.connect();
    }

    @NonNull
    private HttpURLConnection setupHttpURLConnection(final String serverUrl) throws IOException {
        Log.i(TAG, "Server URL = " + serverUrl);
        URL url = new URL(serverUrl);
        Log.i(TAG, "URL = " + url.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setRequestProperty("Accept", "application/json");
        return urlConnection;
    }

    private String streamToString(InputStream inputStream) throws IOException {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                buffer.append(inputLine + "\n");
            }
            if (buffer.length() == 0) {
                // Stream was empty. No point in parsing.
                throw new IOException("empty stream received from server");
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
    }
}
