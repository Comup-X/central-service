package com.comup.user.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Comup
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {
    private final ConsumerTokenServices consumerTokenServices;

    @Autowired
    public RevokeTokenEndpoint(@Qualifier("consumerTokenServices") ConsumerTokenServices consumerTokenServices) {
        this.consumerTokenServices = consumerTokenServices;
    }

    @ResponseBody
    @DeleteMapping("/oauth/token")
    public String revokeToken(String accessToken) {
        if (consumerTokenServices.revokeToken(accessToken)) {
            return "注销成功";
        }
        return "注销失败";
    }
}
