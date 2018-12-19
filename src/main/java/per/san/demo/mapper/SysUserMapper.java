package per.san.demo.mapper;

import org.apache.ibatis.annotations.Param;
import per.san.demo.domain.SysUser;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * description: 用户信息
 *
 * @author sanchar
 * @date 2018-12-18 01:43
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-18 01:43
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * description: 批量删除
     * @param ids 删除数据的id数组
     * @return 删除成功的条数
     */
    Integer deleteBatch(@Param("ids") List<Long> ids);

}
