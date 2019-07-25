package newthread.votesystem.mappers;

import newthread.votesystem.bean.Result;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ResultMapper extends Mapper<Result> {
}