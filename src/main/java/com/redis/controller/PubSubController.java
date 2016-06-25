package com.redis.controller;

import com.redis.domain.MessageList;
import com.redis.service.impl.PubServiceImpl;
import com.redis.service.impl.SubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "/pubsub")
public class PubSubController {
    @Resource(name = "pubServiceImpl")
    private PubServiceImpl pubService;

    @Autowired
    private SubServiceImpl subService;

    @RequestMapping(value = "/sub")
    public String Subscriber(Model model) {
        MessageList messageList = subService.getMessageList();
        ArrayList<String> arrayList = (ArrayList<String>) messageList.output();
        model.addAttribute("allMsg", arrayList);
        return "/WEB-INF/jsp/subResult.jsp";
    }

    @RequestMapping(value = "/pub", method = RequestMethod.GET)
    public String Subscriber() {
        return "/WEB-INF/jsp/pub.jsp";
    }

    @RequestMapping(value = "/pub", method = RequestMethod.POST)
    public String Publisher(
            @RequestParam(value = "message", required = true) String message) {
        pubService.Publisher(message);
        return "/WEB-INF/jsp/pubResult.jsp";
    }
}
