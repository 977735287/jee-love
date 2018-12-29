package per.san.sys.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysUser;
import per.san.sys.service.ISysUserService;

import java.util.Date;
import java.util.List;

/**
 * description: 用户信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@RestController
@RequestMapping("/v1/sys/user")
public class SysUserController {

    @Autowired
    ISysUserService iSysUserService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody SysUser sysUser) {
    return new ResponseEntity<>(iSysUserService.add(sysUser), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysUserService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iSysUserService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody SysUser sysUser) {
        return new ResponseEntity<>(iSysUserService.update(sysUser), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<SysUser>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String realName,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) String profilePhoto,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String timeZone,
            @RequestParam(required = false) Date lastPasswordUpdatedAt,
            @RequestParam(required = false) Date lastLoginAt,
            @RequestParam(required = false) Integer isEnabled,
            @RequestParam(required = false) Integer isLocked,
            @RequestParam(required = false) Integer isAdmin,
            @RequestParam(required = false) Date lockedUntilAt,
            @RequestParam(required = false) Integer passwordAttempt
            ) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        sysUser.setEmail(email);
        sysUser.setPhone(phone);
        sysUser.setRealName(realName);
        sysUser.setImageUrl(imageUrl);
        sysUser.setProfilePhoto(profilePhoto);
        sysUser.setLanguage(language);
        sysUser.setTimeZone(timeZone);
        sysUser.setLastPasswordUpdatedAt(lastPasswordUpdatedAt);
        sysUser.setLastLoginAt(lastLoginAt);
        sysUser.setIsEnabled(isEnabled);
        sysUser.setIsLocked(isLocked);
        sysUser.setIsAdmin(isAdmin);
        sysUser.setLockedUntilAt(lockedUntilAt);
        sysUser.setPasswordAttempt(passwordAttempt);
        return new ResponseEntity<>(iSysUserService.pageQuery(pageRequest, sysUser), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<SysUser>> queryList(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String realName,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) String profilePhoto,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String timeZone,
            @RequestParam(required = false) Date lastPasswordUpdatedAt,
            @RequestParam(required = false) Date lastLoginAt,
            @RequestParam(required = false) Integer isEnabled,
            @RequestParam(required = false) Integer isLocked,
            @RequestParam(required = false) Integer isAdmin,
            @RequestParam(required = false) Date lockedUntilAt,
            @RequestParam(required = false) Integer passwordAttempt
            ) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        sysUser.setEmail(email);
        sysUser.setPhone(phone);
        sysUser.setRealName(realName);
        sysUser.setImageUrl(imageUrl);
        sysUser.setProfilePhoto(profilePhoto);
        sysUser.setLanguage(language);
        sysUser.setTimeZone(timeZone);
        sysUser.setLastPasswordUpdatedAt(lastPasswordUpdatedAt);
        sysUser.setLastLoginAt(lastLoginAt);
        sysUser.setIsEnabled(isEnabled);
        sysUser.setIsLocked(isLocked);
        sysUser.setIsAdmin(isAdmin);
        sysUser.setLockedUntilAt(lockedUntilAt);
        sysUser.setPasswordAttempt(passwordAttempt);
        return new ResponseEntity<>(iSysUserService.queryList(sysUser), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<SysUser> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysUserService.queryById(id), HttpStatus.OK);
    }
}
