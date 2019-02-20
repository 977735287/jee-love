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
import per.san.sys.domain.SysPermission;
import per.san.sys.service.ISysPermissionService;
import java.util.List;

/**
 * description: 权限信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@RestController
@RequestMapping("/v1/sys/permission")
public class SysPermissionController {

    @Autowired
    ISysPermissionService iSysPermissionService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody SysPermission sysPermission) {
    return new ResponseEntity<>(iSysPermissionService.add(sysPermission), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysPermissionService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iSysPermissionService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody SysPermission sysPermission) {
        return new ResponseEntity<>(iSysPermissionService.update(sysPermission), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<SysPermission>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String method,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) String resource,
            @RequestParam(required = false) Long publicAccess,
            @RequestParam(required = false) Long loginAccess,
            @RequestParam(required = false) String serviceName
            ) {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setCode(code);
        sysPermission.setPath(path);
        sysPermission.setMethod(method);
        sysPermission.setLevel(level);
        sysPermission.setDescription(description);
        sysPermission.setAction(action);
        sysPermission.setResource(resource);
        sysPermission.setPublicAccess(publicAccess);
        sysPermission.setLoginAccess(loginAccess);
        sysPermission.setServiceName(serviceName);
        return new ResponseEntity<>(iSysPermissionService.pageQuery(pageRequest, sysPermission), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<SysPermission>> queryList(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String method,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) String resource,
            @RequestParam(required = false) Long publicAccess,
            @RequestParam(required = false) Long loginAccess,
            @RequestParam(required = false) String serviceName
            ) {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setCode(code);
        sysPermission.setPath(path);
        sysPermission.setMethod(method);
        sysPermission.setLevel(level);
        sysPermission.setDescription(description);
        sysPermission.setAction(action);
        sysPermission.setResource(resource);
        sysPermission.setPublicAccess(publicAccess);
        sysPermission.setLoginAccess(loginAccess);
        sysPermission.setServiceName(serviceName);
        return new ResponseEntity<>(iSysPermissionService.queryList(sysPermission), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<SysPermission> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysPermissionService.queryById(id), HttpStatus.OK);
    }
}
