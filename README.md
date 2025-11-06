# OAuth2App

  - Configuration
    - Example application.properties file

		```
		# Spring Boot Configuration
		server.port=8080
		spring.application.name=cas-oauth2-client
		
		# --- CAS SERVER (Authorization Server) CONFIGURATION ---
		# IMPORTANT: These settings assume your local CAS server runs on https://localhost:8443/cas
		cas.server.base-url=https://localhost:8443/cas
		
		# 1. OAuth2 Client Registration
		# This 'cas-server' name links the client registration to the provider configuration below.
		spring.security.oauth2.client.registration.cas-server.client-id=cas-client
		spring.security.oauth2.client.registration.cas-server.client-secret=secret-12345
		spring.security.oauth2.client.registration.cas-server.client-authentication-method=client_secret_basic
		spring.security.oauth2.client.registration.cas-server.authorization-grant-type=authorization_code
		spring.security.oauth2.client.registration.cas-server.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}
		# Use 'openid profile' for standard attributes
		spring.security.oauth2.client.registration.cas-server.scope=openid,profile
		spring.security.oauth2.client.registration.cas-server.client-name=CAS OAuth2 Client
		
		# 2. OAuth2 Provider Configuration (Endpoints for CAS)
		spring.security.oauth2.client.provider.cas-server.authorization-uri=${cas.server.base-url}/oauth2.0/authorize
		spring.security.oauth2.client.provider.cas-server.token-uri=${cas.server.base-url}/oauth2.0/accessToken
		spring.security.oauth2.client.provider.cas-server.user-info-uri=${cas.server.base-url}/oauth2.0/profile
		spring.security.oauth2.client.provider.cas-server.user-info-authentication-method=header
		# The 'id' attribute is the CAS default for the principal's username/ID
		spring.security.oauth2.client.provider.cas-server.user-name-attribute=id
		spring.security.oauth2.client.provider.cas-server.jwk-set-uri=${cas.server.base-url}/oauth2.0/jwks
		```
		