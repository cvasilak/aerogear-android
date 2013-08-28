package org.jboss.aerogear.android.authentication;

import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OAuthAuthenticationConfig extends AuthenticationConfig {
    
    private String responseType = "token";
    private String approvalPrompt = "auto";
    private String accessType = "online";
    private String loginHint = "email";
    private Uri redirectUri;
    private Set<String> scopes = new HashSet<String>();
    private String state;
    private String client_id;
    private Map<String, String> extraParams = new HashMap<String, String>();

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getApprovalPrompt() {
        return approvalPrompt;
    }

    public void setApprovalPrompt(String approvalPrompt) {
        this.approvalPrompt = approvalPrompt;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getLoginHint() {
        return loginHint;
    }

    public void setLoginHint(String loginHint) {
        this.loginHint = loginHint;
    }

    public Uri getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(Uri redirectUri) {
        this.redirectUri = redirectUri;
    }

    public Collection<String> getScopes() {
        return Collections.unmodifiableCollection(scopes);
    }
    
    public void addScope(String scope) {
        scopes.add(scope);
    }

    public void removeScope(String scope) {
        this.scopes.remove(scope);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void addExtra(String key, String value) {
        extraParams.put(key, value);
    }

    public void clearExtraParam(String key) {
        this.extraParams.remove(key);
    }
    
    public Map<String, String> getExtraParams() {
        return Collections.unmodifiableMap(extraParams);
    }
    
}
