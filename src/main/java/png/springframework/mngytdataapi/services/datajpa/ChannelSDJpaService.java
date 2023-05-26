package png.springframework.mngytdataapi.services.datajpa;

import org.springframework.stereotype.Service;
import png.springframework.mngytdataapi.model.Channel;
import png.springframework.mngytdataapi.repositories.ChannelRepository;
import png.springframework.mngytdataapi.services.ChannelService;


import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelSDJpaService implements ChannelService {
    private final ChannelRepository channelRepository;

    public ChannelSDJpaService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public List<Channel> findAll() {
        List<Channel> channels = new ArrayList<>();
        channelRepository.findAll().forEach(channels::add);
        return channels;
    }

    @Override
    public Channel findById(Long aLong) {
        return channelRepository.findById(aLong).orElse(null);
    }

    @Override
    public Channel save(Channel object) {
        return channelRepository.save(object);
    }

    @Override
    public void delete(Channel object) {
        channelRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        channelRepository.deleteById(aLong);
    }
}
