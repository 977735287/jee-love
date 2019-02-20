package per.san.sys.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * description: 角色信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Table(name="sys_role")
public class SysRole extends BaseDomain {

    /**
    *
    */
    @Id
    private Long id;

    /**
    *角色名
    */
    @Column(name = "role_name",columnDefinition = "VARCHAR")
    private String roleName;

    /**
    *角色编码
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;

    /**
    *角色描述full description
    */
    @Column(name = "description",columnDefinition = "VARCHAR")
    private String description;

    /**
    *角色级别
    */
    @Column(name = "level",columnDefinition = "VARCHAR")
    private String level;

    /**
    *是否启用。1启用，0未启用
    */
    @Column(name = "is_enabled",columnDefinition = "TINYINT")
    private Integer isEnabled;

    /**
    *是否可以修改。1表示可以，0不可以
    */
    @Column(name = "is_modified",columnDefinition = "TINYINT")
    private Integer isModified;

    /**
    *是否可以被禁用
    */
    @Column(name = "is_enable_forbidden",columnDefinition = "TINYINT")
    private Integer isEnableForbidden;

    /**
    *是否内置。1表示是，0表示不是
    */
    @Column(name = "is_built_in",columnDefinition = "TINYINT")
    private Integer isBuiltIn;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getIsModified() {
        return this.isModified;
    }

    public void setIsModified(Integer isModified) {
        this.isModified = isModified;
    }

    public Integer getIsEnableForbidden() {
        return this.isEnableForbidden;
    }

    public void setIsEnableForbidden(Integer isEnableForbidden) {
        this.isEnableForbidden = isEnableForbidden;
    }

    public Integer getIsBuiltIn() {
        return this.isBuiltIn;
    }

    public void setIsBuiltIn(Integer isBuiltIn) {
        this.isBuiltIn = isBuiltIn;
    }

}
