package per.san.sys.mapper;

import org.apache.ibatis.annotations.Param;
import per.san.sys.domain.SysPermission;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * description: 权限信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * description: 批量新增
     * @param sysPermissions 新增的信息
     * @return 新增成功的条数
     */
    Integer insertBatch(@Param("sysPermissions") List<SysPermission> sysPermissions);

    /**
     * description: 批量删除
     * @param ids 删除数据的id数组
     * @return 删除成功的条数
     */
    Integer deleteBatch(@Param("ids") List<Long> ids);

    /**
     * description: 批量更新
     * @param sysPermissions 更新的信息
     * @return 更新成功的条数
     */
    Integer updateBatch(@Param("sysPermissions") List<SysPermission> sysPermissions);

    /**
     * description: 查询所有不公开的接口权限信息(不包含登陆即可访问的接口信息)
     * @return 权限信息列表
     */
    List<SysPermission> selectAllProtectPermission();

    /**
     * description: 查询所有公开的接口权限信息
     * @return 权限信息列表
     */
    List<SysPermission> selectAllPublicPermission();

    /**
     * description: 通过用户ID查询用户所拥有的权限
     * @return 权限信息列表
     */
    List<SysPermission> selectPermissionByUserId(@Param("userId") Long userId);

}
