package png.springframework.mngytdataapi.repositories;

import org.springframework.data.repository.CrudRepository;
import png.springframework.mngytdataapi.model.Channel;


public interface ChannelRepository extends CrudRepository<Channel, Long> {
}
