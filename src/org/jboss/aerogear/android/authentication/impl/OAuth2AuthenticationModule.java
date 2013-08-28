
package org.jboss.aerogear.android.authentication.impl;

import android.util.Log;
import java.net.URI;
import java.net.URL;
import org.jboss.aerogear.android.Callback;
import org.jboss.aerogear.android.authentication.AbstractAuthenticationModule;
import org.jboss.aerogear.android.authentication.AuthenticationConfig;
import org.jboss.aerogear.android.authentication.AuthorizationFields;
import org.jboss.aerogear.android.authentication.OAuthAuthenticationConfig;
import org.jboss.aerogear.android.http.HeaderAndBody;
import org.jboss.aerogear.android.http.HttpException;

public class OAuth2AuthenticationModule extends AbstractAuthenticationModule {

    
    private static final String TAG = OAuth2AuthenticationModule.class.getSimpleName();

    private boolean isLoggedIn = false;

    private final OAuth2AuthenticationModuleRunner runner;
    private String accessToken;

    public OAuth2AuthenticationModule(URL baseURL, OAuthAuthenticationConfig config) {
        this.runner = new OAuth2AuthenticationModuleRunner(baseURL, config);
    }

    @Override
    public void login(final String username,final  String password,final  Callback<HeaderAndBody> callback) {
        THREAD_POOL_EXECUTOR.execute(new Runnable() {

            @Override
            public void run() {
                HeaderAndBody result = null;
                Exception exception = null;

                try {
                    result = runner.onLogin(username, password);
                    isLoggedIn = true;
                } catch (Exception e) {
                    Log.e(TAG, "Error with Login", e);
                    exception = e;
                }
                if (exception == null) {
                    callback.onSuccess(result);
                } else {
                    callback.onFailure(exception);
                }                
            }
        });
    }
 
    
    
    @Override
    public URL getBaseURL() {
        return runner.getBaseURL();
    }

    @Override
    public String getLoginEndpoint() {
        return runner.getLoginEndpoint();
    }

    @Override
    public String getLogoutEndpoint() {
        return runner.getLogoutEndpoint();
    }

    @Override
    public String getEnrollEndpoint() {
        return runner.getEnrollEndpoint();
    }
    
    @Override
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public AuthorizationFields getAuthorizationFields() {
        return getAuthorizationFields(null,null,null);
    }

    @Override
    public AuthorizationFields getAuthorizationFields(URI requestUri, String method, byte[] requestBody) {
        AuthorizationFields fields = new AuthorizationFields();
        fields.addHeader("Authorization", "Bearer " + accessToken);
        return fields;
    }

    @Override
    public boolean retryLogin() throws HttpException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
