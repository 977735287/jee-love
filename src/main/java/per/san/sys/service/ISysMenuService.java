package per.san.sys.service;

import com.github.pagehelper.PageInfo;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysMenu;

import java.util.List;

/**
 * description: 菜单信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
public interface ISysMenuService {

    /**
     * description: 新增
     * @param sysMenu 新增的信息
     * @return 新增成功的条数
     */
    Integer add(SysMenu sysMenu);

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
    * @param sysMenu 更新的信息
    * @return 更新成功的条数
    */
    Integer update(SysMenu sysMenu);

    /**
    * description: 分页查询
    * @param pageRequest 分页查询参数
    * @param sysMenu 分页查询条件
    * @return 分页数据
    */
    PageInfo<SysMenu> pageQuery(PageRequest pageRequest, SysMenu sysMenu);

    /**
    * description: 查询List
    * @param sysMenu 查询条件
    * @return 数据List
    */
    List<SysMenu> queryList(SysMenu sysMenu);

    /**
    * description: 根据ID查询
    * @param id 查询数据的ID
    * @return 数据对象
    */
    SysMenu queryById(Long id);

}
