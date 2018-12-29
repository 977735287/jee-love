package per.san.sys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import java.util.Date;

/**
 * description: 基本字段
 *
 * @author sanchar
 * @date 12/28/2018 08:52
 * lastUpdateBy: sanchar
 * lastUpdateDate: 12/28/2018
 */
public class BaseDomain {

    /**
     *创建人
     */
    @JsonIgnore
    @Column(name = "created_by",columnDefinition = "BIGINT")
    private Long createdBy;

    /**
     *创建时间
     */
    @JsonIgnore
    @Column(name = "creation_date",columnDefinition = "DATETIME")
    private Date creationDate;

    /**
     *更新人
     */
    @JsonIgnore
    @Column(name = "last_updated_by",columnDefinition = "BIGINT")
    private Long lastUpdatedBy;

    /**
     *更新时间
     */
    @JsonIgnore
    @Column(name = "last_update_date",columnDefinition = "DATETIME")
    private Date lastUpdateDate;

    /**
     *删除状态，1表示是，0表示否
     */
    @JsonIgnore
    @Column(name = "is_deleted",columnDefinition = "TINYINT")
    private Integer isDeleted;

    /**
     *版本控制
     */
    @JsonIgnore
    @Column(name = "object_version_number",columnDefinition = "BIGINT")
    private Long objectVersionNumber;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute_category",columnDefinition = "VARCHAR")
    private String attributeCategory;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute1",columnDefinition = "VARCHAR")
    private String attribute1;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute2",columnDefinition = "VARCHAR")
    private String attribute2;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute3",columnDefinition = "VARCHAR")
    private String attribute3;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute4",columnDefinition = "VARCHAR")
    private String attribute4;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute5",columnDefinition = "VARCHAR")
    private String attribute5;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute6",columnDefinition = "VARCHAR")
    private String attribute6;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute7",columnDefinition = "VARCHAR")
    private String attribute7;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute8",columnDefinition = "VARCHAR")
    private String attribute8;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute9",columnDefinition = "VARCHAR")
    private String attribute9;

    /**
     *弹性域字段
     */
    @JsonIgnore
    @Column(name = "attribute10",columnDefinition = "VARCHAR")
    private String attribute10;

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getObjectVersionNumber() {
        return this.objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public String getAttributeCategory() {
        return this.attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttribute1() {
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return this.attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return this.attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return this.attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return this.attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

}
