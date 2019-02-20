package per.san.sys.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * description: 菜单信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Table(name="sys_menu")
public class SysMenu extends BaseDomain {

    /**
    *
    */
    @Id
    private Long id;

    /**
    *菜单的标识
    */
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;

    /**
    *菜单名
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;

    /**
    *菜单层级
    */
    @Column(name = "level",columnDefinition = "VARCHAR")
    private String level;

    /**
    *父级菜单id
    */
    @Column(name = "parent_id",columnDefinition = "BIGINT")
    private Long parentId;

    /**
    *菜单类型， 包括三种（root, dir, menu）
    */
    @Column(name = "type",columnDefinition = "VARCHAR")
    private String type;

    /**
    *菜单顺序
    */
    @Column(name = "sort",columnDefinition = "BIGINT")
    private Long sort;

    /**
    *是否是默认菜单,0不是默认菜单，1是默认菜单
    */
    @Column(name = "is_default",columnDefinition = "TINYINT")
    private Integer isDefault;

    /**
    *图标的code值
    */
    @Column(name = "icon",columnDefinition = "VARCHAR")
    private String icon;

    /**
    *路由
    */
    @Column(name = "route",columnDefinition = "VARCHAR")
    private String route;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSort() {
        return this.sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Integer getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

}
