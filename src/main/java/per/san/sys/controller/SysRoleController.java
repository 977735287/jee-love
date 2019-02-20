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
import per.san.sys.domain.SysRole;
import per.san.sys.service.ISysRoleService;
import java.util.List;

/**
 * description: 角色信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@RestController
@RequestMapping("/v1/sys/role")
public class SysRoleController {

    @Autowired
    ISysRoleService iSysRoleService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody SysRole sysRole) {
    return new ResponseEntity<>(iSysRoleService.add(sysRole), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysRoleService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iSysRoleService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody SysRole sysRole) {
        return new ResponseEntity<>(iSysRoleService.update(sysRole), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<SysRole>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String roleName,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) Integer isEnabled,
            @RequestParam(required = false) Integer isModified,
            @RequestParam(required = false) Integer isEnableForbidden,
            @RequestParam(required = false) Integer isBuiltIn
            ) {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName(roleName);
        sysRole.setCode(code);
        sysRole.setDescription(description);
        sysRole.setLevel(level);
        sysRole.setIsEnabled(isEnabled);
        sysRole.setIsModified(isModified);
        sysRole.setIsEnableForbidden(isEnableForbidden);
        sysRole.setIsBuiltIn(isBuiltIn);
        return new ResponseEntity<>(iSysRoleService.pageQuery(pageRequest, sysRole), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<SysRole>> queryList(
            @RequestParam(required = false) String roleName,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) Integer isEnabled,
            @RequestParam(required = false) Integer isModified,
            @RequestParam(required = false) Integer isEnableForbidden,
            @RequestParam(required = false) Integer isBuiltIn
            ) {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName(roleName);
        sysRole.setCode(code);
        sysRole.setDescription(description);
        sysRole.setLevel(level);
        sysRole.setIsEnabled(isEnabled);
        sysRole.setIsModified(isModified);
        sysRole.setIsEnableForbidden(isEnableForbidden);
        sysRole.setIsBuiltIn(isBuiltIn);
        return new ResponseEntity<>(iSysRoleService.queryList(sysRole), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<SysRole> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysRoleService.queryById(id), HttpStatus.OK);
    }
}
