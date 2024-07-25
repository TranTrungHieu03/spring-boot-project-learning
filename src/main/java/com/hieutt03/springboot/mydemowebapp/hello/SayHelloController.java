package com.hieutt03.springboot.mydemowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.Buffer;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
         return "Hello! What are you doing?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Hello World</h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    //"say-hello-jsp" => sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jps/welcome.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jps/login.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jps/todos.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }


}
