package per.san.sys.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * description: 权限信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Table(name="sys_permission")
public class SysPermission extends BaseDomain {

    /**
    *
    */
    @Id
    private Long id;

    /**
    *权限的标识
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;

    /**
    *权限对应的api路径
    */
    @Column(name = "path",columnDefinition = "VARCHAR")
    private String path;

    /**
    *请求的http方法
    */
    @Column(name = "method",columnDefinition = "VARCHAR")
    private String method;

    /**
    *权限的层级
    */
    @Column(name = "level",columnDefinition = "VARCHAR")
    private String level;

    /**
    *权限描述
    */
    @Column(name = "description",columnDefinition = "VARCHAR")
    private String description;

    /**
    *权限对应的方法名
    */
    @Column(name = "action",columnDefinition = "VARCHAR")
    private String action;

    /**
    *权限资源类型
    */
    @Column(name = "resource",columnDefinition = "VARCHAR")
    private String resource;

    /**
    *是否公开的权限
    */
    @Column(name = "public_access",columnDefinition = "BIGINT")
    private Long publicAccess;

    /**
    *是否需要登录才能访问的权限
    */
    @Column(name = "login_access",columnDefinition = "BIGINT")
    private Long loginAccess;

    /**
    *权限所在的服务名称
    */
    @Column(name = "service_name",columnDefinition = "VARCHAR")
    private String serviceName;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResource() {
        return this.resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getPublicAccess() {
        return this.publicAccess;
    }

    public void setPublicAccess(Long publicAccess) {
        this.publicAccess = publicAccess;
    }

    public Long getLoginAccess() {
        return this.loginAccess;
    }

    public void setLoginAccess(Long loginAccess) {
        this.loginAccess = loginAccess;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", resource='" + resource + '\'' +
                ", publicAccess=" + publicAccess +
                ", loginAccess=" + loginAccess +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
