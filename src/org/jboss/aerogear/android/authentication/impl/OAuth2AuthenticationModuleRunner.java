/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.aerogear.android.authentication.impl;

import java.net.URL;
import java.util.Map;
import org.jboss.aerogear.android.authentication.OAuthAuthenticationConfig;
import org.jboss.aerogear.android.http.HeaderAndBody;

/**
 *
 * @author Summers Pittman secondsun@gmail.com
 */
class OAuth2AuthenticationModuleRunner  extends
        AbstractAuthenticationModuleRunner { 

    private final OAuthAuthenticationConfig config;

    public OAuth2AuthenticationModuleRunner(URL baseURL, OAuthAuthenticationConfig config) {
        super(baseURL, config);
        this.config = config;
    }

    @Override
    HeaderAndBody onEnroll(Map<String, String> userData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    HeaderAndBody onLogin(String username, String password) {
        return null;
    }

    @Override
    void onLogout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
