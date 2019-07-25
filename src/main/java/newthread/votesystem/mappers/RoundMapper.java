package newthread.votesystem.mappers;

import newthread.votesystem.bean.Round;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface RoundMapper extends Mapper<Round> {
}