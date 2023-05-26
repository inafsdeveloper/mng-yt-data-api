package png.springframework.mngytdataapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import png.springframework.mngytdataapi.model.Channel;
import png.springframework.mngytdataapi.services.ChannelService;


import java.util.List;

@RequestMapping("/api")
@RestController
public class ChannelController {
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("channels")
    List<Channel> getChannels() {
       return channelService.findAll();
    }
}
