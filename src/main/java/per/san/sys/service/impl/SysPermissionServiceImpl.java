package per.san.sys.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysPermission;
import per.san.sys.mapper.SysPermissionMapper;
import per.san.sys.service.ISysPermissionService;

import java.util.List;

/**
 * description: 权限信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Override
    public Integer add(SysPermission sysPermission) {
        return sysPermissionMapper.insertSelective(sysPermission);
    }

    @Override
    public Integer addBatch(List<SysPermission> sysPermissions) {
        return sysPermissionMapper.insertBatch(sysPermissions);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return sysPermissionMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    }

    @Override
    public Integer updateBatch(List<SysPermission> sysPermissions) {
        return sysPermissionMapper.updateBatch(sysPermissions);
    }

    @Override
    public PageInfo<SysPermission> pageQuery(PageRequest pageRequest, SysPermission sysPermission) {
        return PageHelper.doPage(pageRequest, () -> sysPermissionMapper.select(sysPermission));
    }

    @Override
    public List<SysPermission> queryList(SysPermission sysPermission) {
        return sysPermissionMapper.select(sysPermission);
    }

    @Override
    public SysPermission queryById(Long id) {
    return sysPermissionMapper.selectByPrimaryKey(id);
    }
}
