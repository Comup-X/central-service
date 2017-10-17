package com.comup.auth.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

    private final ConsumerTokenServices consumerTokenServices;

    @Autowired
    public RevokeTokenEndpoint(@Qualifier("consumerTokenServices") ConsumerTokenServices consumerTokenServices) {
        this.consumerTokenServices = consumerTokenServices;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    public String revokeToken(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return "注销成功";
        } else {
            return "注销失败";
        }
    }
}
