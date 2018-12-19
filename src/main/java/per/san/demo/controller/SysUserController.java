package per.san.demo.controller;

import com.github.pagehelper.PageInfo;
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
import per.san.demo.domain.SysUser;
import per.san.demo.service.ISysUserService;

import java.util.Date;
import java.util.List;

/**
 * description: 用户信息
 *
 * @author sanchar
 * @date 2018-12-18 01:43
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-18 01:43
 */
@RestController
@RequestMapping("/v1/sys/user")
public class SysUserController {

    @Autowired
    ISysUserService iSysUserService;

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody SysUser sysUser) {
    return new ResponseEntity<>(iSysUserService.add(sysUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysUserService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iSysUserService.deleteBatch(ids), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody SysUser sysUser) {
        return new ResponseEntity<>(iSysUserService.update(sysUser), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<PageInfo<SysUser>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) Integer isAdmin,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) Date createDate
            ) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        sysUser.setIsAdmin(isAdmin);
        sysUser.setContent(content);
        sysUser.setCreateDate(createDate);
        return new ResponseEntity<>(iSysUserService.pageQuery(pageRequest, sysUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SysUser>> queryList(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) Integer isAdmin,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) Date createDate
            ) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        sysUser.setIsAdmin(isAdmin);
        sysUser.setContent(content);
        sysUser.setCreateDate(createDate);
        return new ResponseEntity<>(iSysUserService.queryList(sysUser), HttpStatus.OK);
    }
}
