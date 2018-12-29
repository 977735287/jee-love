package per.san.sys.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: 用户信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@Table(name="sys_user")
public class SysUser extends BaseDomain {

    /**
    *
    */
    @Id
    private Long id;

    /**
    *用户名
    */
    @Column(name = "user_name",columnDefinition = "VARCHAR")
    private String userName;

    /**
    *Hash后的用户密码
    */
    @Column(name = "password",columnDefinition = "VARCHAR")
    private String password;

    /**
    *电子邮箱地址
    */
    @Column(name = "email",columnDefinition = "VARCHAR")
    private String email;

    /**
    *手机号
    */
    @Column(name = "phone",columnDefinition = "VARCHAR")
    private String phone;

    /**
    *用户真实姓名
    */
    @Column(name = "real_name",columnDefinition = "VARCHAR")
    private String realName;

    /**
    *用户头像url
    */
    @Column(name = "image_url",columnDefinition = "VARCHAR")
    private String imageUrl;

    /**
    *用户二进制头像
    */
    @Column(name = "profile_photo",columnDefinition = "LONGTEXT")
    private String profilePhoto;

    /**
    *语言
    */
    @Column(name = "language",columnDefinition = "VARCHAR")
    private String language;

    /**
    *时区
    */
    @Column(name = "time_zone",columnDefinition = "VARCHAR")
    private String timeZone;

    /**
    *上一次密码更新时间
    */
    @Column(name = "last_password_updated_at",columnDefinition = "DATETIME")
    private Date lastPasswordUpdatedAt;

    /**
    *上一次登陆时间
    */
    @Column(name = "last_login_at",columnDefinition = "DATETIME")
    private Date lastLoginAt;

    /**
    *用户是否启用。1启用，0未启用
    */
    @Column(name = "is_enabled",columnDefinition = "TINYINT")
    private Integer isEnabled;

    /**
    *是否锁定账户
    */
    @Column(name = "is_locked",columnDefinition = "TINYINT")
    private Integer isLocked;

    /**
    *是否为管理员用户。1表示是，0表示不是
    */
    @Column(name = "is_admin",columnDefinition = "TINYINT")
    private Integer isAdmin;

    /**
    *锁定账户截止时间
    */
    @Column(name = "locked_until_at",columnDefinition = "DATETIME")
    private Date lockedUntilAt;

    /**
    *密码输错累积次数
    */
    @Column(name = "password_attempt",columnDefinition = "TINYINT")
    private Integer passwordAttempt;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfilePhoto() {
        return this.profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Date getLastPasswordUpdatedAt() {
        return this.lastPasswordUpdatedAt;
    }

    public void setLastPasswordUpdatedAt(Date lastPasswordUpdatedAt) {
        this.lastPasswordUpdatedAt = lastPasswordUpdatedAt;
    }

    public Date getLastLoginAt() {
        return this.lastLoginAt;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public Integer getIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getIsLocked() {
        return this.isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getLockedUntilAt() {
        return this.lockedUntilAt;
    }

    public void setLockedUntilAt(Date lockedUntilAt) {
        this.lockedUntilAt = lockedUntilAt;
    }

    public Integer getPasswordAttempt() {
        return this.passwordAttempt;
    }

    public void setPasswordAttempt(Integer passwordAttempt) {
        this.passwordAttempt = passwordAttempt;
    }

}
