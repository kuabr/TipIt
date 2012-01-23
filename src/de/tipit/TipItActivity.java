package de.tipit;

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
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import de.tipit.R.id;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.UserSessionInvocation;
import de.tipit.server.transfer.access.user_session.DoLogin;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.LoginParameterTO;
import de.tipit.server.transfer.data.SessionTO;
import de.tipit.server.transfer.data.UserAccountTO;

public class TipItActivity extends Activity {

    private static String serverAddress = "192.168.0.120";
    // TODO: read address from formular or XML-file

    private static int serverPort = 8080;

    private static SessionTO session = new SessionTO();

    // TODO: put following method to a separate class
    private static SessionTO doLogin(Context ac, String userName, String password) {
        // create transfer objects
        ContextTO context = new ContextTO();
        context.setLanguage(ContextTO.Language.DE);
        UserAccountTO userAccount = new UserAccountTO();
        userAccount.setUserName(userName);
        userAccount.setPassword(password);
        LoginParameterTO loginParameter = new LoginParameterTO();
        loginParameter.setSessionDuration(LoginParameterTO.SessionDuration.DAY);
        loginParameter.setKillOldSessions(false);

        // create objects for invocation
        DoLogin doLogin = new DoLogin();
        doLogin.setContext(context);
        doLogin.setUserAccount(userAccount);
        doLogin.setLoginParameter(loginParameter);
        UserSessionInvocation invocation = new UserSessionInvocation(doLogin);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        String data = null;
        try {
            serializer.write(invocation, out);
            data = out.toString("UTF-8");
        } catch (Exception e) {
            Toast toast = Toast.makeText(ac, e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
            return null;
        }

        // execute login on server
        BufferedReader in = null;
        try {
            // do post to server
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost();
            post.setURI(new URI("http://" + serverAddress + ":" + serverPort + "/TipItServer/UserSession"));
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair("data", data));
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

            // create object
            InvocationResult result = serializer.read(InvocationResult.class, text);
            if (result.getError() != null) {
                Toast toast = Toast.makeText(ac, result.getError().getDisplayMessage(), Toast.LENGTH_LONG);
                toast.show();
                return null;
            } else {
                DoLogin.Result resultData = (DoLogin.Result) result.getData();
                return resultData.getSession();
            }
        } catch (Throwable t) {
            Toast toast = Toast.makeText(ac, t.getMessage(), Toast.LENGTH_LONG);
            toast.show();
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Toast toast = Toast.makeText(ac, e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                    return null;
                }
            }
        }
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button loginButton = (Button) findViewById(+id.buttonLogin);
        loginButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText userNameItem = (EditText) findViewById(+id.editText1);
                EditText passwordItem = (EditText) findViewById(+id.editText2);

                session = doLogin(getApplicationContext(), userNameItem.getText().toString(), passwordItem.getText().toString());
                // TODO: execute 'doLogin' in a thread
                if (session != null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Herzlich willkommen '" + session.getUserName() + "' !!!", Toast.LENGTH_LONG);
                    toast.show();
                    startActivity(new Intent(TipItActivity.this, OverviewActivity.class));
                }
            }
        });
    }
}
