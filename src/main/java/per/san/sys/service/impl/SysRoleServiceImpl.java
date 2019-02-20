package per.san.sys.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysRole;
import per.san.sys.mapper.SysRoleMapper;
import per.san.sys.service.ISysRoleService;

import java.util.List;

/**
 * description: 角色信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Integer add(SysRole sysRole) {
        return sysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return sysRoleMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public PageInfo<SysRole> pageQuery(PageRequest pageRequest, SysRole sysRole) {
        return PageHelper.doPage(pageRequest, () -> sysRoleMapper.select(sysRole));
    }

    @Override
    public List<SysRole> queryList(SysRole sysRole) {
        return sysRoleMapper.select(sysRole);
    }

    @Override
    public SysRole queryById(Long id) {
    return sysRoleMapper.selectByPrimaryKey(id);
    }
}
