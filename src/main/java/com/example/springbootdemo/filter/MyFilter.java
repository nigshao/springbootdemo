package com.example.springbootdemo.filter;

import com.example.springbootdemo.domain.MyRequestWrapper;
import com.example.springbootdemo.util.MDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@Component
@WebFilter
public class MyFilter implements Filter {

    Logger log = LoggerFactory.getLogger(MyFilter.class);


    Logger server_log = com.example.springbootdemo.util.LoggerFactory.getServerInfoLogger(MyFilter.class);

    @Value("${permitted-ips}")
    private String[] permittedIps;

    @Value("${secret}")
    private String secret;

    @Value("${secretSwitch}")
    private String secretSwitch;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        server_log.info("entre authentic  filter！:" + permittedIps[0]);
        if (Boolean.valueOf(secretSwitch)) {
            HttpServletRequest res = (HttpServletRequest) servletRequest;
            HttpServletResponse rep = (HttpServletResponse) servletResponse;
            String authorization = res.getHeader("Authorization");
            if (StringUtils.isEmpty(authorization)) {
                rep.sendError(333, "anthorization is null!");
                return;
            }
            server_log.info("auth authrization :" + authorization);
            String[] authparams = authorization.split(",");
            //cardid="1234554321",timestamp="9897969594",signature="a69eae32a0ec746d5f6bf9bf977"
            String cardid = authparams[0].substring(authparams[0].indexOf("=") + 2, authparams[0].length() - 1);

            String timestamp = authparams[1].substring(authparams[1].indexOf("=") + 2, authparams[1].length() - 1);

            String signature = authparams[2].substring(authparams[2].indexOf("=") + 2, authparams[2].length() - 1);
            server_log.info(" cardid :" + cardid + " timestamp : " + timestamp + " signature: " + signature);
            MyRequestWrapper requestWrapper = new MyRequestWrapper(res);
            String bodydata = requestWrapper.getBody();
            String newSignature = "";
            try {
                MDUtils.MD5EncodeForHex(timestamp + secret + bodydata, "utf-8");

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (newSignature.equals(signature)) {
                filterChain.doFilter(res, rep);
                return;
            }
            try {
                throw new Exception("auth authrization failure=========");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);
        server_log.info("entre here !");
        return;
    }

    @Override
    public void destroy() {

    }

}