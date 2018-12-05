package per.san.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.domain.Demo;
import per.san.mapper.DemoMapper;
import per.san.service.IDemoService;

import java.util.List;

@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    DemoMapper demoMapper;

    @Override
    public List<Demo> select() {
        return demoMapper.select();
    }
}
