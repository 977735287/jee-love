package per.san.sys.service;

import com.github.pagehelper.PageInfo;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysRole;

import java.util.List;

/**
 * description: 角色信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
public interface ISysRoleService {

    /**
     * description: 新增
     * @param sysRole 新增的信息
     * @return 新增成功的条数
     */
    Integer add(SysRole sysRole);

    /**
     * description: 根据主键id删除
     * @param id 删除数据的id
     * @return 删除成功的条数
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * description: 批量删除
     * @param ids 删除数据的id数组
     * @return 删除成功的条数
     */
    Integer deleteBatch(List<Long> ids);

    /**
    * description: 更新
    * @param sysRole 更新的信息
    * @return 更新成功的条数
    */
    Integer update(SysRole sysRole);

    /**
    * description: 分页查询
    * @param pageRequest 分页查询参数
    * @param sysRole 分页查询条件
    * @return 分页数据
    */
    PageInfo<SysRole> pageQuery(PageRequest pageRequest, SysRole sysRole);

    /**
    * description: 查询List
    * @param sysRole 查询条件
    * @return 数据List
    */
    List<SysRole> queryList(SysRole sysRole);

    /**
    * description: 根据ID查询
    * @param id 查询数据的ID
    * @return 数据对象
    */
    SysRole queryById(Long id);

}
