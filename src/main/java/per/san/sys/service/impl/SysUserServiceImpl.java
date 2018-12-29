package per.san.sys.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysUser;
import per.san.sys.mapper.SysUserMapper;
import per.san.sys.service.ISysUserService;

import java.util.List;

/**
 * description: 用户信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public Integer add(SysUser sysUser) {
        return sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return sysUserMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public PageInfo<SysUser> pageQuery(PageRequest pageRequest, SysUser sysUser) {
        return PageHelper.doPage(pageRequest, () -> sysUserMapper.select(sysUser));
    }

    @Override
    public List<SysUser> queryList(SysUser sysUser) {
        return sysUserMapper.select(sysUser);
    }

    @Override
    public SysUser queryById(Long id) {
    return sysUserMapper.selectByPrimaryKey(id);
    }
}
