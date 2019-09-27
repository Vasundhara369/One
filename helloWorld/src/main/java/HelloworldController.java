import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
    @RequestMapping("/sayHello")
    public HelloWorld sayHello(@RequestParam(value="name")String name)
    {

        return new HelloWorld(name);
    }
}
