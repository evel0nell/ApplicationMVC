package test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping()
public class FirstController {


    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        model.addAttribute("message", "Hello" + " "+name +" "+ surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value= "name") String name,
                              @RequestParam(value = "surname", required= false) String surname,
                              Model model){
        model.addAttribute("message", "Goodbye"+ name+ surname);

        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "operation") String operation,
                             @RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             Model model){
        int result;
        switch (operation){
            case "multiplication": result = a*b; break;
            case "addition" : result = a+b; break;
            case "substraction" : result = a-b; break;
            default: result = 0;
        }
        model.addAttribute("operation", "Chosen operation: " + operation);
        model.addAttribute("result", "Result: " + String.valueOf(result));
        return "first/calculator";
    }

}
