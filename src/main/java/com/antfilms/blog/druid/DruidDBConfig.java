package com.antfilms.blog.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidDBConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> initParms=new HashMap<>();
        initParms.put("loginUsername","admin");
        initParms.put("loginPassword","123456");
        initParms.put("allow","");
        initParms.put("deny","192.168.1.35");
        servletRegistrationBean.setInitParameters(initParms);
        return  servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean webStatFilter()
    {
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParms=new HashMap<>();

        initParms.put("exclusion","*.js,*.css,/druid/*");
        bean.setInitParameters(initParms);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }

}
