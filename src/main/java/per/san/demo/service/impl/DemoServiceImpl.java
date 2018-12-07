package per.san.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.demo.domain.Demo;
import per.san.demo.mapper.DemoMapper;
import per.san.demo.service.IDemoService;

import java.util.List;

@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    DemoMapper demoMapper;

    @Override
    public List<Demo> select() {
        return demoMapper.select(new Demo());
    }

}
