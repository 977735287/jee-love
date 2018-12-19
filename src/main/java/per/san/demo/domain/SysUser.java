package per.san.demo.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: 用户信息
 *
 * @author sanchar
 * @date 2018-12-18 01:43
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-18 01:43
 */
@Table(name="sys_user")
public class SysUser {

    /**
    *用户id
    */
    @Id
    private Long userId;

    /**
    *用户名
    */
    @Column(name = "user_name",columnDefinition = "VARCHAR")
    private String userName;

    /**
    *密码
    */
    @Column(name = "password",columnDefinition = "VARCHAR")
    private String password;

    /**
    *是否管理员
    */
    @Column(name = "is_admin",columnDefinition = "TINYINT")
    private Integer isAdmin;

    /**
    *内容
    */
    @Column(name = "content",columnDefinition = "LONGTEXT")
    private String content;

    /**
    *创建时间
    */
    @Column(name = "create_date",columnDefinition = "DATETIME")
    private Date createDate;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
