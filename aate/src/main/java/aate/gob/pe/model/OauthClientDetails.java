package aate.gob.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="OAUTH_CLIENT_DETAILS ")
@Entity(name = "OauthClientDetails")
public class OauthClientDetails {
	
	  @Id
	  @Column(name = "CLIENT_ID", nullable = true)
	  private String client_id;
	  @Column(name = "RESOURCE_IDS", nullable = true)
	  private String resource_ids;
	  @Column(name = "CLIENT_SECRET", nullable = true)
	  private String client_secret;
	  @Column(name = "SCOPE", nullable = true)
	  private String scope;
	  @Column(name = "AUTHORIZED_GRANT_TYPES", nullable = true)
	  private String authorized_grant_types;
	  @Column(name = "WEB_SERVER_REDIRECT_URI", nullable = true)
	  private String web_server_redirect_uri;
	  @Column(name = "AUTHORITIES", nullable = true)
	  private String authorities;
	  @Column(name = "ACCESS_TOKEN_VALIDITY", nullable = true)
	  private Integer access_token_validity;
	  @Column(name = "REFRESH_TOKEN_VALIDITY", nullable = true)
	  private Integer refresh_token_validity;
	  @Column(name = "ADDITIONAL_INFORMATION", nullable = true)
	  private String additional_information;
	  @Column(name = "AUTOAPPROVE", nullable = true)
	  private String autoapprove;
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getResource_ids() {
		return resource_ids;
	}
	public void setResource_ids(String resource_ids) {
		this.resource_ids = resource_ids;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getAuthorized_grant_types() {
		return authorized_grant_types;
	}
	public void setAuthorized_grant_types(String authorized_grant_types) {
		this.authorized_grant_types = authorized_grant_types;
	}
	public String getWeb_server_redirect_uri() {
		return web_server_redirect_uri;
	}
	public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
		this.web_server_redirect_uri = web_server_redirect_uri;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public Integer getAccess_token_validity() {
		return access_token_validity;
	}
	public void setAccess_token_validity(Integer access_token_validity) {
		this.access_token_validity = access_token_validity;
	}
	public Integer getRefresh_token_validity() {
		return refresh_token_validity;
	}
	public void setRefresh_token_validity(Integer refresh_token_validity) {
		this.refresh_token_validity = refresh_token_validity;
	}
	public String getAdditional_information() {
		return additional_information;
	}
	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}
	public String getAutoapprove() {
		return autoapprove;
	}
	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}
	  
	  
}
