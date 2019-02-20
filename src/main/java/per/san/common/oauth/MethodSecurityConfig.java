//package per.san.common.oauth;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
//
///**
// * description:
// *
// * @author Sanchar
// * @date 2/17/2019 16:47
// * lastUpdateBy: Sanchar
// * lastUpdateDate: 2/17/2019 16:47
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
//public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
//
//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        return new OAuth2MethodSecurityExpressionHandler();
//    }
//}
