package springbootfilter.springbootfilter.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        // 这里需要重写ResponseWrapper，因为原方法是没有获取返回值的功能
        ResponseWrapper wrapperResponse = new ResponseWrapper((HttpServletResponse) response);
        // 这里只拦截返回，直接让请求过去，如果在请求前有处理，可以在这里处理
        filterChain.doFilter(request, wrapperResponse);
        byte[] content = wrapperResponse.getContent();//获取返回值
        // 判断是否有值
        if (content.length > 0) {
            // 这里是返回的内容
            String str = new String(content, "UTF-8");
            System.out.println("拦截的返回值:" + str);
            String strChange = null;
            try {
                strChange="拦截到你啦！";
            } catch (Exception e) {
                e.printStackTrace();
            }
            //把返回值输出到客户端
            response.setContentLength(strChange.length());
            ServletOutputStream out = response.getOutputStream();
            out.write(strChange.getBytes());
            out.flush();
        }

    }
}

