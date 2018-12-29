package per.san.sys.mapper;

import org.apache.ibatis.annotations.Param;
import per.san.sys.domain.SysMenu;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * description: 菜单信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * description: 批量删除
     * @param ids 删除数据的id数组
     * @return 删除成功的条数
     */
    Integer deleteBatch(@Param("ids") List<Long> ids);

}
