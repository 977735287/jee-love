package per.san.demo.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.demo.domain.SysUser;
import per.san.demo.mapper.SysUserMapper;
import per.san.demo.service.ISysUserService;

import java.util.List;

/**
 * description: 用户信息
 *
 * @author sanchar
 * @date 2018-12-18 01:43
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-18 01:43
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
}
