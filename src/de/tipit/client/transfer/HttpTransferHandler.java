package de.tipit.client.transfer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.xml.Matcher;

public class HttpTransferHandler implements TransferHandler {

    protected static final Matcher matcher = new Matcher();

    protected static final int CONNECTION_TIMEOUT_MILLIS = 2000;

    protected static final int SOCKET_TIMEOUT_MILLIS = 8000;

    protected static final String DATA_PARAMETER_NAME = "data";

    protected final String httpAddress;

    protected final int port;

    public HttpTransferHandler(final String httpAddress, final int port) {
        this.httpAddress = httpAddress;
        this.port = port;
    }

    @Override
    public ResultData doTransfer(final Object invocationObject, final String serviceName) throws GeneralError {
        // serialize invocation object into a string
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Serializer serializer = new Persister(HttpTransferHandler.matcher);
        String data = null;
        try {
            serializer.write(invocationObject, out);
            data = out.toString("UTF-8");
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

        // invoke object on server
        BufferedReader in = null;
        try {
            // create the HTTP client
            HttpClient client = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(client.getParams(), CONNECTION_TIMEOUT_MILLIS);
            HttpConnectionParams.setSoTimeout(client.getParams(), SOCKET_TIMEOUT_MILLIS);

            // do post data to server
            HttpPost post = new HttpPost();
            post.setURI(new URI("http://" + httpAddress + ":" + port + "/TipItServer/" + serviceName));
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair(DATA_PARAMETER_NAME, data));
            post.setEntity(new UrlEncodedFormEntity(pairs));
            HttpResponse response = client.execute(post);

            // evaluate response
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String newLine = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + newLine);
            }
            in.close();
            String text = sb.toString();

            // create resulting object
            InvocationResult result = serializer.read(InvocationResult.class, text);
            if (result.getError() != null) {
                throw new GeneralError(result.getError().getDisplayMessage());
            } else {
                return result.getData();
            }
        } catch (GeneralError error) {
            throw error; // re-throw error (-exception)
        } catch (RuntimeException exc) {
            throw exc; // re-throw exception
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException exc) {
                    throw new RuntimeException(exc);
                }
            }
        }
    }
}
