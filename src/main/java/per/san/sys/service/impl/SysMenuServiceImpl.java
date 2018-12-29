package per.san.sys.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysMenu;
import per.san.sys.mapper.SysMenuMapper;
import per.san.sys.service.ISysMenuService;

import java.util.List;

/**
 * description: 菜单信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public Integer add(SysMenu sysMenu) {
        return sysMenuMapper.insertSelective(sysMenu);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return sysMenuMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public PageInfo<SysMenu> pageQuery(PageRequest pageRequest, SysMenu sysMenu) {
        return PageHelper.doPage(pageRequest, () -> sysMenuMapper.select(sysMenu));
    }

    @Override
    public List<SysMenu> queryList(SysMenu sysMenu) {
        return sysMenuMapper.select(sysMenu);
    }

    @Override
    public SysMenu queryById(Long id) {
    return sysMenuMapper.selectByPrimaryKey(id);
    }
}
