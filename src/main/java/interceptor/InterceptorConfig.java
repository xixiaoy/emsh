package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration            //将该类交给工厂创建对象
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    //注册对应的拦截器
    public void addInterceptors(InterceptorRegistry registry){
                //想注册中心注册对应的拦截器
        registry.addInterceptor(loginInterceptor)
                //该注册器并拦截该类Action下的所有Action
                .addPathPatterns("/**")
                //排除给类目录下的此Action
                .excludePathPatterns("/user/login");
    }


}
