package com.orangeside.authorization.controller.rest;


import com.orangeside.authorization.security.OrangeSideSecurityUser;
import com.orangeside.authorization.security.http.OrangeSideAuthenticationRequest;
import com.orangeside.authorization.security.http.OrangeSideHttpAuthenticationDetails;
import com.orangeside.authorization.utils.TokenUtils;
import com.orangeside.common.utils.HttpResponseUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
public class AuthenticationController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Value("${security.token.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public ResponseEntity<?> authenticationRequest(@RequestBody OrangeSideAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // Perform the authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword()
        );
        usernamePasswordAuthenticationToken.setDetails(new OrangeSideHttpAuthenticationDetails());

        Authentication authentication = null;
        try {
            authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if (authentication == null) {
                return ResponseEntity.ok(HttpResponseUtil.error("未检测到验证信息"));
            }
        } catch (InternalAuthenticationServiceException failed) {
            logger.error("An internal error occurred while trying to authenticate the user.", failed);
            return ResponseEntity.ok(HttpResponseUtil.error(failed.getMessage()));
        } catch (AuthenticationException failed) {
            // Authentication failed
            return ResponseEntity.ok(HttpResponseUtil.error(failed.getMessage()));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = this.tokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(HttpResponseUtil.success(token));
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        OrangeSideSecurityUser user = (OrangeSideSecurityUser) this.userDetailsService.loadUserByUsername(username);
        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
            String refreshedToken = this.tokenUtils.refreshToken(token);
            return ResponseEntity.ok(HttpResponseUtil.success(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(HttpResponseUtil.error());
        }
    }


    @RequestMapping(value = "protected", method = RequestMethod.GET)
    public ResponseEntity<?> protect() {
        return ResponseEntity.ok(HttpResponseUtil.data("YEAH!"));
    }

}
